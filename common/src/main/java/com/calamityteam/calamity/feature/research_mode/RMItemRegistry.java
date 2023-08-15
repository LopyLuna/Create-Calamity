package com.calamityteam.calamity.feature.research_mode;

import com.calamityteam.calamity.CreateCalamity;
import com.calamityteam.calamity.feature.research_mode.researches.Features;

import com.simibubi.create.foundation.data.CreateRegistrate;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.world.item.Item;

public class RMItemRegistry {
	private static final CreateRegistrate REGISTRATE = CreateCalamity.REGISTRATE;
	public static void register() {
	}

	private static ItemEntry<ResearchBlueprintItem> researchBlueprint(Features feature) {
		return REGISTRATE
			.item( "research_blueprint_" + feature.getID(), (props) -> new ResearchBlueprintItem(props, feature))
			.register();
	}

	public static final ItemEntry<ResearchBlueprintItem> bulkPressing = researchBlueprint(Features.BULK_PRESSING);
}
