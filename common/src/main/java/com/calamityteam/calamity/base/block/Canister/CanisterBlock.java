package com.calamityteam.calamity.base.block.Canister;

import com.calamityteam.calamity.registry.CLBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.ShulkerBoxBlock;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

public class CanisterBlock extends Block implements EntityBlock {


	public CanisterBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CanisterBlockEntity(CLBlockEntities.CANISTER_ENTITY.get(),pos,state);
	}



}
