package com.calamityteam.calamity.feature.research_mode.loaders;

import com.calamityteam.calamity.feature.research_mode.researches.Features;
import com.calamityteam.calamity.foundation.util.FeatureLoader;

import com.simibubi.create.infrastructure.config.AllConfigs;

public class BulkPressing extends FeatureLoader {
	@Override
	public String getFeatureID() {
		return Features.bulkPressing.getID();
	}

	@Override
	public void onLoad() {
		AllConfigs.server().recipes.bulkPressing.set(true);
	}
}
