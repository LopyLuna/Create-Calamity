package com.calamityteam.calamity.fabric.base.world.feature;
import com.calamityteam.calamity.Calamity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CalamityFeaturesImpl {
	public static void addFeaturesToWorldgen() {
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES,
				ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						Calamity.asResource("nether_brass_ore")));
	}
}
