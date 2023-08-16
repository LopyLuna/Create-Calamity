package com.calamityteam.calamity.multiloader.fabric;

import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;

import com.calamityteam.calamity.Calamity;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class ClientCommandsImpl {
	public static void sendSuccess(SharedSuggestionProvider provider, Component text) {
		if (provider instanceof FabricClientCommandSource fabric)
			fabric.sendFeedback(text);
		else Calamity.LOGGER.error("Invalid command source: " + provider);
	}

	public static void sendFailure(SharedSuggestionProvider provider, Component text) {
		if (provider instanceof FabricClientCommandSource fabric)
			fabric.sendError(text);
		else Calamity.LOGGER.error("Invalid command source: " + provider);
	}
}
