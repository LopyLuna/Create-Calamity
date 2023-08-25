package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.base.item.thigh_high.MaidArmorColor;
import com.calamityteam.calamity.base.item.thigh_high.MaidArmorItem;

import com.calamityteam.calamity.base.model.CatEarsForgeModel;

import com.simibubi.create.foundation.data.CreateRegistrate;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;

import static com.calamityteam.calamity.Calamity.REGISTRATE;

public class CLForgeItems {
	static {
		REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	public static final ItemEntry<? extends MaidArmorItem> CAT_EARS =
		REGISTRATE.item("cat_ears", p -> new MaidArmorItem(CLArmorMaterials.NETHERITE_MAID, EquipmentSlot.HEAD, p))
			.properties(p -> p.rarity(Rarity.RARE).fireResistant().stacksTo(1))
			.onRegister(CreateRegistrate.itemModel(() -> CatEarsForgeModel::new))
			.lang("Cat Ears")
			.color(() -> MaidArmorColor::new)
			.register();

	public static void register() {}
}
