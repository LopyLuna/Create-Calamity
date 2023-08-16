package com.calamityteam.calamity.base.item;

import com.simibubi.create.foundation.item.CustomArmPoseItem;

import io.github.fabricators_of_create.porting_lib.mixin.client.accessor.ParticleAccessor;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.model.HumanoidModel.ArmPose;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

public class TrumpetItem extends Item implements CustomArmPoseItem, ParticleProvider {


	public TrumpetItem(Properties properties) {
		super(properties);
	}

	public ArmPose getArmPose(ItemStack stack, AbstractClientPlayer player, InteractionHand hand) {
		ArmPose getArmPose = getArmPose(stack, player, hand);

		if(player.isUsingItem()) {
			getArmPose = ArmPose.CROSSBOW_CHARGE;
		} else {
			getArmPose = ArmPose.TOOT_HORN;
		}

		return getArmPose;
	}


	@Nullable
	@Override
	public Particle createParticle(ParticleOptions type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		Particle createParticle;

		LivingEntity player = null;
		if(player.isUsingItem()) {
			createParticle = createParticle(type, level, x, y, z, 1, 1, 1);
		} else {
			createParticle = null;
		}

		return createParticle;
	}
}
