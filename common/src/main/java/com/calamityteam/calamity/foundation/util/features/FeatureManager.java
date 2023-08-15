package com.calamityteam.calamity.foundation.util.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.calamityteam.calamity.foundation.config.server.CalamityServer;
import com.calamityteam.calamity.foundation.util.FeatureLoader;

public class FeatureManager {
	public static final List<FeatureLoader> FEATURE_LOADERS;
	public static final WorkplaceHazards WSH;
	static {
		CalamityServer server = CalamityServer.INSTANCE;
		List<FeatureLoader> features = new ArrayList<>();
		if (server.features.workspaceHazards.get()) {
			features.add(WSH = new WorkplaceHazards());
		}
		else {
			WSH = null;
		}

		for (FeatureLoader featureLoader : features) {
			featureLoader.tryLoad();
		}

		FEATURE_LOADERS = Collections.unmodifiableList(features);
	}

	public static void visit() {

	}
}
