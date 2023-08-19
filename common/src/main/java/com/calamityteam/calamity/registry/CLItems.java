package com.calamityteam.calamity.registry;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

import com.calamityteam.calamity.base.item.thigh_high.MaidArmorItem;

import com.calamityteam.calamity.base.item.thigh_high.ThighHighColor;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;

import com.tterrag.registrate.util.entry.ItemEntry;

public class CLItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}
	/* Maid Armor set:
		Full set grants +50% speed
		Full set grants goggles functionality
		Full set cannot be unequipped
	 */
	public static final ItemEntry<? extends MaidArmorItem> THIGH_HIGHS = REGISTRATE.item("thigh_highs",
		p -> new MaidArmorItem(CLArmorMaterials.WOOL, EquipmentSlot.LEGS, p))
		.lang("Thigh Highs")
		.properties(p -> p.rarity(Rarity.EPIC))
		.color(() -> ThighHighColor::new)
		.register();

	public static final ItemEntry<? extends MaidArmorItem> NETHERITE_THIGH_HIGHS = REGISTRATE.item("netherite_thigh_highs",
		p -> new MaidArmorItem(CLArmorMaterials.NETHERITE,  EquipmentSlot.LEGS,p))
		.lang("Programmer Thigh Highs")
		.properties(p -> p.rarity(Rarity.EPIC).fireResistant())
		.color(() -> ThighHighColor::new)
		.register();
	public static final ItemEntry<? extends MaidArmorItem> CAT_EARS = newMaidPiece("cat_ears", EquipmentSlot.HEAD,
		"Cat Ears");
	public static final ItemEntry<? extends MaidArmorItem> MAID_BLOUSE = newMaidPiece("maid_dress_top", EquipmentSlot.CHEST,
		"Maid Dress Blouse");
	public static final ItemEntry<? extends MaidArmorItem> MAID_SKIRT = newMaidPiece("maid_dress_bottom", EquipmentSlot.LEGS,
		"Maid Dress Skirt");
	public static final ItemEntry<? extends MaidArmorItem> THIGH_HIGH = newMaidPiece("thigh_high", EquipmentSlot.FEET,
		"Thigh Highs");

	public static ItemEntry<? extends MaidArmorItem> newMaidPiece(String id, EquipmentSlot equipmentSlot, String lang) {
		return REGISTRATE.item(id, p -> new MaidArmorItem(CLArmorMaterials.NETHERITE, equipmentSlot, p))
			.lang(lang)
			.properties(p -> p.rarity(Rarity.EPIC).fireResistant())
			.color(() -> ThighHighColor::new)
			.register();
	}

	public static void register() {
	}
}
