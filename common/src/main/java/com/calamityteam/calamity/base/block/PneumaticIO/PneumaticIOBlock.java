package com.calamityteam.calamity.base.block.PneumaticIO;

import com.calamityteam.calamity.base.item.CanisterItem;
import com.calamityteam.calamity.registry.CLBlockEntities;
import com.calamityteam.calamity.registry.CLSounds;

import com.simibubi.create.content.equipment.wrench.IWrenchable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

public class PneumaticIOBlock extends Block implements EntityBlock, IWrenchable {

	public static final BooleanProperty FULL = BooleanProperty.create("full");
	public static final BooleanProperty IO = BooleanProperty.create("io");

	public PneumaticIOBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(defaultBlockState().setValue(FULL,false).setValue(IO,false));
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {


		return new PneumaticIOBlockEntity(CLBlockEntities.PNEUMATIC_IO_ENTITY.get(),pos,state);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide()) {
			player.playSound(SoundEvents.METAL_HIT);
			return InteractionResult.SUCCESS;
		}
		if (!(level.getBlockEntity(pos) instanceof PneumaticIOBlockEntity)) return InteractionResult.PASS;
		PneumaticIOBlockEntity be = (PneumaticIOBlockEntity) level.getBlockEntity(pos);

		ItemStack remove;
		ItemStack inHand = player.getItemInHand(hand);
		remove = be.removeCanister(state,level, pos);
		if (inHand.getItem() instanceof CanisterItem) {

			be.setCanister(inHand,state,level, pos);
			player.getInventory().removeItem(inHand);
		}

		if (remove != null) {

			boolean added = player.addItem(remove);
			if (!added) {
				player.drop(remove,false,false);
			}
		}
		return InteractionResult.SUCCESS;
	}


	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FULL);
		builder.add(IO);
		super.createBlockStateDefinition(builder);
	}

	@Override
	public InteractionResult onWrenched(BlockState state, UseOnContext context) {
		if (context.getLevel().isClientSide()) return InteractionResult.SUCCESS;

		context.getLevel().setBlock(context.getClickedPos(),state.setValue(IO,!state.getValue(IO)),3);
		return InteractionResult.SUCCESS;
	}
}
