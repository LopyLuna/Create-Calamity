package com.calamityteam.calamity.base.block.entities.renderer;

import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class PlushieBlockEntityRenderer extends SafeBlockEntityRenderer<PlushieBlockEntity> {
	public PlushieBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
		System.out.println("YAAAAS");
	}

	@Override
	protected void renderSafe(PlushieBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource bufferSource, int light, int overlay) {

	}
}
