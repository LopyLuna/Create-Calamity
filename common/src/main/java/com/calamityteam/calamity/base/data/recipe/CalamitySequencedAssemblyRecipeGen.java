package com.calamityteam.calamity.base.data.recipe;

import java.util.function.Function;

import org.jetbrains.annotations.NotNull;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeProvider;

import com.calamityteam.calamity.Calamity;
import dev.architectury.injectables.annotations.ExpectPlatform;

public abstract class CalamitySequencedAssemblyRecipeGen extends CalamityRecipeProvider {
    protected CalamitySequencedAssemblyRecipeGen(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @ExpectPlatform
    public static RecipeProvider create(DataGenerator gen) {
        throw new AssertionError();
    }

    protected GeneratedRecipe create(String name, Function<CalamitySequencedAssemblyRecipeBuilder, SequencedAssemblyRecipeBuilder> transform) {
        GeneratedRecipe generatedRecipe =
            c -> transform.apply(new CalamitySequencedAssemblyRecipeBuilder(Calamity.asResource(name)))
                .build(c);
        all.add(generatedRecipe);
        return generatedRecipe;
    }

    @Override
    public @NotNull String getName() {
        return "Calamity's Sequenced Assembly Recipes";
    }
}
