package com.calamityteam.calamity.base.block.entities;

import com.calamityteam.calamity.registry.CLPlushies;

import com.jozufozu.flywheel.core.PartialModel;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PlushieBlockEntity extends BlockEntity {
	public CLPlushies.PlushieEntry entry;
	public PlushieBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState, CLPlushies.PlushieEntry entry) {
		super(type, pos, blockState);
		this.entry = entry;
	}
	public PlushieBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		this(type, pos, blockState, CLPlushies.PLUSHIES.get("herobrine").entry());
	}

	public PartialModel getPartial() {
		return entry.model();
	}
}
