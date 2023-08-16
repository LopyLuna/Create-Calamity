package com.calamityteam.calamity.multiloader;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * A Packet that is written on the server and handled on the client.
 */
public interface S2CPacket {
	void write(FriendlyByteBuf buffer);
	@Environment(EnvType.CLIENT)
	void handle(Minecraft mc);
}
