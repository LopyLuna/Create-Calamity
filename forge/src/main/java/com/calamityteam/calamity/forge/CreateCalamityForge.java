package com.calamityteam.calamity.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.calamityteam.calamity.CreateCalamity;

@Mod(CreateCalamity.MOD_ID)
public class CreateCalamityForge {
	public CreateCalamityForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		forgeEventBus.register(CalamityEventListener.ClientModBusEvents.class);
		forgeEventBus.addListener(CalamityEventListener::registerCommands);
		modEventBus.addListener(CalamityEventListener::setup);
		modEventBus.addListener(CalamityEventListener.ClientModBusEvents::onLoadComplete);

		CreateCalamity.init();
	}
}
