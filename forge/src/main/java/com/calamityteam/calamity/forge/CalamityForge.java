package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.CreateCalamity;

import com.calamityteam.calamity.foundation.config.CalamityConfig;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CreateCalamity.MOD_ID)
public class CalamityForge {
	public CalamityForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		ModLoadingContext modLoadingContext = ModLoadingContext.get();

		forgeEventBus.register(Events.ClientModBusEvents.class);
		forgeEventBus.addListener(Events::registerCommands);
		modEventBus.addListener(Events.ClientModBusEvents::onLoadComplete);
		CreateCalamity.init();
		CalamityConfig.register(modLoadingContext);
	}
}
