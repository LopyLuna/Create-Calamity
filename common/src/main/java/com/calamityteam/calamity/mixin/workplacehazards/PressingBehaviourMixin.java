package com.calamityteam.calamity.mixin.workplacehazards;

import com.calamityteam.calamity.mixin.KineticBlockEntityAccessor;
import com.simibubi.create.content.kinetics.belt.behaviour.BeltProcessingBehaviour;
import com.simibubi.create.content.kinetics.press.BeltPressingCallbacks;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.phys.AABB;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.calamityteam.calamity.CreateCalamity.DAMAGE_SOURCE_CRUSHING;

/**
 * Mixin for implementing the pressing hazards.
 *
 * @author Sascha_T
 */
@Mixin(PressingBehaviour.class)
public abstract class PressingBehaviourMixin extends BeltProcessingBehaviour {
	// hurr durr, shut up mixins
	public PressingBehaviourMixin(SmartBlockEntity be) {
		super(be);
	}

	@Shadow
	@Final
	public static int CYCLE;

	@Shadow
	public int runningTicks;


	@Shadow
	public abstract void start(PressingBehaviour.Mode mode);

	@Shadow
	public boolean running;

    @Shadow public PressingBehaviour.PressingBehaviourSpecifics specifics;

    /*
                    0         = Start
                    CYCLE / 2 = Process
                    CYCLE     = End

                    Force players into a crouched position from 20% to 80%
                    Damage them when within 40% to 60% or kill on proc
                 */
	@Inject(at = @At("HEAD"), method = "tick", remap = false)
	void tick(CallbackInfo ci) {
        if(getWorld().isClientSide)
            return;

		Level world = getWorld();
		BlockPos pos = getPos();

		double cyclePosition = (double) runningTicks / CYCLE; // turn this whole booger into a double because we can, and because i like this more
		var targets = world.getEntitiesOfClass(LivingEntity.class, new AABB(pos.below())); // find people below this press

		if (!targets.isEmpty() && !running) // if there are people to crush, and it isn't running yet
			start(PressingBehaviour.Mode.WORLD); // then maybe you should start running :)

        MechanicalPressBlockEntity mechanicalPress = (MechanicalPressBlockEntity) blockEntity;
        KineticBlockEntityAccessor accessor = (KineticBlockEntityAccessor) mechanicalPress;

        float stressCoefficient = Math.min(accessor.getMaxStress() - accessor.getStress(), 2048) / 2048; // 2048 is instant kill (@todo: config)
        float speedCoefficient  = (specifics.getKineticSpeed() / 256f) * 0.1f; // 256 is 10% @todo: double config

		if (cyclePosition == 0.5) // if the cycle is at it's half-point, meaning we have reached the ground
			for (LivingEntity target : targets) {
                if(target instanceof Player p && p.isCreative())
                    continue; // do not harm creative players' items
                ItemStack headSlot = target.getItemBySlot(EquipmentSlot.HEAD);
                headSlot.hurt((int) (headSlot.getMaxDamage() * speedCoefficient), world.getRandom(), null);

                target.hurt(DAMAGE_SOURCE_CRUSHING, target.getHealth() * stressCoefficient); // we hurt everyone
            }
	}
}
