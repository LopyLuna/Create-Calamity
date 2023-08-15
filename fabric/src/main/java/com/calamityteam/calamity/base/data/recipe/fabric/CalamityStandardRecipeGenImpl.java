package com.calamityteam.calamity.base.data.recipe.fabric;

import com.calamityteam.calamity.base.data.recipe.CalamityStandardRecipeGen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class CalamityStandardRecipeGenImpl extends CalamityStandardRecipeGen {
	protected CalamityStandardRecipeGenImpl(DataGenerator pGenerator) {
		super(pGenerator);
	}

	public static RecipeProvider create(DataGenerator gen) {
		CalamityStandardRecipeGenImpl provider = new CalamityStandardRecipeGenImpl(gen);
		return new FabricRecipeProvider((FabricDataGenerator) gen) {
			@Override
			protected void generateRecipes(Consumer<FinishedRecipe> exporter) {
				provider.registerRecipes(exporter);
			}
		};
	}
}
