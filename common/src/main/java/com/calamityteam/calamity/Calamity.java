package com.calamityteam.calamity;

import com.calamityteam.calamity.base.data.CLTagGen;
import com.calamityteam.calamity.base.data.lang.CLLangPartials;
import com.calamityteam.calamity.base.data.recipe.CalamitySequencedAssemblyRecipeGen;
import com.calamityteam.calamity.base.data.recipe.CalamityStandardRecipeGen;
import com.calamityteam.calamity.base.featurepack.CalamityFeatureConfig;
import com.calamityteam.calamity.base.featurepack.CalamityFeaturePack;
import com.calamityteam.calamity.registry.CLBlocks;
import com.calamityteam.calamity.registry.CLPackets;
import com.calamityteam.calamity.util.Util;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.ConfigFormat;

import com.simibubi.create.foundation.data.CreateRegistrate;

import com.simibubi.create.foundation.data.LangMerger;
import com.simibubi.create.foundation.ponder.PonderLocalization;

import com.simibubi.create.foundation.utility.AttachedRegistry;

import com.tterrag.registrate.providers.ProviderType;
import dev.architectury.injectables.annotations.ExpectPlatform;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;

import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calamity {
	public static final String MOD_ID = "calamity";
	public static final String NAME = "Create: Calamity";
	public static final String VERSION = "0.0.1";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final CalamityRegistrate REGISTRATE = CalamityRegistrate.create(MOD_ID);

	public static void init() {
		LOGGER.info("{} v{} initializing! Create version: {} on platform: {}", NAME, VERSION, Create.VERSION,
				Util.platformName());

		ModSetup.register();
		finalizeRegistrate();
		ModSetup.registerPostRegistrate();

		CLPackets.PACKETS.registerC2SListener();

		ForgeConfigSpec spec = new ForgeConfigSpec.Builder()
			.configure(CalamityFeatureConfig::new).getValue();

		Util.registerConfig(MOD_ID, ModConfig.Type.SERVER, spec, MOD_ID);
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

	@ExpectPlatform
	public static void finalizeRegistrate() {
		throw new AssertionError();
	}

	public static void gatherData(DataGenerator gen) {
		REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CLTagGen::generateBlockTags);
		REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CLTagGen::generateItemTags);
		gen.addProvider(true, CalamitySequencedAssemblyRecipeGen.create(gen));
		gen.addProvider(true, CalamityStandardRecipeGen.create(gen));
		PonderLocalization.provideRegistrateLang(REGISTRATE);
		gen.addProvider(true, new LangMerger(gen, MOD_ID, "Create: Calamity", CLLangPartials.values()));
	}
}
