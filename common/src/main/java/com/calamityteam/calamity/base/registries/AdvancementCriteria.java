package com.calamityteam.calamity.base.registries;

import com.calamityteam.calamity.feature.workplace_hazards.BonkCriterion;

import net.minecraft.advancements.CriteriaTriggers;

public class AdvancementCriteria {
	public static BonkCriterion PRESS_BONK = CriteriaTriggers.register(new BonkCriterion());

	public static void register() {} // lol
}
