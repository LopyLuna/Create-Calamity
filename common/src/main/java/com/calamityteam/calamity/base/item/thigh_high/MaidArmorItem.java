package com.calamityteam.calamity.base.item.thigh_high;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.jetbrains.annotations.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import com.calamityteam.calamity.util.ComfortablyStuck;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

public class MaidArmorItem extends DyeableArmorItem implements ComfortablyStuck {
	private Multimap<Attribute, AttributeModifier> attributeModifier;
	private static final String SPEED_NAME = "Speed modifier";
	private static final String SPEED_UUID = "91AEAA56-376B-4498-935B-2F7F68070635";
	private final double speedMultiplier;

	public MaidArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
		this.speedMultiplier = 5.5d;
		this.attributeModifier = setEntityAttribute(SPEED_NAME, SPEED_UUID, speedMultiplier,
			AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	private Multimap<Attribute, AttributeModifier> setEntityAttribute(String name, String uuid, Double multiplier, AttributeModifier.Operation operation) {
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		UUID ATTRIBUTE_ID = UUID.fromString(uuid);
		builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(
			ATTRIBUTE_ID, name, multiplier, operation)
		);
		return builder.build();
	}

	@Override
	public int getColor(ItemStack stack) {
		CompoundTag compoundTag = stack.getTagElement("display");
		return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 16099768;
	}

	public static int getTHColor(ItemStack stack) {
		CompoundTag compoundTag = stack.getTagElement("display");
		return compoundTag != null && compoundTag.contains("color", 99) ? compoundTag.getInt("color") : 16099768;
	}

	@Override
	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int slotId, boolean isSelected) {
		super.inventoryTick(itemStack, level, entity, slotId, isSelected);
		if (!(entity instanceof Player player) || level.isClientSide()) return;
		List<ItemStack> armorSet = IntStream.rangeClosed(0, 3).mapToObj(player.getInventory()::getArmor).toList();

		double oldModifier = this.speedMultiplier;
		double newModifier;
		if (armorSet.stream().anyMatch(stack -> !(stack.getItem() instanceof MaidArmorItem))) newModifier = 0.0d;
		else newModifier = this.speedMultiplier;
		if (oldModifier == newModifier) return;

		this.attributeModifier = setEntityAttribute(SPEED_NAME, SPEED_UUID, oldModifier,
			AttributeModifier.Operation.MULTIPLY_TOTAL);
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		return this.attributeModifier;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		tooltipComponents.add(Component.translatable("item.calamity.thigh_highs.tooltip"));
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
