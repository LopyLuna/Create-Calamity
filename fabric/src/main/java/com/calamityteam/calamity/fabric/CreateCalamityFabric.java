package com.calamityteam.calamity.fabric;

import com.calamityteam.calamity.CreateCalamity;
import com.calamityteam.calamity.fabric.base.world.feature.CalamityFeaturesFabric;
import net.fabricmc.api.ModInitializer;

public class CreateCalamityFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		CreateCalamity.init();
		CreateCalamity.REGISTRATE.register();
		CalamityFeaturesFabric.register();
	}
}
