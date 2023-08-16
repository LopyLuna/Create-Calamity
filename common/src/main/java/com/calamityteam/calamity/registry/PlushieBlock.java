package com.calamityteam.calamity.registry;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

public class PlushieBlock extends HorizontalDirectionalBlock {
	private final @Nullable List<SoundEvent> sounds;

	public PlushieBlock(Properties properties, @Nullable List<SoundEvent> sounds) {
		super(properties);
		this.registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
		this.sounds = sounds;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
	}


	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide()) return super.use(state, level, pos, player, hand, hit);
		if (this.sounds == null || sounds.isEmpty()) return InteractionResult.SUCCESS;

		int random = level.getRandom().nextInt(sounds.size() - 1);
		level.playSound(null, pos, this.sounds.get(random), SoundSource.BLOCKS, 2f, 1f);

		return InteractionResult.SUCCESS;
	}
}
