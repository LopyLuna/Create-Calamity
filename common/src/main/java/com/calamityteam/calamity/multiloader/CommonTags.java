package com.calamityteam.calamity.multiloader;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import org.jetbrains.annotations.Nullable;

public class CommonTags {
	public static final CommonTag<Item>
			STRING = item("string"),
			IRON_NUGGETS = item("nuggets/iron_nuggets", "iron_nuggets", "nuggets/iron"),
			ZINC_NUGGETS = item("nuggets/zinc_nuggets", "zinc_nuggets", "nuggets/zinc"),
			BRASS_NUGGETS = item("nuggets/brass_nuggets", "brass_nuggets", "nuggets/brass"),
			IRON_PLATES = item("plates/iron_plates", "iron_plates", "plates/iron"),
			BRASS_PLATES = item("plates/brass_plates", "brass_plates", "plates/brass"),
			COPPER_INGOTS = item("ingots/copper_ingots", "copper_ingots", "ingots/copper"),
			IRON_INGOTS = item("ingots/iron_ingots", "iron_ingots", "ingots/iron");

	public static final Map<DyeColor, CommonTag<Item>> DYES = Util.make(new EnumMap<>(DyeColor.class), dyes -> {
		for (DyeColor color : DyeColor.values()) {
			String name = color.getName();
			String common = "dyes/" + name + "_dyes";
			String fabric = name + "_dyes";
			String forge = "dyes/" + name;
			dyes.put(color, item(common, fabric, forge));
		}
	});

	public static final CommonTag<Block>
			RELOCATION_NOT_SUPPORTED = block("relocation_not_supported");

	public static final BidirectionalCommonTag<Block>
		ORES = blockShared("ores"),
		NETHERRACK_ORES = blockShared("ores_in_ground/netherrack", "ores_in_ground/netherrack", "ore_bearing_ground/netherrack"),
		BRASS_ORES = blockShared("ores/brass", "brass_ores", "ores/brass"),
		SPARSE_ORES = blockShared("ore_rates/sparse", null, "ore_rates/sparse")
	;

	public static final BidirectionalCommonTag<Item>
		ORES_ITEM = from(ORES),
		NETHERRACK_ORES_ITEM = from(NETHERRACK_ORES),
		BRASS_ORES_ITEM = from(BRASS_ORES)
	;

	private static BidirectionalCommonTag<Item> from(BidirectionalCommonTag<Block> source) {
		return itemShared(source.tag.location().getPath(), source.fabric == null ? null : source.fabric.location().getPath(),
			source.forge == null ? null : source.forge.location().getPath());
	}

	public static CommonTag<Block> block(String path) {
		return CommonTag.conventional(Registry.BLOCK_REGISTRY, path);
	}

	public static BidirectionalCommonTag<Block> blockShared(String common, @Nullable String fabric, @Nullable String forge) {
		return BidirectionalCommonTag.conventional(Registry.BLOCK_REGISTRY, common, fabric, forge);
	}

	public static BidirectionalCommonTag<Block> blockShared(String path) {
		return blockShared(path, path, path);
	}

	public static CommonTag<Item> item(String common, String fabric, String forge) {
		return CommonTag.conventional(Registry.ITEM_REGISTRY, common, fabric, forge);
	}

	public static CommonTag<Item> item(String path) {
		return item(path, path, path);
	}

	public static BidirectionalCommonTag<Item> itemShared(String common, @Nullable String fabric, @Nullable String forge) {
		return BidirectionalCommonTag.conventional(Registry.ITEM_REGISTRY, common, fabric, forge);
	}

	public static BidirectionalCommonTag<Item> itemShared(String path) {
		return itemShared(path, path, path);
	}
}
