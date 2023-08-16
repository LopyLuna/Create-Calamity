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

		public static final BlockEntry<PlushieBlock> HEROBRINE = Calamity.REGISTRATE.block("herobrine", PlushieBlock::new)
			.item(BlockItem::new).build().register(); // this one doesnt match on purpose, pls dont fix
		public static final BlockEntry<PlushieBlock> TO0PA_PLUSH = newPlush("to0pa");
		public static final BlockEntry<PlushieBlock> SASCHA_T_PLUSH = newPlush("sascha");
		public static final BlockEntry<PlushieBlock> MILKYFUR_PLUSH = newPlush("milkyfur");
		public static final BlockEntry<PlushieBlock> PLUSH_506 = newPlush("506");
		public static final BlockEntry<PlushieBlock> OUTCRAFT_PLUSH = newPlush("outcraft");
		public static final BlockEntry<PlushieBlock> ILLUC_PLUSH = newPlush("illuc");
		public static final BlockEntry<PlushieBlock> SPYDNEL_PLUSH = newPlush("spydnel");
		public static final BlockEntry<PlushieBlock> RAEEEEE_PLUSH = newPlush("raeeeee");
		public static final BlockEntry<PlushieBlock> SHIRO_JR_PLUSH = newPlush("shiro_jr");
		public static final BlockEntry<PlushieBlock> REDS_PLUSH = newPlush("reds");
		public static final BlockEntry<PlushieBlock> TOMATO_SOUPTER_PLUSH = newPlush("tomato_soupter");
		public static final BlockEntry<PlushieBlock> POTATO_PLUSH = newPlush("potato");
		public static final BlockEntry<PlushieBlock> NULL_PLUSH = newPlush("null");
		public static final BlockEntry<PlushieBlock> BAAB_PLUSH = newPlush("baab");
		public static final BlockEntry<PlushieBlock> ITHUNDXR_PLUSH = newPlush("ithundxr");
		public static final BlockEntry<PlushieBlock> FERN_PLUSH = newPlush("fern");
		public static final BlockEntry<PlushieBlock> CAKE_PLUSH = newPlush("cake");

	public static BlockEntry<PlushieBlock> newPlush(String name) {
		return Calamity.REGISTRATE.block("plushie_" + name, PlushieBlock::new)
			.item(BlockItem::new)
			.build()
			.register();
	}
	public static void register() {}
}
