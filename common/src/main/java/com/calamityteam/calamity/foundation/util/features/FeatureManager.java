package com.calamityteam.calamity.foundation.util.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.calamityteam.calamity.feature.research_mode.researches.Features;
import com.calamityteam.calamity.foundation.config.server.CalamityServer;
import com.calamityteam.calamity.foundation.util.FeatureLoader;

public class FeatureManager {
	public static final List<FeatureLoader> FEATURE_LOADERS;
	static CalamityServer server = CalamityServer.INSTANCE;
	static Features features = Features.get();
	public static final WorkspaceHazards workspaceHazards;
	public static boolean serverHasWorkspaceHazards = server.features.workspaceHazards.get();
	static {

		List<FeatureLoader> allFeatures = new ArrayList<>();
		if (serverHasWorkspaceHazards) {
			allFeatures.add(workspaceHazards = new WorkspaceHazards());
			features.setIsLoaded(Features.workspaceHazards.getID());
		}
		else {
			workspaceHazards = null;
		}

		for (FeatureLoader featureLoader : allFeatures) {
			featureLoader.tryLoad();
		}

		FEATURE_LOADERS = Collections.unmodifiableList(allFeatures);
	}

	public static void visit() {

	}
}
