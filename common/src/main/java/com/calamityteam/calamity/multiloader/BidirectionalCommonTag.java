package com.calamityteam.calamity.multiloader;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.base.data.CLTagGen;
import com.tterrag.registrate.providers.RegistrateTagsProvider;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import org.jetbrains.annotations.Nullable;

public class BidirectionalCommonTag<T> extends CommonTag<T> {
	public final TagKey<T> commonWritable;
	public BidirectionalCommonTag(TagKey<T> common, TagKey<T> commonWritable, TagKey<T> fabric, TagKey<T> forge) {
		super(common, fabric, forge);
		this.commonWritable = commonWritable;
	}

	public BidirectionalCommonTag(ResourceKey<? extends Registry<T>> registry, ResourceLocation common, ResourceLocation commonWritable, @Nullable ResourceLocation fabric, @Nullable ResourceLocation forge) {
		this(TagKey.create(registry, common), TagKey.create(registry, commonWritable),
			fabric == null ? null : TagKey.create(registry, fabric), forge == null ? null : TagKey.create(registry, forge));
	}

	public static <T> BidirectionalCommonTag<T> conventional(ResourceKey<? extends Registry<T>> registry, String common, @Nullable String fabric, @Nullable String forge) {
		return new BidirectionalCommonTag<>(
			registry,
			Calamity.asResource("internal/" + common),
			Calamity.asResource("internal/" + common + "_writable"),
			fabric == null ? null : new ResourceLocation("c", fabric),
			forge == null ? null : new ResourceLocation("forge", forge)
		);
	}

	public BidirectionalCommonTag<T> generateShared(RegistrateTagsProvider<T> tags) {
		if (fabric != null)
			CLTagGen.tagAppender(tags, fabric)
				.addTag(commonWritable);
		if (forge != null)
			CLTagGen.tagAppender(tags, forge)
				.addTag(commonWritable);

		generateCommon(tags);

		return this;
	}
}
