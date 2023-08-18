package com.calamityteam.calamity.registry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

import com.calamityteam.calamity.base.item.ThighHighItem;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;

import com.tterrag.registrate.util.entry.ItemEntry;

public class CLItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<? extends ThighHighItem> THIGH_HIGHS = REGISTRATE.item("thigh_highs",
		p -> new ThighHighItem(CLArmorMaterials.WOOL, 0.5d, EquipmentSlot.LEGS, p))
		.lang("Thigh Highs").properties(p -> p.rarity(Rarity.EPIC)).register();

	public static final ItemEntry<? extends ThighHighItem> NETHERITE_THIGH_HIGHS = REGISTRATE.item("netherite_thigh_highs",
		p -> new ThighHighItem(CLArmorMaterials.NETHERITE, 1.0d, EquipmentSlot.LEGS,p))
		.lang("Programmer Thigh Highs").properties(p -> p.rarity(Rarity.EPIC)).register();

	public static void register() {
	}
}
