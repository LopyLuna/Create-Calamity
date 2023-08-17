package com.calamityteam.calamity.registry;

import java.util.List;

import com.calamityteam.calamity.base.block.Plushie.PlushieBlock;
import com.calamityteam.calamity.base.block.Plushie.PlushieItem;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.calamityteam.calamity.Calamity;
import com.tterrag.registrate.util.entry.BlockEntry;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import javax.annotation.Nullable;


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
		List.of(CLSounds.PLUSHIE_TO0PA),List.of());
	public static final BlockEntry<PlushieBlock> SASCHA_PLUSH = newPlush("sascha",
		List.of(CLSounds.PLUSHIE_SASCHA),List.of());
	public static final BlockEntry<PlushieBlock> MILKYFUR_PLUSH = newPlush("milkyfur",
		List.of(CLSounds.PLUSHIE_MILKYFUR_HONK, CLSounds.PLUSHIE_MILKYFUR_BLUSH), List.of());
	public static final BlockEntry<PlushieBlock> PLUSH_506 = newPlush("506",
		List.of(CLSounds.PLUSHIE_506),List.of(  Component.translatable("item.calamity.plushie.506.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> OUTCRAFT_PLUSH = newPlush("outcraft",
		List.of(CLSounds.PLUSHIE_OUTCRAFT),List.of(  Component.translatable("item.calamity.plushie.outcraft.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> ILLUC_PLUSH = newPlush("illuc",
		List.of(CLSounds.PLUSHIE_ILLUC), List.of( Component.translatable("item.calamity.plushie.illuc.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> SPYDNEL_PLUSH = newPlush("spydnel", List.of());
	public static final BlockEntry<PlushieBlock> RAEEEEE_PLUSH = newPlush("raeeeee",
		List.of(Component.translatable("item.calamity.plushie.raeeeee.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	//something tells me im doing this the wrong way
	public static final BlockEntry<PlushieBlock> SHIROJR_PLUSH = newPlush("shirojr",
		List.of(CLSounds.PLUSHIE_SHIROJR),List.of(
			Component.translatable("item.calamity.plushie.shirojr.tooltip1").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip2").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip3").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip4").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip5").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip6").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip7").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> REDS_PLUSH = newPlush("reds",
		List.of(CLSounds.PLUSHIE_REDS),List.of());
	public static final BlockEntry<PlushieBlock> TOMATO_SOUPTER_PLUSH = newPlush("tomato_soupter", List.of());
	public static final BlockEntry<PlushieBlock> POTATO_PLUSH = newPlush("potato", List.of());
	public static final BlockEntry<PlushieBlock> NULL_PLUSH = newPlush("null", List.of());
	public static final BlockEntry<PlushieBlock> BAAB_PLUSH = newPlush("baab", List.of());
	public static final BlockEntry<PlushieBlock> ITHUNDXR_PLUSH = newPlush("ithundxr", List.of());
	public static final BlockEntry<PlushieBlock> FERN_PLUSH = newPlush("fern", List.of(Component.translatable("item.calamity.plushie.fern.tooltip1").withStyle(ChatFormatting.DARK_GREEN),Component.translatable("item.calamity.plushie.fern.tooltip2").withStyle(ChatFormatting.GREEN) ));
	public static final BlockEntry<PlushieBlock> CAKE_PLUSH = newPlush("cake", List.of());


	public static BlockEntry<PlushieBlock> newPlush(String name, List<Component> toolTip) {
		return newPlush(name,null, toolTip);
	}
	public static BlockEntry<PlushieBlock> newPlush(String name, List<RegistryEntry<SoundEvent>> sounds,  List<Component> textToolTip) {
		return Calamity.REGISTRATE.block("plushie_" + name, properties -> new PlushieBlock(properties, sounds))
			.properties(BlockBehaviour.Properties::noOcclusion)
			.addLayer(() -> RenderType::cutoutMipped)
			.item((plushieBlock, properties) -> new PlushieItem(plushieBlock,properties,textToolTip))
			.build()
			.register();
	}

	public static void register() {
	}
}
