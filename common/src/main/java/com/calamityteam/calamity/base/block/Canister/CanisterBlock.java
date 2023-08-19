package com.calamityteam.calamity.base.block.Canister;

import com.calamityteam.calamity.registry.CLBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CanisterBlock extends Block implements EntityBlock {

	public static final ResourceLocation CONTENTS;
	public CanisterBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CanisterBlockEntity(CLBlockEntities.CANISTER_ENTITY.get(),pos,state);
	}


	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		} else if (player.isSpectator()) {
			return InteractionResult.CONSUME;
		} else {
			BlockEntity blockEntity = level.getBlockEntity(pos);
			if (blockEntity instanceof CanisterBlockEntity) {
				CanisterBlockEntity shulkerBoxBlockEntity = (CanisterBlockEntity)blockEntity;

				player.openMenu(shulkerBoxBlockEntity);


				return InteractionResult.CONSUME;
			} else {
				return InteractionResult.PASS;
			}
		}
	}


	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity instanceof CanisterBlockEntity shulkerBoxBlockEntity) {
			if (!level.isClientSide && player.isCreative() && !shulkerBoxBlockEntity.isEmpty()) {
				ItemStack itemStack = this.getCloneItemStack(level,pos,state);
				blockEntity.saveToItem(itemStack);

				ItemEntity itemEntity = new ItemEntity(level, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, itemStack);
				itemEntity.setDefaultPickUpDelay();
				level.addFreshEntity(itemEntity);
			} else {
				shulkerBoxBlockEntity.unpackLootTable(player);
			}
		}

		super.playerWillDestroy(level, pos, state, player);
	}

	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		BlockEntity blockEntity = (BlockEntity)builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
		if (blockEntity instanceof CanisterBlockEntity shulkerBoxBlockEntity) {
			builder = builder.withDynamicDrop(CONTENTS, (context, consumer) -> {
				for(int i = 0; i < shulkerBoxBlockEntity.getContainerSize(); ++i) {
					consumer.accept(shulkerBoxBlockEntity.getItem(i));
				}

			});
		}

		return super.getDrops(state, builder);
	}

	static {
		CONTENTS = new ResourceLocation("contents");
	}
}
