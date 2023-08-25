package com.calamityteam.calamity.base.block.PneumaticIO;

import com.simibubi.create.content.equipment.wrench.IWrenchable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PneumaticIOBlockEntity extends BlockEntity implements IWrenchable {
	public ItemStack Canister;
	public PneumaticIOBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
		Canister = ItemStack.EMPTY;
	}

	public ItemStack removeCanister(BlockState state, Level level,  BlockPos pos) {
		ItemStack old = Canister;
		this.Canister = ItemStack.EMPTY;
		update(state, level, pos);


		return old;
	}

	public void setCanister(ItemStack set, BlockState state, Level level,  BlockPos pos) {
		this.Canister = set;
		System.out.println("Printing canister 2");
		System.out.println(Canister);
		update(state, level, pos);
	}

	public void update(BlockState blockState, Level level, BlockPos pos) {

		level.setBlock(pos,blockState.setValue(PneumaticIOBlock.FULL,Canister!=ItemStack.EMPTY),3);
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		System.out.println("Printing canistter");
		System.out.println(Canister);
		Canister.save(tag);

		super.saveAdditional(tag);
	}

	@Override
	public void load(CompoundTag tag) {
		Canister = ItemStack.of(tag);
		super.load(tag);
	}

	public ItemStack getCanister() {
		return this.Canister;
	}


}
