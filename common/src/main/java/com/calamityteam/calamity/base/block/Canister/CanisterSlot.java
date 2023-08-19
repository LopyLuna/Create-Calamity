package com.calamityteam.calamity.base.block.Canister;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CanisterSlot extends Slot {
	public CanisterSlot(Container container, int slot, int x, int y) {
		super(container, slot, x, y);
	}

	public boolean mayPlace(ItemStack stack) {
		return stack.getItem().canFitInsideContainerItems();
	}
}
