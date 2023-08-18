package com.calamityteam.calamity.base.item;

import com.calamityteam.calamity.registry.CLPlushies;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;


import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlushieItem extends BlockItem {
	List<Component> toolTip;
	public PlushieItem(Block block, Properties properties, CLPlushies.PlushieEntry entry) {
		super(block, properties);

		this.toolTip = entry.tooltip();
	}


	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
		if (this.toolTip!=null && !this.toolTip.isEmpty()) {
			for (Component tip:this.toolTip) {
				tooltipComponents.add(tip);
			}

		}

		super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
	}
}
