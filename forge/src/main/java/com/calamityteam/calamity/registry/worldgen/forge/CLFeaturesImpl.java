package com.calamityteam.calamity.registry.worldgen.forge;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.registry.CLBlocks;

import com.calamityteam.calamity.registry.worldgen.CLFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class CLFeaturesImpl {

	/* ---------- Configured Features ---------- */
	private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(
		Registry.CONFIGURED_FEATURE_REGISTRY, Calamity.MOD_ID);

	private static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_BRASS_ORE_CONFIGURED_FEATURE = CONFIGURED_FEATURES
		.register("nether_brass_ore", CLFeatures::makeBrassConfiguredFeature);

/*	public static final ConfiguredFeature<?, ?> NETHER_BRASS_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
		Feature.ORE, new OreConfiguration(OreFeatures.NETHER_ORE_REPLACEABLES,
		CLBlocks.BRASS_ORE.getDefaultState(), 7));*/

	/* ---------- Placed Features ---------- */
	private static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
		Registry.PLACED_FEATURE_REGISTRY, Calamity.MOD_ID);

	public static void register() {
		PLACED_FEATURES.register("nether_brass_ore", () -> CLFeatures.NETHER_BRASS_ORE_PLACED_FEATURE);
	}

	public static void register(IEventBus eventBus) {
		CONFIGURED_FEATURES.register(eventBus);
		PLACED_FEATURES.register(eventBus);
	}

    public static Holder<ConfiguredFeature<?, ?>> getBrassFeatureHolder() {
		return NETHER_BRASS_ORE_CONFIGURED_FEATURE.getHolder().get();
    }
}
