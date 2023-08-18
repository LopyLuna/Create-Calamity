package com.calamityteam.calamity.mixin.workplace_hazards;

import com.calamityteam.calamity.registry.CLAdvancements;
import com.calamityteam.calamity.registry.CLDamageSources;

import com.mojang.datafixers.util.Pair;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;

import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.phys.AABB;

import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;

@Mixin(BracketedKineticBlockEntity.class)
public class BracketedKineticBlockEntityMixin extends SimpleKineticBlockEntity {
	public BracketedKineticBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}

	@Unique
	private Entity crushEntity = null;
	@Unique
	private Vec3 crushMiddle = null;
	@Unique
	private double tick = 0;

	@Override
	public void tick() {
		super.tick();

		var COGWHEEL = AllBlocks.COGWHEEL.get();
		var STATE = getBlockState();
		if (STATE.getBlock() != COGWHEEL)
			return;
		if (crushEntity == null) {
			var entities = level.getEntities(null, new AABB(getBlockPos().above()));
			Direction.Axis axis = COGWHEEL.getRotationAxis(STATE);
			for (Entity entity : entities) {
				// do not crush people in the middle
				var subX = Math.abs(entity.getX() % 1.0);
				var subZ = Math.abs(entity.getZ() % 1.0);
				if (axis == Direction.Axis.X) {
					if (subZ % 1.0 > 0.2 && subZ % 1.0 < 0.8)
						continue;
					if (subX % 1.0 < 0.4 || subX % 1.0 > 0.6)
						continue;
				} else if (axis == Direction.Axis.Z) {
					if (subX % 1.0 > 0.2 && subX % 1.0 < 0.8)
						continue;
					if (subZ % 1.0 < 0.4 || subZ % 1.0 > 0.6)
						continue;
				} else { continue; }

				var ret = findSecond(level, getBlockPos(), entity, axis);
				if (ret == null)
					continue; // do not
				if (!validPair(ret.getSecond(), (BracketedKineticBlockEntity) (Object) this, axis))
					continue;
				var posB = ret.getFirst();
				var posA = getBlockPos();
				if (ret != null) {
					crushEntity = entity;
					crushMiddle = new Vec3(
						((posB.getX() + 0.5) + (posA.getX() + 0.5)) / 2,
						posA.getY() - 0.5,
						((posB.getZ() + 0.5) + (posA.getZ() + 0.5)) / 2
					);
					tick = 0;
					break;
				}
			}
		}
		if (crushEntity != null) {
			double distanceMiddle = Math.min(
				Math.abs(crushMiddle.y + 0.5 - crushEntity.getEyeY()),
				Math.abs(crushMiddle.y - 0.5 - crushEntity.getY())
			);
			if (distanceMiddle > 2) {
				crushEntity = null;
				return;
			} // emergency cancel to prevent railgun behaviour

			double downSpeed = distanceMiddle * (Math.abs(getSpeed()) / 128) + (1.0 / 200);

			double xMotion = (crushMiddle.x - crushEntity.getX()) / 2f;
			double zMotion = (crushMiddle.z - crushEntity.getZ()) / 2f;

			double newY = crushEntity.getY() - downSpeed;

			if (crushEntity instanceof LivingEntity living && tick % 20 == 0) {
				double damage = Math.max(
					(float) ((getSpeed() / 128.0) * 10),
					2
				);
				double newHealth = living.getHealth() - damage;
				living.hurt(CLDamageSources.DAMAGE_SOURCE_CRUNCHING, (float) damage); // do atleast 2 damage, and 5 hearts for 128

				if (getSpeed() >= 256 && newHealth <= 0 && living instanceof ServerPlayer sp)
					CLAdvancements.COG_CRUNCH.trigger(sp);

			}

			crushEntity.setPos(crushEntity.getX(), Math.max(newY, crushMiddle.y - 1.8), crushEntity.getZ());
			crushEntity.setDeltaMovement(xMotion, -downSpeed, zMotion);
			if (newY < crushMiddle.y - 1.8) {
				crushEntity.fallDistance = (float) (crushEntity.getDeltaMovement().length() * 10);
				crushEntity = null;
			}
			tick++;
		}

	}

	private boolean validPair(BracketedKineticBlockEntity a, BracketedKineticBlockEntity b, Direction.Axis axis) {
		BracketedKineticBlockEntity left = null;
		BracketedKineticBlockEntity right = null;

		if (axis == Direction.Axis.X)
			if (a.getBlockPos().getZ() > b.getBlockPos().getZ()) {
				right = a;
				left = b;
			} else {
				left = a;
				right = b;
			}

		else if (axis == Direction.Axis.Z)
			if (a.getBlockPos().getX() > b.getBlockPos().getX()) {
				right = b;
				left = a;
			} else {
				right = a;
				left = b;
			}

		return left.getSpeed() > 0 && right.getSpeed() < 0;
	}

	@Unique
	private final double MIDDLE = 0.22;

	@Unique
	@Nullable
	private Pair<BlockPos, BracketedKineticBlockEntity> findSecond(Level level, BlockPos pos, Entity entity, Direction.Axis axis) {
		Direction.Axis other = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X; // get the axis of the gear plane
		Vec3 blockVec = new Vec3(pos.getX(), 0, pos.getZ()); // yup
		Vec3 entityVec = new Vec3(entity.getX(), pos.getY(), entity.getZ()); // mhm
		Vec3 offset = entityVec.subtract(blockVec); // figure out the offset

		double isolate = other.choose(offset.x, offset.y, offset.z); // isolate the relevant value
		if (isolate > 0.5 - MIDDLE && isolate < 0.5 + MIDDLE) // dont mess with player if theyre in the middle
			return null;

		BlockPos second = pos.relative(other, isolate > 0.5 ? 1 : -1); // move in that direction
		BlockEntity blockEntity2 = level.getBlockEntity(second);

		if (blockEntity2 instanceof BracketedKineticBlockEntity kinetic) { // check it
			return new Pair<>(second, kinetic);
		}

		return null;
	}
}
