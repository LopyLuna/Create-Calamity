package com.calamityteam.calamity.base.block.PneumaticIO;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PneumaticIOBlockEntity extends BlockEntity {
	public ItemStack Canister;
	public PneumaticIOBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	public ItemStack removeCanister() {
		ItemStack old = Canister;
		this.Canister = null;
		return old;
	}

	public void setCanister(ItemStack set) {
		this.Canister = set;
	}

	public ItemStack getCanister() {
		return this.Canister;
	}
}
