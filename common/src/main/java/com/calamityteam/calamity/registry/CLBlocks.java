package com.calamityteam.calamity.registry;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.base.block.Canister.CanisterBlock;
import com.calamityteam.calamity.base.block.PneumaticIO.PneumaticIOBlock;
import com.calamityteam.calamity.base.block.PneumaticPipe.PneumaticPipeBlock;
import com.calamityteam.calamity.base.featurepack.CalamityFeaturePack;
import com.calamityteam.calamity.base.item.CanisterItem;
import com.calamityteam.calamity.multiloader.CommonTags;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.TagGen;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;



import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

public class CLBlocks {
	static {

		Calamity.REGISTRATE.creativeModeTab(() -> CLCreativeModeTab.CALAMITY_TAB);
	}

	/*public static final BlockEntry<DropExperienceBlock> BRASS_ORE = CreateCalamity.REGISTRATE
		.block("brass_ore", DropExperienceBlock::new)
		.lang("Brass ore")
		.properties(properties -> BlockBehaviour.Properties
			.of(Material.STONE)
			.sound(SoundType.NETHER_ORE)
			.strength(3.0F, 3.0F)
			.requiresCorrectToolForDrops())
		.transform(TagGen.pickaxeOnly())
		.loot((lt, b) -> lt.add(b, RegistrateBlockLootTables.createOreDrop(b, AllItems.BRASS_NUGGET.get())))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.transform(TagGen.tagBlockAndItem("ores/brass", "ores_in_ground/netherrack"))
		.build()
		.register();*/

	static {
		Calamity.REGISTRATE.setFeatureFactory(item -> CalamityFeaturePack.BRASS_ORE);
	}

	public static final BlockEntry<DropExperienceBlock> BRASS_ORE = Calamity.REGISTRATE.block("brass_ore", p ->
			new DropExperienceBlock(p, UniformInt.of(3,7)))
		.initialProperties(Material.STONE)
		.properties(p -> p
			.sound(SoundType.NETHER_ORE)
			.strength(3.0f, 3.0f)
			.requiresCorrectToolForDrops())
		.transform(TagGen.pickaxeOnly())
		.loot((lt, b) -> lt.add(b, RegistrateBlockLootTables.createOreDrop(b, AllItems.BRASS_NUGGET.get())))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(CommonTags.ORES.commonWritable)
		.tag(CommonTags.NETHERRACK_ORES.commonWritable)
		.tag(CommonTags.BRASS_ORES.commonWritable)
		.tag(CommonTags.SPARSE_ORES.commonWritable)
		//.transform(TagGen.tagBlockAndItem("ores/brass", "ores_in_ground/netherrack"))
		.item()
		.tag(CommonTags.ORES_ITEM.commonWritable)
		.tag(CommonTags.NETHERRACK_ORES_ITEM.commonWritable)
		.tag(CommonTags.BRASS_ORES_ITEM.commonWritable)
		.build()
		.register();


	public static final  BlockEntry<PneumaticPipeBlock> PNEU_PIPE = Calamity.REGISTRATE.block("pneumatic_pipe",  PneumaticPipeBlock::new)
		.initialProperties(SharedProperties::softMetal)
		.simpleItem()
		.register();

	public static final  BlockEntry<PneumaticIOBlock> PNEU_IO = Calamity.REGISTRATE.block("pneumatic_io",  PneumaticIOBlock::new)
		.initialProperties(SharedProperties::softMetal)
		.simpleItem()
		.register();

	public static final  BlockEntry<CanisterBlock> CANISTER = Calamity.REGISTRATE.block("canister",  CanisterBlock::new)
		.initialProperties(SharedProperties::copperMetal)
		.transform(TagGen.pickaxeOnly())
		.item(CanisterItem::new)
		.build()
		.register();

	static {
		Calamity.REGISTRATE.setFeatureFactory(null);
	}

	public static void register() {
	}
}
