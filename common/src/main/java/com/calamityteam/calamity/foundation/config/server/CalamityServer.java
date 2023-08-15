package com.calamityteam.calamity.foundation.config.server;

import com.simibubi.create.foundation.config.ConfigBase;

public class CalamityServer extends ConfigBase {
	public static final CalamityServer INSTANCE = new CalamityServer();

	@Override
	public String getName() {
		return "server";
	}
	public final CalamityFeatures features = nested(0, CalamityFeatures::new, Comments.features);

	private static class Comments {
		static String features = "Server-side features.";
	}
}
