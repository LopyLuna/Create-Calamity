package com.calamityteam.calamity.base.registries;
import com.calamityteam.calamity.Calamity;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import me.alphamode.forgetags.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;

import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

public class BlockRegistry {
	public static void register() {
	}

	public static final BlockEntry<DropExperienceBlock> BRASS_ORE = Calamity.REGISTRATE
			.block("tin_ore", DropExperienceBlock::new)
			.lang("Tin ore")
			.properties(properties -> properties
					.of(Material.STONE)
					.sound(SoundType.NETHER_ORE)
					.strength(3.0F, 3.0F)
					.requiresCorrectToolForDrops())
			.transform(TagGen.pickaxeOnly())
			.loot((lt, b) -> lt.add(b, RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
					RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(AllItems.BRASS_NUGGET.get())
							.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
			.tag(BlockTags.NEEDS_IRON_TOOL)
			.tag(Tags.Blocks.ORES)
			.transform(tagBlockAndItem("ores/brass", "ores_in_ground/netherrack"))
			.tag(Tags.Items.ORES)
			.build()
			.register();
}
