package com.calamityteam.calamity.fabric;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.foundation.config.CalamityConfig;
import net.fabricmc.api.ModInitializer;

public class CalamityImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        Calamity.init();
		CalamityConfig.register();
    }
	public static void finalizeRegistrate() {
		Calamity.REGISTRATE.register();
	}
}
