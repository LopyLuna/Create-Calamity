package com.calamityteam.calamity.forge;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.registry.worldgen.forge.CLFeaturesImpl;
import com.calamityteam.calamity.util.forge.UtilImpl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.commands.CommandSourceStack;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public abstract class CalamityEventListener {
	@Mod.EventBusSubscriber(modid = Calamity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static abstract class ClientModBusEvents {
		@SubscribeEvent
		static void onLoadComplete(FMLLoadCompleteEvent event) {
			ModContainer container = ModList.get()
				.getModContainerById(Calamity.MOD_ID)
				.orElseThrow(
					() -> new IllegalStateException("Create Calamity mod container missing on LoadComplete"));
			container.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
				() -> new ConfigScreenHandler.ConfigScreenFactory(/*Config::createConfigScreen*/null));
		}
	}

	@SubscribeEvent
	static void registerCommands(RegisterCommandsEvent event) {
		for (LiteralArgumentBuilder<CommandSourceStack> command : UtilImpl.commands) {
			event.getDispatcher().register(command);
		}
	}

	@SubscribeEvent
	static void setup(FMLCommonSetupEvent event) {
		event.enqueueWork(() ->
			CLFeaturesImpl.register(FMLJavaModLoadingContext.get().getModEventBus())
		);
	}
}