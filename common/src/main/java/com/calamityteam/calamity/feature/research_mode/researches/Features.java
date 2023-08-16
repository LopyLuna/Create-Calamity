package com.calamityteam.calamity.feature.research_mode.researches;

import com.simibubi.create.foundation.config.ConfigBase;
import com.simibubi.create.infrastructure.config.AllConfigs;

import net.minecraft.resources.ResourceLocation;

import com.calamityteam.calamity.CreateCalamity;
import com.calamityteam.calamity.feature.research_mode.loaders.BulkPressing;
import com.calamityteam.calamity.foundation.config.server.CalamityServer;
import com.calamityteam.calamity.foundation.util.FeatureLoader;
import com.calamityteam.calamity.foundation.util.features.WorkspaceHazards;

public enum Features {

	pneumaticPipes("pneumatic_pipes", 17, CreateCalamity.asResource("loot_tables/research/pneumatic_pipes.json"), false),
	nukes("nukes", 38, CreateCalamity.asResource("loot_tables/research/nukes.json"), false),
	bulkPressing("bulk_pressing", 49, CreateCalamity.asResource("loot_tables/research/bulk_pressing.json"), false, new BulkPressing(), AllConfigs.server().recipes.bulkPressing),
	pipeBombs("pipe_bombs", 23, CreateCalamity.asResource("loot_tables/research/pipe_bombs.json"), true),
	steelRNG("steel_rng", 12, CreateCalamity.asResource("loot_tables/research/steel_rng.json"), true),
	workspaceHazards("workspace_hazards", 5, CreateCalamity.asResource("loot_tables/research/workspace_hazards.json"), true, new WorkspaceHazards(), CalamityServer.INSTANCE.features.workspaceHazards),
	;
	private static Features INSTANCE;
	private final String id;
	private final boolean negative;
	private final int xpCost;
	private final ResourceLocation lootTable;
	private final String description;
	private float negativeChanceBonus;
	private FeatureLoader loaders;
	private ConfigBase.ConfigBool featureConfig;

	Features(String id, int xpCost, ResourceLocation lootTable, boolean negative, FeatureLoader loaders, ConfigBase.ConfigBool featureConfig) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + id + ".description";
		this.id = id;
		this.loaders = loaders;
		this.xpCost = xpCost;
		this.lootTable = lootTable;
		this.negative = negative;
		this.featureConfig = featureConfig;
	}
	Features(String id, int xpCost, ResourceLocation lootTable, boolean negative) {
		this.description = CreateCalamity.MOD_ID + "research_mode.feature." + id + ".description";
		this.id = id;
		this.xpCost = xpCost;
		this.lootTable = lootTable;
		this.negative = negative;
	}

	public ConfigBase.ConfigBool getFeatureConfig() {
		return this.featureConfig;
	}
	public boolean isFeatureConfigEnabled() {
		return this.featureConfig.get();
	}
	public String getDescription() {
		return description;
	}
	public String getID() {
		return id;
	}
	public static FeatureLoader getLoaders() {
		return INSTANCE.loaders;
	}
	public static Features get() {
		if (INSTANCE != null) {
			return INSTANCE;
		}
		return null;
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
	public void setIsLoaded(String featureID) {
		if (isLoaded(featureID)) {
			INSTANCE = this;
		}
		if (!isLoaded(featureID)) {
			INSTANCE = null;
		}
	}
}
