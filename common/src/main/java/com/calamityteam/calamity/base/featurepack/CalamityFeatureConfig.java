package com.calamityteam.calamity.base.featurepack;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Locale;

public class CalamityFeatureConfig {

	public CalamityFeatureConfig(ForgeConfigSpec.Builder builder) {
		for (CalamityFeaturePack featurePack : CalamityFeaturePack.values()) {
			if (!featurePack.isToggleable()) continue;
			builder.comment(featurePack.getDescription());
			featurePack.setConfigValue(builder.define(
				featurePack.name().toLowerCase(Locale.ROOT),
				featurePack.getDefaultState()));
		}
	}

}
