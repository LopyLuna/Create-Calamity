package com.calamityteam.calamity.base.model;

import com.calamityteam.calamity.registry.CLPartialModels;

import com.mojang.blaze3d.vertex.PoseStack;

import io.github.fabricators_of_create.porting_lib.render.TransformTypeDependentItemBakedModel;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.resources.model.BakedModel;

public class CatEarsModel extends ForwardingBakedModel implements TransformTypeDependentItemBakedModel {

	public CatEarsModel(BakedModel template) {
		wrapped = template;
	}

	@Override
	public BakedModel applyTransform(ItemTransforms.TransformType cameraTransformType, PoseStack mat, boolean leftHanded) {
		if (cameraTransformType == ItemTransforms.TransformType.HEAD) {
			return TransformTypeDependentItemBakedModel.maybeApplyTransform(
				CLPartialModels.CAT_EARS.get(), cameraTransformType, mat, leftHanded
			);
		}
		return TransformTypeDependentItemBakedModel.super.applyTransform(cameraTransformType, mat, leftHanded);
	}

}
