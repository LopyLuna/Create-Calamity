package com.calamityteam.calamity.feature.research_mode;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import com.calamityteam.calamity.feature.research_mode.researches.Features;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ResearchBlueprintItem extends Item {

	private Features feature;

	public ResearchBlueprintItem(Properties properties, Features feature) {
		super(properties);
		this.feature = feature;
	}

	public Features getFeatureGroup() {
		return feature;
	}
	public String getFeatureName(Features feature) {
		return feature.getName();
	}

	static double negativeChance = Math.random();

	private double getNegativeChance() {
		return negativeChance;
	}

	private String linkedNegative(Features feature) {
		return feature.getNegative().isLinked() ? feature.getNegative().getName() : null;
	}
	@SuppressWarnings("ResultOfMethodCallIgnored")
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
		double negativeChance = getNegativeChance();
		Features featureGroup = getFeatureGroup();
		featureGroup.activateFeature(featureGroup);
		if (negativeChance <= featureGroup.getNegativeChanceBonus()) {
			if (featureGroup.getNegative() == null) {
				return InteractionResultHolder.fail(player.getItemInHand(usedHand));
			}
			if (featureGroup.getNegative().isLinked()) {
				featureGroup.activateNegative(featureGroup.getNegative());
			} else {
				featureGroup.activateNegative(featureGroup.getNegative().getRandomNegative());
			}
		}
		return InteractionResultHolder.success(player.getItemInHand(usedHand));
	}
}
