package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.CreateCalamity;

import com.calamityteam.calamity.base.registries.BlockRegistry;

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

		CreateCalamity.REGISTRATE.registerEventListeners(modEventBus);

		BlockRegistry.register();

		/*forgeEventBus.register(Events.ClientModBusEvents.class);
		forgeEventBus.addListener(Events::registerCommands);*/
		modEventBus.addListener(CalamityEventListener::setup);
		modEventBus.addListener(CalamityEventListener.ClientModBusEvents::onLoadComplete);
		CreateCalamity.init();
	}
}
