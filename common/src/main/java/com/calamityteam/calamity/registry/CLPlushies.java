package com.calamityteam.calamity.registry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.calamityteam.calamity.base.block.PlushieBlock;
import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;
import com.calamityteam.calamity.base.block.entities.renderer.PlushieBlockEntityRenderer;
import com.calamityteam.calamity.base.item.PlushieItem;

import com.jozufozu.flywheel.core.PartialModel;

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
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

import com.calamityteam.calamity.Calamity;
import com.tterrag.registrate.util.entry.BlockEntry;

import org.jetbrains.annotations.Nullable;

import static com.simibubi.create.Create.REGISTRATE;


public class CLPlushies {
	static {
		Calamity.REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_PLUSHIE_TAB);
	}

	public record PlushieEntry(
		String name,
		PartialModel model,
		List<Component> tooltip,
		List<RegistryEntry<SoundEvent>> sounds
	) { }

	public record Plushie(PlushieEntry entry, NonNullSupplier<PlushieBlock> block) {}

	public static Map<String, Plushie> PLUSHIES = new HashMap<>();
	public static final BlockEntry<PlushieBlock> HEROBRINE_PLUSH = newPlush(new PlushieEntry(
		"herobrine",
		new PartialModel(Calamity.asResource("partial/plushie_herobrine")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> POUFFY_PLUSH = newPlush(new PlushieEntry(
		"pouffy",
		new PartialModel(Calamity.asResource("partial/plushie_pouffy")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> TO0PA_PLUSH = newPlush(new PlushieEntry(
		"to0pa",
		new PartialModel(Calamity.asResource("partial/plushie_to0pa")),
		List.of(),
		List.of(CLSounds.PLUSHIE_TO0PA)
	));
	public static final BlockEntry<PlushieBlock> SASCHA_PLUSH = newPlush(new PlushieEntry(
		"sascha",
		new PartialModel(Calamity.asResource("partial/plushie_sascha")),
		List.of(),
		List.of(CLSounds.PLUSHIE_SASCHA)
	));
	public static final BlockEntry<PlushieBlock> MILKYFUR_PLUSH = newPlush(new PlushieEntry(
		"milkyfur",
		new PartialModel(Calamity.asResource("partial/plushie_milkyfur")),
		List.of(),
		List.of(CLSounds.PLUSHIE_MILKYFUR_BLUSH, CLSounds.PLUSHIE_MILKYFUR_HONK)
	));
	public static final BlockEntry<PlushieBlock> FIVEOHSIX_PLUSH = newPlush(new PlushieEntry( // you are an scp gordehy
		"506",
		new PartialModel(Calamity.asResource("partial/plushie_506")),
		List.of(Component.translatable("item.calamity.plushie.506.tooltip").withStyle(ChatFormatting.DARK_GRAY)),
		List.of(CLSounds.PLUSHIE_506)
	));
	public static final BlockEntry<PlushieBlock> OUTCRAFT_PLUSH = newPlush(new PlushieEntry(
		"outcraft",
		new PartialModel(Calamity.asResource("partial/plushie_outcraft")),
		List.of(Component.translatable("item.calamity.plushie.outcraft.tooltip").withStyle(ChatFormatting.DARK_GRAY)),
		List.of(CLSounds.PLUSHIE_OUTCRAFT)
	));
	public static final BlockEntry<PlushieBlock> ILLUC_PLUSH = newPlush(new PlushieEntry(
		"illuc",
		new PartialModel(Calamity.asResource("partial/plushie_illuc")),
		List.of(Component.translatable("item.calamity.plushie.illuc.tooltip").withStyle(ChatFormatting.DARK_GRAY)),
		List.of(CLSounds.PLUSHIE_ILLUC)
	));
	public static final BlockEntry<PlushieBlock> SPYDNEL_PLUSH = newPlush(new PlushieEntry(
		"spydnel",
		new PartialModel(Calamity.asResource("partial/plushie_spydnel")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> RAEEEEE_PLUSH = newPlush(new PlushieEntry(
		"raeeeee",
		new PartialModel(Calamity.asResource("partial/plushie_raeeeee")),
		List.of(Component.translatable("item.calamity.plushie.raeeeee.tooltip").withStyle(ChatFormatting.DARK_GRAY)),
		List.of()
	));
	// something tells me im doing this the wrong way
	// nah you are doing good! :D ... Don't mind me, im just cleaning up here.
	// hello chat
	public static final BlockEntry<PlushieBlock> SHIROJR_PLUSH = newPlush(new PlushieEntry(
		"shirojr",
		new PartialModel(Calamity.asResource("partial/plushie_shirojr")),
		List.of(
			Component.translatable("item.calamity.plushie.shirojr.tooltip1").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip2").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip3").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip4").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip5").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip6").withStyle(ChatFormatting.DARK_GRAY),
			Component.translatable("item.calamity.plushie.shirojr.tooltip7").withStyle(ChatFormatting.DARK_GRAY)
		),
		List.of(CLSounds.PLUSHIE_SHIROJR)
	));
	public static final BlockEntry<PlushieBlock> REDS_PLUSH = newPlush(new PlushieEntry(
		"reds",
		new PartialModel(Calamity.asResource("partial/plushie_reds")),
		List.of(),
		List.of(CLSounds.PLUSHIE_REDS)
	));
	public static final BlockEntry<PlushieBlock> TOMATO_SOUPTER_PLUSH = newPlush(new PlushieEntry(
		"tomato_soupter",
		new PartialModel(Calamity.asResource("partial/plushie_tomato_soupter")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> POTATO_PLUSH = newPlush(new PlushieEntry(
		"potato",
		new PartialModel(Calamity.asResource("partial/plushie_potato")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> NULL_PLUSH = newPlush(new PlushieEntry(
		"null",
		new PartialModel(Calamity.asResource("partial/plushie_null")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> BAAB_PLUSH = newPlush(new PlushieEntry(
		"baab",
		new PartialModel(Calamity.asResource("partial/plushie_baab")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> ITHUNDXR_PLUSH = newPlush(new PlushieEntry(
		"ithundxr",
		new PartialModel(Calamity.asResource("partial/plushie_ithundxr")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> FERN_PLUSH = newPlush(new PlushieEntry(
		"fern",
		new PartialModel(Calamity.asResource("partial/plushie_fern")),
		List.of(
			Component.translatable("item.calamity.plushie.fern.tooltip1").withStyle(ChatFormatting.DARK_GREEN),
			Component.translatable("item.calamity.plushie.fern.tooltip2").withStyle(ChatFormatting.GREEN)
		),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> CAKE_PLUSH = newPlush(new PlushieEntry(
		"cake",
		new PartialModel(Calamity.asResource("partial/plushie_cake")),
		List.of(),
		List.of()
	));
	public static final BlockEntry<PlushieBlock> KOLOS_PLUSH = newPlush(new PlushieEntry(
		"kolos",
		new PartialModel(Calamity.asResource("partial/plushie_kolos")),
		List.of(),
		List.of(CLSounds.PLUSHIE_KOLOS)
	));

	// ignore the yellow please
	public static final BlockEntityEntry<PlushieBlockEntity> PLUSHIE_ENTITY = Calamity.REGISTRATE.<PlushieBlockEntity>blockEntity("plushie", PlushieBlockEntity::new)
		.renderer(() -> (context) -> new PlushieBlockEntityRenderer(context))
		.validBlocks(
			PLUSHIES.values().stream().map(Plushie::block).toArray(NonNullSupplier[]::new)
		)
		.register();


	public static BlockEntry<PlushieBlock> newPlush(PlushieEntry entry) {
		var x = Calamity.REGISTRATE.block("plushie_" + entry.name, properties ->
				new PlushieBlock(properties, entry))
			.properties(p -> p.sound(SoundType.WOOL))
			.properties(BlockBehaviour.Properties::noOcclusion)
			.addLayer(() -> RenderType::cutoutMipped)
			.item((plushieBlock, properties) ->
				new PlushieItem(plushieBlock, properties, entry))
			.build()
			.register();
		PLUSHIES.put(entry.name, new Plushie(entry, x::get));
		return x;
	}

	public static void register() {
	}
}
