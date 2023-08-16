package com.calamityteam.calamity.feature;

import com.calamityteam.calamity.Calamity;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.calamityteam.calamity.feature.research_mode.researches.Features;

public class FeatureGroupedItem extends Item {

	private Features feature;
	public FeatureGroupedItem(Properties properties, Features feature) {
		super(properties);
		this.feature = feature;
	}
	@Override
	public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
		if (group == Calamity.itemGroup) {
			if (isFeatureLoaded()) {
				ItemStack stack = new ItemStack(this);
				items.add(stack);
			}
		}
	}
	public Features getFeatureGroup() {
		return feature;
	}
	public boolean isFeatureLoaded() {
		return feature.isFeatureConfigEnabled();
	}
}
