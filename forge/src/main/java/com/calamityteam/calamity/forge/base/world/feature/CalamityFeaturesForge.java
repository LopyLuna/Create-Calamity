package com.calamityteam.calamity.forge.base.world.feature;
import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.calamityteam.calamity.CreateCalamity;
import com.calamityteam.calamity.base.registries.BlockRegistry;

public class CalamityFeaturesForge {
	public static void register(IEventBus eventBus) {
		CONFIGURED_FEATURES.register(eventBus);
		PLACED_FEATURES.register(eventBus);
	}

	/* ---------- Configured Features ---------- */
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(
		Registry.CONFIGURED_FEATURE_REGISTRY, CreateCalamity.MOD_ID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_BRASS_ORE_CONFIGURED_FEATURE = CONFIGURED_FEATURES.register(
		"nether_brass_ore",
		() -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
				BlockRegistry.BRASS_ORE.getDefaultState())), 9)));


	/* ---------- Placed Features ---------- */
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(
		Registry.PLACED_FEATURE_REGISTRY, CreateCalamity.MOD_ID);

	public static final RegistryObject<PlacedFeature> NETHER_BRASS_ORE_PLACED_FEATURE = PLACED_FEATURES.register(
		"nether_brass_ore",
		() -> new PlacedFeature(NETHER_BRASS_ORE_CONFIGURED_FEATURE.getHolder().get(),
			List.of(
				CountPlacement.of(18),
				InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
			)));
}
