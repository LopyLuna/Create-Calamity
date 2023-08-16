package com.calamityteam.calamity.registry.worldgen.fabric;
import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.registry.CLBlocks;
import com.calamityteam.calamity.registry.worldgen.CLFeatures;
import com.tterrag.registrate.util.entry.LazyRegistryEntry;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class CLFeaturesImpl {

	private static final LazyRegistrar<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = LazyRegistrar.create(
		BuiltinRegistries.CONFIGURED_FEATURE, Calamity.MOD_ID);

	private static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_BRASS_ORE_CONFIGURED_FEATURE = CONFIGURED_FEATURES.register("nether_brass_ore", CLFeatures::makeBrassConfiguredFeature);

	public static void register() {
		CONFIGURED_FEATURES.register();
		Registry.register(BuiltinRegistries.PLACED_FEATURE,
			Calamity.asResource("nether_brass_ore"),
			CLFeatures.NETHER_BRASS_ORE_PLACED_FEATURE);

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES,
			ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
				Calamity.asResource("nether_brass_ore")));
	}

	public static Holder<ConfiguredFeature<?, ?>> getBrassFeatureHolder() {
		return NETHER_BRASS_ORE_CONFIGURED_FEATURE.getHolder().get();
	}
}
