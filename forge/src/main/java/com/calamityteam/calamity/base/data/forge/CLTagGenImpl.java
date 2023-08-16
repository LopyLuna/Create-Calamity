package com.calamityteam.calamity.base.data.forge;

import com.tterrag.registrate.providers.RegistrateTagsProvider;

import net.minecraft.data.tags.TagsProvider;
import net.minecraft.data.tags.TagsProvider.TagAppender;
import net.minecraft.tags.TagKey;

public class CLTagGenImpl {
	public static <T> TagAppender<T> tagAppender(RegistrateTagsProvider<T> prov, TagKey<T> tag) {
		return prov.tag(tag);
	}
}
