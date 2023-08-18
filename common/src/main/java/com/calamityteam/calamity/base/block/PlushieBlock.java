package com.calamityteam.calamity.base.block;

import java.util.List;

import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;
import com.calamityteam.calamity.registry.CLPlushies;
import com.calamityteam.calamity.registry.CLSounds;

import net.minecraft.util.Mth;
import net.minecraft.world.level.block.EntityBlock;

import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

import com.tterrag.registrate.util.entry.RegistryEntry;

public class PlushieBlock extends Block implements EntityBlock {
	private final @Nullable List<RegistryEntry<SoundEvent>> sounds;

	// skullspired
	public static final int MAX = 15;
	private static final int ROTATIONS = 16;
	public static final IntegerProperty ROTATION = BlockStateProperties.ROTATION_16;
	protected static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

	public CLPlushies.PlushieEntry entry;

	public PlushieBlock(Properties properties, CLPlushies.PlushieEntry entry) {
		super(properties);
		this.registerDefaultState(defaultBlockState().setValue(ROTATION, 0));
		this.sounds = entry.sounds();
		this.entry = entry;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return (BlockState)this.defaultBlockState().setValue(ROTATION, Mth.floor((double)(context.getRotation() * 16.0f / 360.0f) + 0.5) & 0xF);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return (BlockState)state.setValue(ROTATION, rotation.rotate(state.getValue(ROTATION), 16));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return (BlockState)state.setValue(ROTATION, mirror.mirror(state.getValue(ROTATION), 16));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ROTATION);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide()) return InteractionResult.SUCCESS;

		if (this.sounds == null || this.sounds.isEmpty()) {
			level.playSound(null, pos, CLSounds.PLUSHIE_DEFAULT.get(), SoundSource.BLOCKS, 2f, 1f);

		} else {
			int index = 0;
			if (this.sounds.size() > 1) index = level.getRandom().nextInt(this.sounds.size());
			level.playSound(null, pos, this.sounds.get(index).get(), SoundSource.BLOCKS, 2f, 1f);
		}
		return InteractionResult.SUCCESS;
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new PlushieBlockEntity(CLPlushies.PLUSHIE_ENTITY.get(), pos, state, entry);
	}
}
