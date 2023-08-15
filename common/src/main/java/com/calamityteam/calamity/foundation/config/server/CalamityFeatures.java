package com.calamityteam.calamity.foundation.config.server;

import com.simibubi.create.foundation.config.ConfigBase;
import com.simibubi.create.infrastructure.config.CRecipes;

public class CalamityFeatures extends ConfigBase {
	@Override
	public String getName() {
		return "features";
	}
	public final ConfigBool workspaceHazards = b(false, "workspaceHazards", Comments.workspaceHazards);
	public final ConfigBool pneumaticPipes = b(false, "pneumaticPipes", Comments.pneumaticPipes);
	public final ConfigBool pipeBombs = b(false, "pipeBombs", Comments.pipeBombs);



	private static class Comments {
		static String workspaceHazards = "Enable: Workspace Hazards.";
		static String pneumaticPipes = "Enable: Pneumatic Pipes.";
		static String pipeBombs = "Enable: Pipe Bombs.";
	}
}
