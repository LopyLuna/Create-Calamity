package com.calamityteam.calamity.base.block.entities.renderer;

import com.calamityteam.calamity.base.block.PlushieBlock;
import com.calamityteam.calamity.base.block.entities.PlushieBlockEntity;

import com.calamityteam.calamity.registry.CLPlushies;

import com.mojang.blaze3d.vertex.PoseStack;

import com.simibubi.create.foundation.blockEntity.renderer.SafeBlockEntityRenderer;

import com.simibubi.create.foundation.render.CachedBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class PlushieBlockEntityRenderer extends SafeBlockEntityRenderer<PlushieBlockEntity> {
	public PlushieBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
		System.out.println("===");
	}

	float tick = 0;

	@Override
	protected void renderSafe(PlushieBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource bufferSource, int light, int overlay) {
		var model = be.getPartial();
		SuperByteBuffer buffer = CachedBufferer.partial(model, be.getBlockState());
		buffer.rotateCentered(Direction.UP,
            (float) -(((Math.PI * 2) / 16) * be.getBlockState().getValue(PlushieBlock.ROTATION))
        ).renderInto(ms, bufferSource.getBuffer(RenderType.cutout()));
	}
}
