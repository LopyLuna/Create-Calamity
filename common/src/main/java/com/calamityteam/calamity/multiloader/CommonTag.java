package com.calamityteam.calamity.multiloader;

import java.util.function.Consumer;

import com.calamityteam.calamity.Calamity;

import com.calamityteam.calamity.base.data.CLTagGen;

import net.minecraft.core.Registry;
import net.minecraft.data.tags.TagsProvider.TagAppender;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import com.tterrag.registrate.providers.RegistrateTagsProvider;

import org.jetbrains.annotations.Nullable;

/**
 * A common tag is a trio of tags: one for common, one for fabric, and one for forge.
 * The common tag contains both loader tags and should only be used for querying.
 * Content is added to both loader tags separately.
 */
public class CommonTag<T> {
	public final TagKey<T> tag;
	@Nullable
	public final TagKey<T> fabric, forge;

	public CommonTag(TagKey<T> common, @Nullable TagKey<T> fabric, @Nullable TagKey<T> forge) {
		this.tag = common;
		this.fabric = fabric;
		this.forge = forge;
	}

	public CommonTag(ResourceKey<? extends Registry<T>> registry, ResourceLocation common, @Nullable ResourceLocation fabric, @Nullable ResourceLocation forge) {
		this(TagKey.create(registry, common), fabric == null ? null : TagKey.create(registry, fabric),
			forge == null ? null : TagKey.create(registry, forge));
	}

	public static <T> CommonTag<T> conventional(ResourceKey<? extends Registry<T>> registry, String common, @Nullable String fabric, @Nullable String forge) {
		return new CommonTag<>(
			registry,
			Calamity.asResource("internal/" + common),
			fabric == null ? null : new ResourceLocation("c", fabric),
			forge == null ? null : new ResourceLocation("forge", forge)
		);
	}

	public static <T> CommonTag<T> conventional(ResourceKey<? extends Registry<T>> registry, String path) {
		return conventional(registry, path, path, path);
	}

	public CommonTag<T> generateBoth(RegistrateTagsProvider<T> tags, Consumer<TagAppender<T>> consumer) {
		if (fabric != null) consumer.accept(CLTagGen.tagAppender(tags, fabric));
		if (forge != null ) consumer.accept(CLTagGen.tagAppender(tags, forge));
		return this;
	}

	public CommonTag<T> generateCommon(RegistrateTagsProvider<T> tags) {
		TagAppender<T> appender = CLTagGen.tagAppender(tags, tag);
		if (fabric != null) appender.addOptionalTag(fabric.location());
		if (forge != null) appender.addOptionalTag(forge.location());
		return this;
	}
}
