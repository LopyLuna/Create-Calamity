package com.calamityteam.calamity.forge.mixin;

import com.calamityteam.calamity.CalamityRegistrate;
import com.tterrag.registrate.AbstractRegistrate;

import net.minecraftforge.eventbus.api.IEventBus;

import org.spongepowered.asm.mixin.Mixin;

/**
 * Allows a forge override of the non static {@link CalamityRegistrate#subscribeEventBus(Object)}
 * */
@Mixin(CalamityRegistrate.class)
public class CalamityRegistrateMixin extends AbstractRegistrate<CalamityRegistrate> {

	/**
	 * Construct a new Registrate for the given mod ID.
	 *
	 * @param modid The mod ID for which objects will be registered
	 */
	protected CalamityRegistrateMixin(String modid) {
		super(modid);
	}

	public void subscribeEventBus(Object eventBus) {
		registerEventListeners((IEventBus) eventBus);
	}

}
