package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.base.featurepack.CalamityFeaturePack;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import com.calamityteam.calamity.infrastructure.item.CalamityCreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CLCreativeModeTab {
	public static final CalamityCreativeModeTab CALAMITY_TAB = new CalamityCreativeModeTab("base") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Blocks.TNT.asItem());
		}

		@Override
		public void fillItemList(NonNullList<ItemStack> items) {
			super.fillItemList(items);
			List<ItemStack> disabledItems = new ArrayList<>();
			for (ItemStack itemStack : items) {
				CalamityFeaturePack featurePack = CalamityFeaturePack.REGISTRY.get(itemStack.getItem());
				if (featurePack != null && !featurePack.isEnabled())
					disabledItems.add(itemStack);
			}
			items.removeAll(disabledItems);
		}
	};
	public static final CalamityCreativeModeTab CALAMITY_PLUSHIE_TAB = new CalamityCreativeModeTab("plushie") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(CLPlushies.HEROBRINE_PLUSH.get());
		}
	};
}
