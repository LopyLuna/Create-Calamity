package com.calamityteam.calamity.infrastructure.events;

import com.calamityteam.calamity.base.item.thigh_high.MaidArmorItem;
import io.github.fabricators_of_create.porting_lib.event.common.LivingEntityEvents;

public class CommonEvents {
	public static void register() {


		// External Events
		LivingEntityEvents.TICK.register(MaidArmorItem::applySpeed);
	}
}
