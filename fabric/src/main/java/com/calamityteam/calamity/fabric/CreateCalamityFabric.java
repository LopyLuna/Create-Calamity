package com.calamityteam.calamity.fabric;

import com.calamityteam.calamity.CreateCalamity;

import net.fabricmc.api.ModInitializer;

public class CreateCalamityFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateCalamity.init();
    }
}