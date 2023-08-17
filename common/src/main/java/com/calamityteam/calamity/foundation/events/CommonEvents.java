package com.calamityteam.calamity.foundation.events;

import com.calamityteam.calamity.registry.CLThighHighItem;
import io.github.fabricators_of_create.porting_lib.event.common.LivingEntityEvents;

public class CommonEvents {
	public static void register() {


		// External Events
		LivingEntityEvents.TICK.register(CLThighHighItem::speed);
	}
}
