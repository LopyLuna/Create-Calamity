package com.calamityteam.calamity.base.data.recipe.forge;

import com.calamityteam.calamity.base.data.recipe.CalamityStandardRecipeGen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CalamityStandardRecipeGenImpl extends CalamityStandardRecipeGen {
	protected CalamityStandardRecipeGenImpl(DataGenerator pGenerator) {
		super(pGenerator);
	}

	public static RecipeProvider create(DataGenerator gen) {
		CalamityStandardRecipeGenImpl provider = new CalamityStandardRecipeGenImpl(gen);
		return new RecipeProvider(gen) {
			@Override
			protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
				provider.registerRecipes(consumer);
			}
		};
	}
}
