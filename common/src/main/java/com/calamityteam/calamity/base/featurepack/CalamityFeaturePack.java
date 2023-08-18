package com.calamityteam.calamity.base.featurepack;

import com.simibubi.create.foundation.utility.AttachedRegistry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

import net.minecraftforge.common.ForgeConfigSpec;

public enum CalamityFeaturePack {
	BASE(false, "Calamity mod core features"),
	BRASS_ORE(true, "Brass ore, generates in the nether (Does not disable worldgen cause idk havent done it)"),
	;
	public static final AttachedRegistry<Item, CalamityFeaturePack> REGISTRY = new AttachedRegistry<>(Registry.ITEM);

	final boolean toggleable;
	final String description;

	ForgeConfigSpec.BooleanValue configValue;

	CalamityFeaturePack(boolean toggleable, String description) {
		this.toggleable = toggleable;
		this.description = description;
	}

	public boolean isToggleable() {
		return toggleable;
	}

	public boolean getDefaultState() {
		return true;
	}

	public String getDescription() {
		return description;
	}

	public void setConfigValue(ForgeConfigSpec.BooleanValue configValue) {
		this.configValue = configValue;
	}

	public Boolean isEnabled() {
		return configValue.get();
	}
}
