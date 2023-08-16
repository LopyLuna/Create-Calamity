package com.calamityteam.calamity;

import com.calamityteam.calamity.base.registries.BlockRegistry;
import com.calamityteam.calamity.feature.research_mode.ResearchFeatureManager;
import com.calamityteam.calamity.foundation.util.features.FeatureManager;

import com.simibubi.create.foundation.data.CreateRegistrate;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;

import net.minecraft.resources.ResourceLocation;

import com.calamityteam.calamity.base.world.feature.CalamityFeatures;

public class CreateCalamity {
	public static final String MOD_ID = "createcalamity";
	public static final String NAME = "Create: Calamity";
	public static final String VERSION = "0.0.1";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
	public static final CreativeModeTab itemGroup = new CreativeModeTab(1, CreateCalamity.MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Items.AIR);
		}
	};

	public static void init() {
		LOGGER.info("{} v{} initializing! Create version: {} on platform: {}", NAME, VERSION, Create.VERSION,
				Util.platformName());

		BlockRegistry.register();
		//ResearchFeatureManager.visit();
		CalamityFeatures.register();
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
