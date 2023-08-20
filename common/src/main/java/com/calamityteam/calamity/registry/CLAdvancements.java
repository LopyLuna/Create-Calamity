package com.calamityteam.calamity.registry;

import net.minecraft.advancements.CriteriaTriggers;

import com.calamityteam.calamity.feature.maid_armor.ComfyCriterion;
import com.calamityteam.calamity.feature.workplace_hazards.BonkCriterion;
import com.calamityteam.calamity.feature.workplace_hazards.CrunchCriterion;

public class CLAdvancements {
	// @todo: someone figure out datagen
	public static BonkCriterion PRESS_BONK = CriteriaTriggers.register(new BonkCriterion());
	public static CrunchCriterion COG_CRUNCH = CriteriaTriggers.register(new CrunchCriterion());
	public static ComfyCriterion EVADE_SCULK_COMFY = CriteriaTriggers.register(new ComfyCriterion());
	public static void register() {} // required for side-effects
}
