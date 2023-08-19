package com.calamityteam.calamity.base.item.thigh_high;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.IntStream;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import com.calamityteam.calamity.util.ComfortablyStuck;

public class MaidArmorItem extends DyeableArmorItem implements ComfortablyStuck {
	private static final String SPEED_NAME = "Speed modifier";
	private static final UUID SPEED_UUID = UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635");
	private final static double speedMultiplier = 0.5d;

	public MaidArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
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
	public void inventoryTick(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Entity entity,
							  int slotId, boolean isSelected) {
		if (!(entity instanceof Player player)) return;
		Objects.requireNonNull(player.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(SPEED_UUID);
		if (!hasFullSet(player)) return;
		Objects.requireNonNull(player.getAttribute(Attributes.MOVEMENT_SPEED))
			.addTransientModifier(new AttributeModifier(
				SPEED_UUID, SPEED_NAME, speedMultiplier,
				AttributeModifier.Operation.MULTIPLY_TOTAL));

	}

	public static boolean hasFullSet(Entity entity) {
		if (!(entity instanceof Player player)) return false;
		List<ItemStack> armorSet = IntStream.rangeClosed(0, 3).mapToObj(player.getInventory()::getArmor).toList();
		return armorSet.stream().allMatch(stack -> stack.getItem() instanceof MaidArmorItem);
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, @NotNull TooltipFlag isAdvanced) {
		tooltipComponents.add(Component.translatable("item.calamity.thigh_highs.tooltip"));
		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
