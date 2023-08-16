package com.calamityteam.calamity.foundation.util.features;

import com.calamityteam.calamity.feature.research_mode.researches.Features;
import com.calamityteam.calamity.foundation.util.FeatureLoader;

public class WorkspaceHazards extends FeatureLoader {
	public boolean featureEnabled;
	@Override
	public String getFeatureID() {
		return Features.workspaceHazards.getID();
	}

	@Override
	protected void onLoad() {
		System.out.println("Workspace Hazards loaded!");
		featureEnabled = true;
	}
}
