package com.calamityteam.calamity.base.block.Canister;

import com.calamityteam.calamity.base.item.CanisterItem;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ShulkerBoxMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import net.minecraft.world.WorldlyContainer;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.IntStream;

public class CanisterBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {

	public static final int COLUMNS = 3;
	public static final int ROWS = 3;
	public static final int CONTAINER_SIZE = 9;
	public static final String ITEMS_TAG = "Items";
	private static final int[] SLOTS = IntStream.range(0, 9).toArray();
	private NonNullList<ItemStack> itemStacks;




	public CanisterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
		this.itemStacks = NonNullList.withSize(9, ItemStack.EMPTY);
	}

	public int getContainerSize() {
		return this.itemStacks.size();
	}

	public boolean triggerEvent(int id, int type) {
		if (id == 1) {
			if (type == 0) {

				doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
			}

			if (type == 1) {
				doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
			}

			return true;
		} else {
			return super.triggerEvent(id, type);
		}
	}

	private static void doNeighborUpdates(Level level, BlockPos pos, BlockState state) {
		state.updateNeighbourShapes(level, pos, 3);
	}


	protected Component getDefaultName() {
		return Component.translatable("container.shulkerBox");
	}

	public void load(CompoundTag tag) {
		super.load(tag);
		this.loadFromTag(tag);
	}

	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		if (!this.trySaveLootTable(tag)) {
			ContainerHelper.saveAllItems(tag, this.itemStacks, false);
		}

	}

	public void loadFromTag(CompoundTag tag) {
		this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(tag) && tag.contains("Items", 9)) {
			ContainerHelper.loadAllItems(tag, this.itemStacks);
		}

	}

	protected NonNullList<ItemStack> getItems() {
		return this.itemStacks;
	}

	protected void setItems(NonNullList<ItemStack> itemStacks) {
		this.itemStacks = itemStacks;
	}

	public int[] getSlotsForFace(Direction side) {
		return SLOTS;
	}

	public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
		return !(Block.byItem(itemStack.getItem()) instanceof ShulkerBoxBlock) && !(itemStack.getItem() instanceof CanisterItem);
	}

	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}



	protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
		return new CanisterBlockMenu(containerId, inventory, this);
	}

}
