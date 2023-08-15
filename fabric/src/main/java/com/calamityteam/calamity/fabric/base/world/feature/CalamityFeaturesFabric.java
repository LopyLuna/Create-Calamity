package com.calamityteam.calamity.fabric.base.world.feature;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import com.calamityteam.calamity.CreateCalamity;
import com.calamityteam.calamity.base.registries.BlockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

public class CalamityFeaturesFabric {
	/* ---------- Configured Features ---------- */
	private static final ConfiguredFeature<?, ?> NETHER_BRASS_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
		Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
		BlockRegistry.BRASS_ORE.getDefaultState(), 7));


	/* ---------- Placed Features ---------- */
	public static PlacedFeature NETHER_BRASS_ORE_PLACED_FEATURE = new PlacedFeature(
		Holder.direct(NETHER_BRASS_ORE_CONFIGURED_FEATURE),
		List.of(
			CountPlacement.of(18),
			InSquarePlacement.spread(),
			HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
		));

	public static void register() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
			CreateCalamity.asResource("nether_brass_ore"), NETHER_BRASS_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
			CreateCalamity.asResource("nether_brass_ore"),
			NETHER_BRASS_ORE_PLACED_FEATURE);
		addFeaturesToWorldgen();
	}

	public static void addFeaturesToWorldgen() {
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES,
			ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
				CreateCalamity.asResource("nether_brass_ore")));
	}
}
