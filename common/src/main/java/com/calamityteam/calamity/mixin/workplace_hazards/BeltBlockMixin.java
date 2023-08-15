package com.calamityteam.calamity.mixin.workplace_hazards;

import com.simibubi.create.content.kinetics.belt.BeltBlock;

import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltSlope;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.core.Direction.AxisDirection.NEGATIVE;
import static net.minecraft.core.Direction.AxisDirection.POSITIVE;

@Mixin(BeltBlock.class)
public abstract class BeltBlockMixin {
	@Shadow
	@Final
	public static Property<BeltSlope> SLOPE;


	@Inject(method = "entityInside", at=@At("HEAD"))
	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn, CallbackInfo ci) {
		BeltSlope slope = state.getValue(SLOPE);
		Direction facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
		BeltBlockEntity beltBE = ((BeltBlockEntity) worldIn.getBlockEntity(pos));
		Direction movementFacing =
			Direction.fromAxisAndDirection(facing
				.getAxis(), beltBE.getSpeed() < 0 ? POSITIVE : NEGATIVE);
		if(slope != BeltSlope.VERTICAL) // keep it simple for now @todo: fling at ends
			return;

		if(entityIn.getBlockY() - 1 != pos.getY()) {
			Direction.Axis axis = facing.getAxis();
			double upFactor = beltBE.getSpeed() / 128.0f;
			double sideFactor = 0.5;

			Vec3 upwards = new Vec3(
				0,
				1,
				0
			); // go up :p

			Vec3 sidewards = new Vec3(
				entityIn.getX() - pos.getX(),
				0,
				entityIn.getZ() - pos.getZ()
			);

			if(axis == Direction.Axis.X) {
				if(sidewards.z < 0.2 || sidewards.z > 0.8)
					return;
				double x = sidewards.x > 0 ? 1 : -1; // ensure consistent sidewards speed
				sidewards = new Vec3(x, 0, 0);
				if(Direction.fromNormal((int) x, 0, 0) == movementFacing) // if we're on the other side, go down
					upwards = upwards.multiply(-1, -1, -1);
			} else if(axis == Direction.Axis.Z) {
				if(sidewards.x < 0.2 || sidewards.x > 0.8)
					return;
				double z = sidewards.z > 0 ? 1 : -1; // ensure consistent sidewards speed
				sidewards = new Vec3(0, 0, z);

				if(Direction.fromNormal(0, 0, (int) z) == movementFacing) // if we're on the other side, go down
					upwards = upwards.multiply(-1, -1, -1);
			}

			if(upwards.y < 0)
				entityIn.fallDistance = (float) (7 * upFactor);

			upwards = upwards.multiply(upFactor, upFactor, upFactor).add(sidewards.multiply(sideFactor, sideFactor, sideFactor));
			entityIn.setDeltaMovement(upwards);
		}
	}

}
