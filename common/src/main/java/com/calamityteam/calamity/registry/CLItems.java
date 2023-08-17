package com.calamityteam.calamity.registry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DyeableArmorItem;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class CLItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<? extends CLThighHighItem> THIGH_HIGHS = REGISTRATE.item("thigh_highs",
		p -> new CLThighHighItem(CLArmorMaterials.THIGH_HIGH, EquipmentSlot.LEGS, p))
		.register();

	public static void register() {}
}
