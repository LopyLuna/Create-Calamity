package com.calamityteam.calamity.registry;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.calamityteam.calamity.base.block.PlushieBlock;
import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;
import com.calamityteam.calamity.base.block.entities.renderer.PlushieBlockEntityRenderer;
import com.calamityteam.calamity.base.item.PlushieItem;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.deployer.DeployerBlockEntity;
import com.simibubi.create.content.kinetics.deployer.DeployerInstance;
import com.simibubi.create.content.kinetics.deployer.DeployerRenderer;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;

import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.calamityteam.calamity.Calamity;
import com.tterrag.registrate.util.entry.BlockEntry;

import org.jetbrains.annotations.Nullable;

import static com.simibubi.create.Create.REGISTRATE;


public class CLPlushies {
	static {
		Calamity.REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_PLUSHIE_TAB);
	}

	public static final Set<BlockEntry<PlushieBlock>> PLUSHIES = new HashSet<>();
	public static final BlockEntry<PlushieBlock> HEROBRINE = Calamity.REGISTRATE.block("herobrine",
			properties -> new PlushieBlock(properties, null))
		.properties(BlockBehaviour.Properties::noOcclusion)
		.addLayer(() -> RenderType::cutoutMipped)
		.item(BlockItem::new).build().register(); // this one doesn't match on purpose, pls don't fix
	public static final BlockEntry<PlushieBlock> TO0PA_PLUSH = newPlush("to0pa",
		List.of(CLSounds.PLUSHIE_TO0PA), null);
	public static final BlockEntry<PlushieBlock> SASCHA_PLUSH = newPlush("sascha",
		List.of(CLSounds.PLUSHIE_SASCHA), null);
	public static final BlockEntry<PlushieBlock> MILKYFUR_PLUSH = newPlush("milkyfur",
		List.of(CLSounds.PLUSHIE_MILKYFUR_HONK, CLSounds.PLUSHIE_MILKYFUR_BLUSH), null);
	public static final BlockEntry<PlushieBlock> PLUSH_506 = newPlush("506",
		List.of(CLSounds.PLUSHIE_506),
		List.of(Component.translatable("item.calamity.plushie.506.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> OUTCRAFT_PLUSH = newPlush("outcraft",
		List.of(CLSounds.PLUSHIE_OUTCRAFT),
		List.of(Component.translatable("item.calamity.plushie.outcraft.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> ILLUC_PLUSH = newPlush("illuc",
		List.of(CLSounds.PLUSHIE_ILLUC),
		List.of(Component.translatable("item.calamity.plushie.illuc.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> SPYDNEL_PLUSH = newPlush("spydnel",
		null, null);
	public static final BlockEntry<PlushieBlock> RAEEEEE_PLUSH = newPlush("raeeeee",
		null, List.of(Component.translatable("item.calamity.plushie.raeeeee.tooltip").withStyle(ChatFormatting.DARK_GRAY)));
	// something tells me im doing this the wrong way
	// nah you are doing good! :D ... Don't mind me, im just cleaning up here.
	public static final BlockEntry<PlushieBlock> SHIROJR_PLUSH = newPlush("shirojr",
		List.of(CLSounds.PLUSHIE_SHIROJR),
		List.of(Component.translatable("item.calamity.plushie.shirojr.tooltip1").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip2").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip3").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip4").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip5").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip6").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip7").withStyle(ChatFormatting.DARK_GRAY)));
	public static final BlockEntry<PlushieBlock> REDS_PLUSH = newPlush("reds",
		List.of(CLSounds.PLUSHIE_REDS),null);
	public static final BlockEntry<PlushieBlock> TOMATO_SOUPTER_PLUSH = newPlush("tomato_soupter",
		null, null);
	public static final BlockEntry<PlushieBlock> POTATO_PLUSH = newPlush("potato",
		null, null);
	public static final BlockEntry<PlushieBlock> NULL_PLUSH = newPlush("null",
		null, null);
	public static final BlockEntry<PlushieBlock> BAAB_PLUSH = newPlush("baab",
		null, null);
	public static final BlockEntry<PlushieBlock> ITHUNDXR_PLUSH = newPlush("ithundxr",
		null, null);
	public static final BlockEntry<PlushieBlock> FERN_PLUSH = newPlush("fern",
		null, List.of(Component.translatable("item.calamity.plushie.fern.tooltip1").withStyle(ChatFormatting.DARK_GREEN),Component.translatable("item.calamity.plushie.fern.tooltip2").withStyle(ChatFormatting.GREEN) ));
	public static final BlockEntry<PlushieBlock> CAKE_PLUSH = newPlush("cake",
		null, null);
	public static final BlockEntry<PlushieBlock> KOLOS_PLUSH = newPlush("kolos",
		List.of(CLSounds.PLUSHIE_KOLOS), null);

	public static final BlockEntityEntry<PlushieBlockEntity> PLUSHIE_ENTITY = Calamity.REGISTRATE.blockEntity("plushies", PlushieBlockEntity::new)
		.renderer(() -> PlushieBlockEntityRenderer::new)
		.validBlocks(PLUSHIES.stream().map(a -> (NonNullSupplier<PlushieBlock>) a::get).toArray(NonNullSupplier[]::new) )
		.register();


	public static BlockEntry<PlushieBlock> newPlush(String name, @Nullable List<RegistryEntry<SoundEvent>> sounds, @Nullable List<Component> textToolTip) {
		var x = Calamity.REGISTRATE.block("plushie_" + name, properties ->
				new PlushieBlock(properties, sounds != null ? sounds : List.of()))
			.properties(p -> p.sound(SoundType.WOOL))
			.properties(BlockBehaviour.Properties::noOcclusion)
			.addLayer(() -> RenderType::cutoutMipped)
			.item((plushieBlock, properties) ->
				new PlushieItem(plushieBlock,properties, textToolTip != null ? textToolTip : List.of()))
			.build()
			.register();
		PLUSHIES.add(x);
		return x;
	}

	public static void register() {
	}
}
