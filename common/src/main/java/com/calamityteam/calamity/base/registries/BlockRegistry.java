package com.calamityteam.calamity.base.registries;

import com.calamityteam.calamity.ModCreativeModeTab;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.TagGen;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import static com.calamityteam.calamity.CreateCalamity.REGISTRATE;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

public class BlockRegistry {
	static {
		REGISTRATE.creativeModeTab(() -> ModCreativeModeTab.CALAMITY_TAB);
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
	public static final BlockEntry<DropExperienceBlock> BRASS_ORE = REGISTRATE.block("brass_ore", p ->
		new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
			.sound(SoundType.NETHER_ORE)
			.strength(3.0f,3.0f)
			.requiresCorrectToolForDrops(),
			UniformInt.of(3,7)))
		.transform(TagGen.pickaxeOnly())
		.loot((lt, b) -> lt.add(b, RegistrateBlockLootTables.createOreDrop(b, AllItems.BRASS_NUGGET.get())))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.transform(TagGen.tagBlockAndItem("ores/brass", "ores_in_ground/netherrack"))
		.build()
		.register();




	public static void register() {
	}
}
