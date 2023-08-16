package com.calamityteam.calamity.fabric;

import com.calamityteam.calamity.Calamity;

import net.fabricmc.api.ModInitializer;

public class CalamityImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        Calamity.init();
    }

	public static void finalizeRegistrate() {
		Calamity.REGISTRATE.register();
	}
}
