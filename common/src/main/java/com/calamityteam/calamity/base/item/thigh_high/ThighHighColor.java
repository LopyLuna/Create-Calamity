package com.calamityteam.calamity.base.item.thigh_high;

import com.simibubi.create.foundation.utility.AnimationTickHolder;
import com.simibubi.create.foundation.utility.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

public class ThighHighColor implements ItemColor {
	private static int colorInPhase(int phase, int progress) {
		phase = phase % 6;
		if (phase <= 1)
			return 0;
		if (phase == 2)
			return progress;
		if (phase <= 4)
			return 255;
		else
			return 255 - progress;
	}
	@Override
	public int getColor(ItemStack itemStack, int i) {
		int timeStep = AnimationTickHolder.getTicks()  * 100;
		Minecraft mc = Minecraft.getInstance();
		float pt = AnimationTickHolder.getPartialTicks();
		float progress = (float) ((mc.player.getViewYRot(pt)) / 180 * Math.PI) + (AnimationTickHolder.getRenderTime() / 10f);
		int localTimeStep = Math.abs(timeStep) % 1536;
		int timeStepInPhase = localTimeStep % 256;
		int phaseBlue = localTimeStep / 256;
		int red = colorInPhase(phaseBlue + 4, timeStepInPhase);
		int green = colorInPhase(phaseBlue + 2, timeStepInPhase);
		int blue = colorInPhase(phaseBlue, timeStepInPhase);
		if (i == 0)
			return Color.mixColors(0xffffff, 0xffffff, (Mth.sin(progress) + 1) / 2);
		if (i == 1) {
			if (ThighHighItem.getTHColor(itemStack) == 11574159) {
				return new Color(red, green, blue).getRGB();
			}
			return ThighHighItem.getTHColor(itemStack);
		}
		return 0;
	}
}
