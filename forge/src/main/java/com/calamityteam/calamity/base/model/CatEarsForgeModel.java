package com.calamityteam.calamity.base.model;

import com.calamityteam.calamity.registry.CLPartialModels;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;

import net.minecraftforge.client.model.BakedModelWrapper;

public class CatEarsForgeModel extends BakedModelWrapper<BakedModel> {
	public CatEarsForgeModel(BakedModel template) {
		super(template);
	}
	@Override
	public BakedModel applyTransform(ItemTransforms.TransformType cameraTransformType, PoseStack mat, boolean leftHanded) {
		if (cameraTransformType == ItemTransforms.TransformType.HEAD)
			return CLPartialModels.CAT_EARS.get()
				.applyTransform(cameraTransformType, mat, leftHanded);
		return super.applyTransform(cameraTransformType, mat, leftHanded);
	}
}
