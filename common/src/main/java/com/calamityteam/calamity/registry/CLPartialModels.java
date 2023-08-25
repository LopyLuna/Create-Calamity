package com.calamityteam.calamity.registry;

import com.jozufozu.flywheel.core.PartialModel;

import com.simibubi.create.Create;

public class CLPartialModels {

	public static final PartialModel
		MAID_DRESS = block("maid_dress"),
		CAT_EARS = block("cat_ears")
	;


	private static PartialModel block(String path) {
		return new PartialModel(Create.asResource("block/" + path));
	}

	public static void register() {}
}
