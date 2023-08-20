package com.calamityteam.calamity.mixin.thigh_high;

import java.util.stream.IntStream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;

import com.calamityteam.calamity.util.thigh_high.ComfortablySneaky;

@Mixin(Warden.class)
public class WardenMixin {
	@Inject(method = "canTargetEntity", at = @At("HEAD"), cancellable = true)
	public void canTargetEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (!(entity instanceof Player player)) return;
		boolean isSneaky = IntStream.rangeClosed(0, 3).mapToObj(player.getInventory()::getArmor)
			.allMatch(itemStack -> itemStack.getItem() instanceof ComfortablySneaky);
		if (isSneaky) cir.setReturnValue(false);
	}
}
