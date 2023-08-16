package com.calamityteam.calamity.registry;

import net.minecraft.world.damagesource.DamageSource;

public class CLDamageSources {
	public static final DamageSource DAMAGE_SOURCE_CRUSHING = new DamageSource("crushing").bypassArmor().bypassMagic().bypassEnchantments();
	public static final DamageSource DAMAGE_SOURCE_CRUNCHING = new DamageSource("crunching").bypassMagic();

}
