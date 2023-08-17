package com.calamityteam.calamity.registry;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

public class CLDyeableArmorItem extends ArmorItem implements DyeableLeatherItem {
	public CLDyeableArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public int getColor(ItemStack stack) {
		CompoundTag compoundTag = stack.getTagElement("display");
		return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 16099768;
	}
	// fixme armor partially invisible
}
