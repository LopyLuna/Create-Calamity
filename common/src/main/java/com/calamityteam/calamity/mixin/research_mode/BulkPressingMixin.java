package com.calamityteam.calamity.mixin.research_mode;

import com.calamityteam.calamity.feature.research_mode.researches.Features;

import com.simibubi.create.infrastructure.config.AllConfigs;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity")
public class BulkPressingMixin {

	/**
	 * @author PouffyDev
	 * @reason Need to mixin this method to allow for bulk pressing to be enabled in research mode
	 */
	@Overwrite
	public boolean canProcessInBulk() {
		if (Features.BULK_PRESSING.isLoaded(Features.BULK_PRESSING)) {
			return true;
		}
		return AllConfigs.server().recipes.bulkPressing.get();
	}

}
