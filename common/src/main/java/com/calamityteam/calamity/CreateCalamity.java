package com.calamityteam.calamity;

import com.calamityteam.calamity.base.registries.AdvancementCriteria;
import com.calamityteam.calamity.base.registries.BlockRegistry;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.damagesource.DamageSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.simibubi.create.Create;

import net.minecraft.resources.ResourceLocation;


public class CreateCalamity {
    public static final String MOD_ID = "createcalamity";
    public static final String NAME = "Create: Calamity";
    public static final String VERSION = "0.0.1";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static void init() {
        LOGGER.info("{} v{} initializing! Create version: {} on platform: {}", NAME, VERSION, Create.VERSION,
            Util.platformName());

        BlockRegistry.register();
		AdvancementCriteria.register();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}