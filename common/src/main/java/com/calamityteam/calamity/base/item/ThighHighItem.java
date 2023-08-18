package com.calamityteam.calamity.base.item;

import java.util.List;
import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import com.calamityteam.calamity.util.ComfortablyStuck;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class ThighHighItem extends DyeableArmorItem implements ComfortablyStuck {
	private final Multimap<Attribute, AttributeModifier> attributeModifier;

	public ThighHighItem(ArmorMaterial material, Double speedMultiplier, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);

		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		UUID SPEED_ATTRIBUTE_ID = UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635");
		builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(
			SPEED_ATTRIBUTE_ID, "Speed modifier", speedMultiplier, AttributeModifier.Operation.MULTIPLY_TOTAL)
		);
		this.attributeModifier = builder.build();
	}

	@Override
	public int getColor(ItemStack stack) {
		CompoundTag compoundTag = stack.getTagElement("display");
		return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 16099768;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		if (slot == EquipmentSlot.LEGS) {
			return this.attributeModifier;
		}
		return super.getDefaultAttributeModifiers(slot);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		tooltipComponents.add(Component.translatable("item.calamity.thigh_highs.tooltip"));
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
