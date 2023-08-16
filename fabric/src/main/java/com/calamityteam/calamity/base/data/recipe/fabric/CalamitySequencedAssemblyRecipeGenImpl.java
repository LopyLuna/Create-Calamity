package com.calamityteam.calamity.base.data.recipe.fabric;

import com.calamityteam.calamity.base.data.recipe.CalamitySequencedAssemblyRecipeGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class CalamitySequencedAssemblyRecipeGenImpl extends CalamitySequencedAssemblyRecipeGen {
	protected CalamitySequencedAssemblyRecipeGenImpl(DataGenerator pGenerator) {
		super(pGenerator);
	}

	public static RecipeProvider create(DataGenerator gen) {
		CalamitySequencedAssemblyRecipeGenImpl provider = new CalamitySequencedAssemblyRecipeGenImpl(gen);
		return new FabricRecipeProvider((FabricDataGenerator) gen) {
			@Override
			protected void generateRecipes(Consumer<FinishedRecipe> exporter) {
				provider.registerRecipes(exporter);
			}
		};
	}
}
