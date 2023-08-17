package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;

import com.google.common.base.Suppliers;

import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.Create;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public enum CLArmorMaterials implements ArmorMaterial {

	THIGH_HIGH(Calamity.asResource("thigh_highs").toString(), 15, new int[] { 1, 4, 5, 2 }, 12, () -> SoundEvents.WOOL_PLACE, 0.0F, 0.0F,
		() -> Ingredient.of(ItemTags.WOOL))

	;

	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final Supplier<SoundEvent> soundEvent;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairMaterial;

	private CLArmorMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability,
							  Supplier<SoundEvent> soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.maxDamageFactor = maxDamageFactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairMaterial = Suppliers.memoize(repairMaterial::get);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot slot) {
		return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot slot) {
		return this.damageReductionAmountArray[slot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.soundEvent.get();
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
