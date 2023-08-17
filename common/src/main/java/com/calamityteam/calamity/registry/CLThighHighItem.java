package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import io.github.fabricators_of_create.porting_lib.item.CustomEnchantmentsItem;
import net.fabricmc.fabric.api.event.AutoInvokingEvent;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Map;

public class CLThighHighItem extends DyeableArmorItem implements CustomEnchantmentsItem {
	public CLThighHighItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
		this.getDefaultInstance().enchant(Enchantments.BINDING_CURSE,1);
		// fixme enchant not applied
	}

	/*@Override
	public ItemStack getDefaultInstance() {
		ItemStack out = new ItemStack(this);
		out.enchant(Enchantments.BINDING_CURSE,1);
		Calamity.LOGGER.debug("apply curse" + out);
		return out;
	}*/

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
		if (!(stack.getItem() instanceof CLThighHighItem)) {
			return ItemStack.EMPTY;
		}
		return stack;
	}

	public static void speed(LivingEntity entity) {
		if (isWornBy(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 0, true, false, true));
		}
	}

	/**
	 * modify the enchantments found on the given stack.
	 * The map is a map of enchantments to the level found on the item. This map is mutable and may be directly modified.
	 *
	 * @param enchantments
	 * @param stack
	 */
	@Override
	public void modifyEnchantments(Map<Enchantment, Integer> enchantments, ItemStack stack) {
		enchantments.put(Enchantments.BINDING_CURSE,1);
		Calamity.LOGGER.debug("add enchant to " + enchantments);
	}

	public static void register() {}
}
