package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import org.jetbrains.annotations.NotNull;

public class CLCreativeModeTab {
	public static final CreativeModeTab CALAMITY_TAB = new CreativeModeTab(0, Calamity.MOD_ID) {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Blocks.TNT.asItem());
		}
	};
	public static final CreativeModeTab CALAMITY_PLUSHIE_TAB = new CreativeModeTab(0,Calamity.MOD_ID) {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(Blocks.TNT.asItem());
		}
	};
}
