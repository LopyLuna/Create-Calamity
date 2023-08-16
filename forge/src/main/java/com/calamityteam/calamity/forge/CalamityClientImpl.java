package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.CalamityClient;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(Dist.CLIENT)
public class CalamityClientImpl {
	public static void init() {
		CalamityClient.init();
		CalamityImpl.bus.addListener(CalamityEventListener.ClientModBusEvents::onLoadComplete);
	}
}
