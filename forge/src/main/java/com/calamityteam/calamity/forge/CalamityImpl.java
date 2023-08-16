package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.foundation.config.CalamityConfig;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Calamity.MOD_ID)
public class CalamityImpl {
	static IEventBus bus;
	public CalamityImpl() {
		bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
		ModLoadingContext modLoadingContext = ModLoadingContext.get();

		bus.addListener(CalamityEventListener::setup);

		Calamity.init();

		//noinspection Convert2MethodRef
		Env.CLIENT.runIfCurrent(() -> () -> CalamityClientImpl.init());
		CalamityConfig.register(modLoadingContext);
	}
	public static void finalizeRegistrate() {
		Calamity.REGISTRATE.registerEventListeners(bus);
	}
}
