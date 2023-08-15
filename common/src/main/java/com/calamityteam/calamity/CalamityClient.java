package com.calamityteam.calamity;

import com.calamityteam.calamity.registry.CLPackets;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class CalamityClient {
	public static void init() {
		CLPackets.PACKETS.registerS2CListener();
	}
}
