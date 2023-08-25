package com.calamityteam.calamity.base.item.thigh_high;

import com.calamityteam.calamity.util.thigh_high.ComfortablyStuck;

import com.calamityteam.calamity.util.thigh_high.MaidSpeedBonus;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CatEarsItem extends ArmorItem implements ComfortablyStuck, MaidSpeedBonus {
	public CatEarsItem(ArmorMaterial material, EquipmentSlot equipmentSlot, Properties properties) {
		super(material, equipmentSlot, properties);
	}
	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
		tooltipComponents.add(Component.translatable("item.calamity.thigh_highs.tooltip"));
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
