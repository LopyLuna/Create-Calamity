package com.calamityteam.calamity.util;

import com.mojang.brigadier.arguments.ArgumentType;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import dev.architectury.injectables.annotations.ExpectPlatform;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction.Axis;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

public class Util {

	@ExpectPlatform
	public static String platformName() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static Path getConfigDirectory() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerCommand(LiteralArgumentBuilder<CommandSourceStack> command) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerConfig(String id, ModConfig.Type type, IConfigSpec<?> spec, String fileName) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static <A extends ArgumentType<?>, T extends ArgumentTypeInfo.Template<A>, I extends ArgumentTypeInfo<A, T>>
	void registerArgument(String name, Class<A> clazz, I info, ResourceLocation id) {
		throw new AssertionError();
	}

	@SuppressWarnings("SuspiciousNameCombination") // javac doesn't like when we pass a value called "y" to a method that expects a value called "x"
	public static double[] intersect(Vec3 p1, Vec3 p2, Vec3 r, Vec3 s, Axis plane) {
		if (plane == Axis.X) {
			p1 = new Vec3(p1.y, 0, p1.z);
			p2 = new Vec3(p2.y, 0, p2.z);
			r = new Vec3(r.y, 0, r.z);
			s = new Vec3(s.y, 0, s.z);
		}

		if (plane == Axis.Z) {
			p1 = new Vec3(p1.x, 0, p1.y);
			p2 = new Vec3(p2.x, 0, p2.y);
			r = new Vec3(r.x, 0, r.y);
			s = new Vec3(s.x, 0, s.y);
		}

		Vec3 qminusp = p2.subtract(p1);
		double rcs = r.x * s.z - r.z * s.x;
		Vec3 rdivrcs = r.scale(1 / rcs);
		Vec3 sdivrcs = s.scale(1 / rcs);
		double t = qminusp.x * sdivrcs.z - qminusp.z * sdivrcs.x;
		double u = qminusp.x * rdivrcs.z - qminusp.z * rdivrcs.x;
		return new double[]{t, u};
	}

	public static ItemStack copyStackWithSize(ItemStack stack, int size) {
		if (size == 0) return ItemStack.EMPTY;
		ItemStack copy = stack.copy();
		copy.setCount(size);
		return copy;
	}
}
