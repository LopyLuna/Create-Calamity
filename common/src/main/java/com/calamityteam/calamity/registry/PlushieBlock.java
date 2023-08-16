package com.calamityteam.calamity.registry;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class PlushieBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PlushieBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
	}
}
