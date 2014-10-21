package com.flareheat.mineventure.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flareheat.mineventure.Mineventure;

public class StackHelper {
	private static Logger logger = LogManager.getLogger("Mineventure/StackHelper");

	public static ItemStack get(String name, int quantity) {
		final Block block = Mineventure.getBlockHandler().get(name);
		final Item item = Mineventure.getItemHandler().get(name);
		final ItemFood itemFood = Mineventure.getFoodHandler().get(name);
		final ItemArmor itemArmor = Mineventure.getArmorHandler().get(name);
		final Item itemTool = Mineventure.getToolHandler().get(name);
		if (block != null) {
			return new ItemStack(block, quantity);
		} else if (item != null) {
			return new ItemStack(item, quantity);
		} else if (itemFood != null) {
			return new ItemStack(itemFood, quantity);
		} else if (itemArmor != null) {
			return new ItemStack(itemArmor, quantity);
		} else if (itemTool != null) {
			return new ItemStack(itemTool, quantity);
		} else {
			StackHelper.logger.warn("Returning null value for name: " + name);
			return null;
		}
	}
}
