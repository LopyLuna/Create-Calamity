package com.calamityteam.calamity.base.block.Canister;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CanisterBlockMenu extends AbstractContainerMenu {

	private final Container container;
	public CanisterBlockMenu(int containerId, Inventory playerInventory) {
		this(containerId, playerInventory, new SimpleContainer(9));
	}

	public CanisterBlockMenu(int containerId, Inventory playerInventory, Container container) {
		super(MenuType.SHULKER_BOX, containerId);
		checkContainerSize(container, 9);
		this.container = container;
		container.startOpen(playerInventory.player);


		int k;
		int l;
		for(k = 0; k < 3; ++k) {
			for(l = 0; l < 3; ++l) {
				this.addSlot(new ShulkerBoxSlot(container, l + k * 9, 8 + l * 18, 18 + k * 18));
			}
		}

		for(k = 0; k < 3; ++k) {
			for(l = 0; l < 9; ++l) {
				this.addSlot(new Slot(playerInventory, l + k * 9 + 9, 8 + l * 18, 84 + k * 18));
			}
		}

		for(k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}

	}

	public boolean stillValid(Player player) {
		return this.container.stillValid(player);
	}

	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemStack = ItemStack.EMPTY;
		Slot slot = (Slot)this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemStack2 = slot.getItem();
			itemStack = itemStack2.copy();
			if (index < this.container.getContainerSize()) {
				if (!this.moveItemStackTo(itemStack2, this.container.getContainerSize(), this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemStack2, 0, this.container.getContainerSize(), false)) {
				return ItemStack.EMPTY;
			}

			if (itemStack2.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}

		return itemStack;
	}

	public void removed(Player player) {
		super.removed(player);
		this.container.stopOpen(player);
	}
}
