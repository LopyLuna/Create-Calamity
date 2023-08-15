package com.calamityteam.calamity.feature.research_mode.researches;

import com.calamityteam.calamity.CreateCalamity;

import net.minecraft.resources.ResourceLocation;

public enum Features {

	PNEUMATIC_PIPES("pneumatic_pipes", Negatives.PIPE_BOMBS, 17, CreateCalamity.asResource("loot_tables/research/pneumatic_pipes.json"), 0.25f),

	NUKES("nukes", 38, CreateCalamity.asResource("loot_tables/research/nukes.json")),
	BULK_PRESSING("bulk_pressing", 49, CreateCalamity.asResource("loot_tables/research/bulk_pressing.json")),
	;

	private String name;
	private Negatives negative;
	private int xpCost;
	private ResourceLocation lootTable;
	private String description;
	private float negativeChanceBonus;
	private Features(String name, Negatives negative, int xpCost, ResourceLocation lootTable, float negativeChanceBonus) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + name + ".description";
	}
	private Features(String name, int xpCost, ResourceLocation lootTable) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + name + ".description";
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public Negatives getNegative() {
		if (negative == null) {
			return null;
		}
		return negative;
	}

	public int getXpCost() {
		return xpCost;
	}
	public ResourceLocation getLootTable() {
		return lootTable;
	}
	public float getNegativeChanceBonus() {
		return negativeChanceBonus;
	}
	public boolean activateFeature(Features feature) {
		return isLoaded(feature);
	}
	public boolean activateNegative(Negatives negative) {
		if (negative.isLinked()) {
			return negative.isLoaded(negative);
		}
		else {
			return negative.isLoaded(negative.getRandomNegative());
		}
	}
	public void getAllFeatures() {
		for (Features feature : Features.values()) {
			System.out.println(feature.getName());
		}

	}
	public boolean isLoaded(Features feature) {
		return true;
	}
}
