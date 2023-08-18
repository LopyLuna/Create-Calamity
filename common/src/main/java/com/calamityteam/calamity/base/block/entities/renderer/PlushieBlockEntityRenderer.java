package com.calamityteam.calamity.base.block.entities.renderer;

import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class PlushieBlockEntityRenderer implements BlockEntityRenderer<PlushieBlockEntity> {
	public PlushieBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
		System.out.println("EEE");
	}
	@Override
	public void render(PlushieBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

	}
}
