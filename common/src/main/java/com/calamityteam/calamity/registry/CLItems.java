package com.calamityteam.calamity.registry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

public class CLItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<DyeableArmorItem> THIGH_HIGHS = REGISTRATE.item("thigh_highs",
		p -> new DyeableArmorItem(ArmorMaterials.NETHERITE,EquipmentSlot.LEGS,new Item.Properties()))
		.register();

	// TODO 8/16/2023 : Add dyeable overlay to colored segments

	public static void register() {}
}
