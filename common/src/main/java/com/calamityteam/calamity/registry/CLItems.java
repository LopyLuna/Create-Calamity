package com.calamityteam.calamity.registry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;

import com.tterrag.registrate.util.entry.ItemEntry;

public class CLItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<? extends CLThighHighItem> THIGH_HIGHS = REGISTRATE.item("thigh_highs",
		p -> new CLThighHighItem(CLArmorMaterials.THIGH_HIGH, EquipmentSlot.LEGS, p))
		.lang("Programmer Thigh Highs")
		.properties(p -> p.rarity(Rarity.EPIC))
		.register();

	public static void register() {
		CLThighHighItem.register();
	}
}
