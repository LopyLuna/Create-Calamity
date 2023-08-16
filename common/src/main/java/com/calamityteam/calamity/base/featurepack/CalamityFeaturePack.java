package com.calamityteam.calamity.base.featurepack;

import com.simibubi.create.foundation.utility.AttachedRegistry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

public enum CalamityFeaturePack {
	BASE(false, "Calamity mod core features"),
	TEST_1(true, "Testing feature, adds the elusive test feature 1"),
	TEST_2(true, "Testing feature, adds the elusive test feature 2"),
	;
	public static final AttachedRegistry<Item, CalamityFeaturePack> REGISTRY = new AttachedRegistry<>(Registry.ITEM);

	boolean toggleable;
	String description;

	CalamityFeaturePack(boolean toggleable, String description) {
		this.toggleable = toggleable;
		this.description = description;
	}

	public boolean isToggleable() {
		return toggleable;
	}

	public String getDescription() {
		return description;
	}
}
