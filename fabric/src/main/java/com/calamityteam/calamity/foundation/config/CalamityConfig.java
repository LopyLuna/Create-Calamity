package com.calamityteam.calamity.foundation.config;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import com.calamityteam.calamity.CreateCalamity;

import com.simibubi.create.Create;

import net.minecraftforge.api.fml.event.config.ModConfigEvents;

import org.apache.commons.lang3.tuple.Pair;

import com.simibubi.create.foundation.config.ConfigBase;

import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import com.calamityteam.calamity.foundation.config.server.CalamityServer;

public class CalamityConfig {
	private static final Map<ModConfig.Type, ConfigBase> CONFIGS = new EnumMap<>(ModConfig.Type.class);

	//private static CClient client;
	//private static CCommon common;
	private static CalamityServer server;

	//public static CClient client() {
	//	return client;
	//}
	//public static CCommon common() {
	//	return common;
	//}

	public static CalamityServer server() {
		return server;
	}

	public static ConfigBase byType(ModConfig.Type type) {
		return CONFIGS.get(type);
	}

	private static <T extends ConfigBase> T register(Supplier<T> factory, ModConfig.Type side) {
		Pair<T, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(builder -> {
			T config = factory.get();
			config.registerAll(builder);
			return config;
		});

		T config = specPair.getLeft();
		config.specification = specPair.getRight();
		CONFIGS.put(side, config);
		return config;
	}

	public static void register() {
		//client = register(CClient::new, ModConfig.Type.CLIENT);
		//common = register(CCommon::new, ModConfig.Type.COMMON);
		server = register(CalamityServer::new, ModConfig.Type.SERVER);

		for (Map.Entry<ModConfig.Type, ConfigBase> pair : CONFIGS.entrySet())
			ModLoadingContext.registerConfig(Create.ID, pair.getKey(), pair.getValue().specification);


		ModConfigEvents.loading(CreateCalamity.MOD_ID).register(CalamityConfig::onLoad);
		ModConfigEvents.reloading(CreateCalamity.MOD_ID).register(CalamityConfig::onReload);
	}

	public static void onLoad(ModConfig modConfig) {
		for (ConfigBase config : CONFIGS.values())
			if (config.specification == modConfig
				.getSpec())
				config.onLoad();
	}

	public static void onReload(ModConfig modConfig) {
		for (ConfigBase config : CONFIGS.values())
			if (config.specification == modConfig
				.getSpec())
				config.onReload();
	}

}
