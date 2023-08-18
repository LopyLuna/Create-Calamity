package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.multiloader.Env;
import com.calamityteam.calamity.registry.CLBlocks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Calamity.MOD_ID)
public class CalamityImpl {
	static IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

	public CalamityImpl() {
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

		/*forgeEventBus.register(Events.ClientModBusEvents.class);
		forgeEventBus.addListener(Events::registerCommands);
		bus.addListener(Events.ClientModBusEvents::onLoadComplete);*/

		bus.addListener(CalamityEventListener::setup);

		Calamity.init();

		//noinspection Convert2MethodRef
		Env.CLIENT.runIfCurrent(() -> () -> CalamityClientImpl.init());
	}

	public static void finalizeRegistrate() {
		Calamity.REGISTRATE.registerEventListeners(bus);
	}
}
