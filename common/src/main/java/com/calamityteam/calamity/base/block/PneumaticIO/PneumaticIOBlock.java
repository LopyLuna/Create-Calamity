package com.calamityteam.calamity.base.block.PneumaticIO;

import com.calamityteam.calamity.base.item.CanisterItem;
import com.calamityteam.calamity.registry.CLBlockEntities;
import com.calamityteam.calamity.registry.CLSounds;

import com.simibubi.create.content.equipment.wrench.IWrenchable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.Nullable;

public class PneumaticIOBlock extends Block implements EntityBlock, IWrenchable {

	public PneumaticIOBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {


		return new PneumaticIOBlockEntity(CLBlockEntities.PNEUMATIC_IO_ENTITY.get(),pos,state);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide()) return InteractionResult.SUCCESS;
		if (!(level.getBlockEntity(pos) instanceof PneumaticIOBlockEntity)) return InteractionResult.PASS;
		PneumaticIOBlockEntity be = (PneumaticIOBlockEntity) level.getBlockEntity(pos);

		ItemStack remove;
		ItemStack inHand = player.getItemInHand(hand);
		remove = be.removeCanister();
		if (inHand.getItem() instanceof CanisterItem) {
			be.setCanister(inHand);
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
}
