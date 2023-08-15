package com.calamityteam.calamity.feature.research_mode;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BlueprintTab extends CreativeModeTab {
	public BlueprintTab(int id, String langId) {
		super(id, langId);
	}

	@Override
	public ItemStack makeIcon() {
		return RMItemRegistry.bulkPressing.get().getDefaultInstance();
	}
}
