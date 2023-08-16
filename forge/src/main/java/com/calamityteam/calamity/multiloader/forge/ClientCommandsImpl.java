package com.calamityteam.calamity.multiloader.forge;

import com.calamityteam.calamity.Calamity;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.ClientCommandSourceStack;

public class ClientCommandsImpl {
	public static void sendSuccess(SharedSuggestionProvider provider, Component text) {
		if (provider instanceof ClientCommandSourceStack forge)
			forge.sendSuccess(text, true);
		else Calamity.LOGGER.error("Invalid command source: " + provider);
	}

	public static void sendFailure(SharedSuggestionProvider provider, Component text) {
		if (provider instanceof ClientCommandSourceStack forge)
			forge.sendFailure(text);
		else Calamity.LOGGER.error("Invalid command source: " + provider);
	}
}
