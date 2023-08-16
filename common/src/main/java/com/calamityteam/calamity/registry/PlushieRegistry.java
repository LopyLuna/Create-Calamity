package com.calamityteam.calamity.registry;

import java.util.List;

import com.calamityteam.calamity.base.block.PlushieBlock;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.calamityteam.calamity.Calamity;
import com.tterrag.registrate.util.entry.BlockEntry;


public class PlushieRegistry {
	static {
		Calamity.REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_PLUSHIE_TAB);
	}

	public static final BlockEntry<PlushieBlock> HEROBRINE = Calamity.REGISTRATE.block("herobrine",
			properties -> new PlushieBlock(properties, null))
		.properties(BlockBehaviour.Properties::noOcclusion)
		.addLayer(() -> RenderType::cutoutMipped)
		.item(BlockItem::new).build().register(); // this one doesn't match on purpose, pls don't fix
	public static final BlockEntry<PlushieBlock> TO0PA_PLUSH = newPlush("to0pa",
		List.of(CLSounds.PLUSHIE_TO0PA));
	public static final BlockEntry<PlushieBlock> SASCHA_PLUSH = newPlush("sascha",
		List.of(CLSounds.PLUSHIE_SASCHA));
	public static final BlockEntry<PlushieBlock> MILKYFUR_PLUSH = newPlush("milkyfur",
		List.of(CLSounds.PLUSHIE_MILKYFUR_HONK, CLSounds.PLUSHIE_MILKYFUR_BLUSH));
	public static final BlockEntry<PlushieBlock> PLUSH_506 = newPlush("506",
		List.of(CLSounds.PLUSHIE_506));
	public static final BlockEntry<PlushieBlock> OUTCRAFT_PLUSH = newPlush("outcraft",
		List.of(CLSounds.PLUSHIE_OUTCRAFT));
	public static final BlockEntry<PlushieBlock> ILLUC_PLUSH = newPlush("illuc",
		List.of(CLSounds.PLUSHIE_ILLUC));
	public static final BlockEntry<PlushieBlock> SPYDNEL_PLUSH = newPlush("spydnel");
	public static final BlockEntry<PlushieBlock> RAEEEEE_PLUSH = newPlush("raeeeee");
	public static final BlockEntry<PlushieBlock> SHIROJR_PLUSH = newPlush("shirojr",
		List.of(CLSounds.PLUSHIE_SHIROJR));
	public static final BlockEntry<PlushieBlock> REDS_PLUSH = newPlush("reds",
		List.of(CLSounds.PLUSHIE_REDS));
	public static final BlockEntry<PlushieBlock> TOMATO_SOUPTER_PLUSH = newPlush("tomato_soupter");
	public static final BlockEntry<PlushieBlock> POTATO_PLUSH = newPlush("potato");
	public static final BlockEntry<PlushieBlock> NULL_PLUSH = newPlush("null");
	public static final BlockEntry<PlushieBlock> BAAB_PLUSH = newPlush("baab");
	public static final BlockEntry<PlushieBlock> ITHUNDXR_PLUSH = newPlush("ithundxr");
	public static final BlockEntry<PlushieBlock> FERN_PLUSH = newPlush("fern");
	public static final BlockEntry<PlushieBlock> CAKE_PLUSH = newPlush("cake");


	public static BlockEntry<PlushieBlock> newPlush(String name) {
		return newPlush(name, null);
	}
	public static BlockEntry<PlushieBlock> newPlush(String name, List<RegistryEntry<SoundEvent>> sounds) {
		return Calamity.REGISTRATE.block("plushie_" + name, properties -> new PlushieBlock(properties, sounds))
			.properties(BlockBehaviour.Properties::noOcclusion)
			.addLayer(() -> RenderType::cutoutMipped)
			.item(BlockItem::new)
			.build()
			.register();
	}

	public static void register() {
	}
}
