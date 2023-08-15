package com.calamityteam.calamity.feature.research_mode.researches;

import com.calamityteam.calamity.CreateCalamity;

import net.minecraft.resources.ResourceLocation;

public enum Features {

	PNEUMATIC_PIPES("pneumatic_pipes", 17, CreateCalamity.asResource("loot_tables/research/pneumatic_pipes.json"), false),
	NUKES("nukes", 38, CreateCalamity.asResource("loot_tables/research/nukes.json"), false),
	BULK_PRESSING("bulk_pressing", 49, CreateCalamity.asResource("loot_tables/research/bulk_pressing.json"), false),
	PIPE_BOMBS("pipe_bombs", 23, CreateCalamity.asResource("loot_tables/research/pipe_bombs.json"), true),
	STEEL_RNG("steel_rng", 12, CreateCalamity.asResource("loot_tables/research/steel_rng.json"), true),
	WORKSPACE_HAZARDS("workspace_hazards", 5, CreateCalamity.asResource("loot_tables/research/workspace_hazards.json"), true),
	;

	private static Features INSTANCE;
	private String id;
	private boolean negative;
	private int xpCost;
	private ResourceLocation lootTable;
	private String description;
	private float negativeChanceBonus;
	private Features(String id, int xpCost, ResourceLocation lootTable, float negativeChanceBonus) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + id + ".description";
	}
	private Features(String id, int xpCost, ResourceLocation lootTable, boolean negative) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + id + ".description";
	}
	public String getDescription() {
		return description;
	}
	public String getID() {
		return id;
	}
	public static Features get() {
		return INSTANCE;
	}

	public boolean isNegative() {
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
	public void getAllFeatures() {
		for (Features feature : Features.values()) {
			System.out.println(feature.getID());
		}

	}

	public boolean isLoaded(String featureID) {
		return getID().equals(featureID);
	}
}
