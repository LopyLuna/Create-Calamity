package com.calamityteam.calamity.base.block.Plushie;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;


import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

import java.util.List;

public class PlushieItem extends BlockItem {
	Component toolTip;
	public PlushieItem(Block block, Properties properties, Component toolTip) {
		super(block, properties);

		this.toolTip = toolTip;
	}


	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		if (this.toolTip!=null) {
			tooltipComponents.add(this.toolTip);
		}

		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
