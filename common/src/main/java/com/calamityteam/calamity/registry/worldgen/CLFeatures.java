package com.calamityteam.calamity.registry.worldgen;
import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.registry.CLBlocks;
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
import org.jetbrains.annotations.ApiStatus;

import java.util.List;


public class CLFeatures {


	@ExpectPlatform
	private static Holder<ConfiguredFeature<?, ?>> getBrassFeatureHolder() {
		throw new AssertionError();
	}


	/* ---------- Placed Features ---------- */


	@ExpectPlatform
	public static void register() {
		throw new AssertionError();
	}
}
