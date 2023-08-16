package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;
import com.calamityteam.calamity.registry.CLCreativeModeTab;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;



public class PlushieRegistry {
	static {
		Calamity.REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_PLUSHIE_TAB);
	}

	static {
		final BlockEntry<Block> HEROBRINE = Calamity.REGISTRATE.block("herobrine", Block::new)
			.item(BlockItem::new).build().register(); // this one doesnt match on purpose, pls dont fix
		final BlockEntry<Block> TO0PA_PLUSH = newPlush("to0pa");
		final BlockEntry<Block> SASCHA_T_PLUSH = newPlush("sascha");
		final BlockEntry<Block> MILKYFUR_PLUSH = newPlush("milkyfur");
		final BlockEntry<Block> PLUSH_506 = newPlush("506");
		final BlockEntry<Block> OUTCRAFT_PLUSH = newPlush("outcraft");
		final BlockEntry<Block> FISJ_PLUSH = newPlush("fisj");
		final BlockEntry<Block> SPYDNEL_PLUSH = newPlush("spydnel");
		final BlockEntry<Block> RAEEEEE_PLUSH = newPlush("raeeeee");
		final BlockEntry<Block> SHIRO_JR_PLUSH = newPlush("shiro_jr");
		final BlockEntry<Block> REDS_PLUSH = newPlush("reds");
		final BlockEntry<Block> TOMATO_SOUPTER_PLUSH = newPlush("tomato_soupter");
		final BlockEntry<Block> POTATO_PLUSH = newPlush("potato");
		final BlockEntry<Block> NULL_PLUSH = newPlush("null");
		final BlockEntry<Block> BAAB_PLUSH = newPlush("baab");
		final BlockEntry<Block> ITHUNDXR_PLUSH = newPlush("ithundxr");
		final BlockEntry<Block> FERN_PLUSH = newPlush("fern");
		final BlockEntry<Block> CAKE_PLUSH = newPlush("cake");
	}

	public static BlockEntry<Block> newPlush(String name) {
		return Calamity.REGISTRATE.block("plushie_" + name, Block::new)
			.item(BlockItem::new)
			.build()
			.register();
	}
	public static void register() {}
}
