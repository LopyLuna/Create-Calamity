package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.infrastructure.item.CalamityCreativeModeTab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import org.jetbrains.annotations.NotNull;

public class CLCreativeModeTab {
	public static final CalamityCreativeModeTab CALAMITY_TAB = new CalamityCreativeModeTab("base") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Blocks.TNT.asItem());
		}
	};
	public static final CalamityCreativeModeTab CALAMITY_PLUSHIE_TAB = new CalamityCreativeModeTab("plushie") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(PlushieRegistry.HEROBRINE.get());
		}
	};
}
