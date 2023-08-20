package com.calamityteam.calamity.mixin;

import com.calamityteam.calamity.base.item.thigh_high.MaidArmorItem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import com.calamityteam.calamity.util.thigh_high.ComfortablyStuck;

/**
 * Add special Items to work like Items with the Curse of Binding using
 * the {@linkplain ComfortablyStuck ComfortablyStuck} Interface<br>
 * For an example, check out {@linkplain MaidArmorItem ThighHighItem}
 */
@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {
	@Inject(method = "hasBindingCurse", at = @At("HEAD"), cancellable = true)
	private static void hasBindingCurse(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		boolean binding = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BINDING_CURSE, stack) > 0 ||
			stack.getItem() instanceof ComfortablyStuck;
		cir.setReturnValue(binding);
	}
}
