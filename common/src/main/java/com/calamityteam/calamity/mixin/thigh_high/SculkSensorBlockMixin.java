package com.calamityteam.calamity.mixin.thigh_high;

import com.calamityteam.calamity.util.thigh_high.ComfortablySneaky;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SculkSensorBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;

import com.calamityteam.calamity.base.item.thigh_high.MaidArmorItem;
import com.calamityteam.calamity.registry.CLAdvancements;

@Mixin(SculkSensorBlockEntity.class)
public abstract class SculkSensorBlockMixin extends BlockEntity {
	public SculkSensorBlockMixin(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	@Inject(method = "onSignalReceive", at = @At(value = "HEAD"), cancellable = true)
	private void calamity$blockSculkSensorWithItem(ServerLevel level, GameEventListener listener, BlockPos sourcePos, GameEvent gameEvent, Entity sourceEntity, Entity projectileOwner, float distance, CallbackInfo ci) {
		if (!(sourceEntity instanceof Player player)) return;
		if (!(player.getInventory().getArmor(0).getItem() instanceof ComfortablySneaky)) return;
		ci.cancel();
		if (player instanceof ServerPlayer p) {
			CLAdvancements.EVADE_SCULK_COMFY.trigger(p);
		}
	}
}
