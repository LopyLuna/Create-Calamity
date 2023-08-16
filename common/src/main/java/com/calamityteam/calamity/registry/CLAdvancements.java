package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.feature.workplace_hazards.BonkCriterion;

import com.calamityteam.calamity.feature.workplace_hazards.CrunchCriterion;

import net.minecraft.advancements.CriteriaTriggers;

public class CLAdvancements {
	// @todo: someone figure out datagen
	public static BonkCriterion PRESS_BONK = CriteriaTriggers.register(new BonkCriterion());
	public static CrunchCriterion COG_CRUNCH = CriteriaTriggers.register(new CrunchCriterion());
	public static void register() {} // required for side-effects
}
