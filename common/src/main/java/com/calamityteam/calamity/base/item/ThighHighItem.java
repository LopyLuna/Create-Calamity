package com.calamityteam.calamity.base.item;

import com.calamityteam.calamity.util.StuckInSlot;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;

public class ThighHighItem extends DyeableArmorItem implements StuckInSlot {
	public ThighHighItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public int getColor(ItemStack stack) {
		CompoundTag compoundTag = stack.getTagElement("display");
		return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 16099768;
	}
	public static boolean isWornBy(Entity entity) {
		return !getWornItem(entity).isEmpty();
	}
	public static ItemStack getWornItem(Entity entity) {
		if (!(entity instanceof LivingEntity livingEntity)) {
			return ItemStack.EMPTY;
		}
		ItemStack stack = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
		if (!(stack.getItem() instanceof ThighHighItem)) {
			return ItemStack.EMPTY;
		}
		return stack;
	}

	public static void speed(LivingEntity entity) {
		if (isWornBy(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 0, true, false, true));
		}
	}

	public static void register() {}
}
