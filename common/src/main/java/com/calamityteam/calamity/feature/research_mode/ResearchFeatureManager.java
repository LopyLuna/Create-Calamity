package com.calamityteam.calamity.feature.research_mode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.calamityteam.calamity.feature.research_mode.researches.Features;
import com.calamityteam.calamity.foundation.config.server.CalamityServer;
import com.calamityteam.calamity.foundation.util.FeatureLoader;

public class ResearchFeatureManager {
	public static final List<FeatureLoader> FEATURE_LOADERS;
	static CalamityServer server = CalamityServer.INSTANCE;
	static FeatureLoader featureLoaders = Features.getLoaders();
	static FeatureLoader getFeatureLoaders;
	public static boolean serverHasFeature;

	static {
		List<FeatureLoader> allFeatures = new ArrayList<>();
		//assert features != null;
		//serverHasFeature = features.isLoaded(features.getID());
		//
		//if (serverHasFeature) {
		//	allFeatures.add(getFeatureLoaders = Features.getLoaders());
		//	features.setIsLoaded(features.getID());
		//	features.getFeatureConfig().set(true);
		//}

		for (FeatureLoader featureLoader : allFeatures) {
			featureLoader.tryLoad();
		}

		FEATURE_LOADERS = Collections.unmodifiableList(allFeatures);
	}

	public static void visit() {

	}
}
