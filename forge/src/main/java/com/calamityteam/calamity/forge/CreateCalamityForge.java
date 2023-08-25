package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.registry.CLForgeItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.registry.CLBlocks;
import com.calamityteam.calamity.registry.CLPlushies;
import com.calamityteam.calamity.registry.CLSounds;

@Mod(Calamity.MOD_ID)
public class CreateCalamityForge {
	public CreateCalamityForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		Calamity.REGISTRATE.registerEventListeners(modEventBus);

		CLSounds.register();
		CLBlocks.register();
		CLPlushies.register();
		CLForgeItems.register();

		/*forgeEventBus.register(Events.ClientModBusEvents.class);
		forgeEventBus.addListener(Events::registerCommands);*/
		modEventBus.addListener(CalamityEventListener::setup);
		modEventBus.addListener(CalamityEventListener.ClientModBusEvents::onLoadComplete);
		Calamity.init();
	}
}
