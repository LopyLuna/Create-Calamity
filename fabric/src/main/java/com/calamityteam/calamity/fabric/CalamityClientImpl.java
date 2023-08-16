package com.calamityteam.calamity.fabric;

import com.calamityteam.calamity.CalamityClient;
import net.fabricmc.api.ClientModInitializer;

public class CalamityClientImpl implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		CalamityClient.init();
	}
}
