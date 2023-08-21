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
		Full set grants impermeability to warden attacks
		Full set cannot be unequipped
	 */
	public static final ItemEntry<? extends MaidArmorItem> CAT_EARS = newMaidPiece("cat_ears", EquipmentSlot.HEAD,
		"Cat Ears");
	public static final ItemEntry<? extends MaidArmorItem> MAID_DRESS = newMaidPiece("maid_dress", EquipmentSlot.CHEST,
		"Maid Dress");
	public static final ItemEntry<? extends MaidArmorItem> MAID_PANTIES = newMaidPiece("maid_panties", EquipmentSlot.LEGS,
		"Maid Panties");
	public static final ItemEntry<? extends MaidArmorItem> THIGH_HIGHS = newMaidPiece("thigh_highs", EquipmentSlot.FEET,
		"Thigh Highs");

	public static ItemEntry<? extends MaidArmorItem> newMaidPiece(String id, EquipmentSlot equipmentSlot, String lang) {
		return REGISTRATE.item(id, p -> new MaidArmorItem(CLArmorMaterials.NETHERITE_MAID, equipmentSlot, p))
			.lang(lang)
			.properties(p -> p.rarity(Rarity.RARE).fireResistant())
			.color(() -> ThighHighColor::new)
			.register();
	}

	public static void register() {
	}
}
