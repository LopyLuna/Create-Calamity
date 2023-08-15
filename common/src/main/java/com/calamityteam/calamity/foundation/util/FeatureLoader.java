package com.calamityteam.calamity.foundation.util;

import com.calamityteam.calamity.feature.research_mode.researches.Features;

import net.minecraft.resources.ResourceLocation;

public abstract class FeatureLoader {
	private boolean isLoaded;
	public abstract String getFeatureID();

	public void tryLoad() {
		if (Features.get().isLoaded(getFeatureID())) {
			this.isLoaded = true;

			this.onLoad();
		}

	}

	protected abstract void onLoad();

	public boolean isLoaded() {
		return this.isLoaded;
	}

	public ResourceLocation getLocation(String path) {
		return new ResourceLocation(this.getFeatureID(), path);
	}
}
