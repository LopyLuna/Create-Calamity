package com.calamityteam.calamity.base.world.feature;
import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.base.registries.BlockRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Arrays;

public class CalamityFeatures {
	private static final ConfiguredFeature<?, ?> NETHER_BRASS_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>(
			Feature.ORE, new OreConfiguration(OreFeatures.NETHERRACK,
			BlockRegistry.BRASS_ORE.getDefaultState(), 7));

	public static PlacedFeature NETHER_BRASS_ORE_PLACED_FEATURE = new PlacedFeature(
			Holder.direct(NETHER_BRASS_ORE_CONFIGURED_FEATURE),
			Arrays.asList(
					CountPlacement.of(18),
					InSquarePlacement.spread(),
					HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))
			));

	public static void register() {
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				Calamity.asResource("nether_brass_ore"), NETHER_BRASS_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
				Calamity.asResource("nether_brass_ore"),
				NETHER_BRASS_ORE_PLACED_FEATURE);
		addFeaturesToWorldgen();
	}

	@ExpectPlatform
	public static void addFeaturesToWorldgen() {
		throw new AssertionError();
	}
}
