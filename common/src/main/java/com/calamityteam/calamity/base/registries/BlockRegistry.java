package com.calamityteam.calamity.base.registries;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.TagGen;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import com.calamityteam.calamity.CreateCalamity;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

public class BlockRegistry {
	public static void register() {
	}

	public static final BlockEntry<DropExperienceBlock> BRASS_ORE = CreateCalamity.REGISTRATE
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
		.register();
}
