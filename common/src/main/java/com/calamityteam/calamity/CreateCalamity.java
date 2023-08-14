package com.calamityteam.calamity;

import com.simibubi.create.Create;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCalamity {
	public static final String ID = "createcalamity";
	public static final String NAME = "Create: Calamity";
	public static final String VERSION = "0.0.1";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static void init() {
		LOGGER.info("{} v{} initializing! Create version: {} on platform: {}", NAME, VERSION, Create.VERSION, Util.platformName());
    }

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(ID, path);
	}
}
