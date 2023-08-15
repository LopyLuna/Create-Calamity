package com.calamityteam.calamity.base.registries;

import net.minecraft.world.damagesource.DamageSource;

public class DamageSourceRegistry {
	public static final DamageSource DAMAGE_SOURCE_CRUSHING = new DamageSource("crushing").bypassArmor().bypassMagic().bypassEnchantments();

}
