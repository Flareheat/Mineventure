package com.alphaswittle.mineventure.core;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphaswittle.mineventure.item.food.ItemFood;
import com.alphaswittle.mineventure.localization.Localization;
import com.alphaswittle.mineventure.localization.node.SimpleNode;

import cpw.mods.fml.common.registry.GameRegistry;

public class FoodHandler {
	private final String modid = "mineventure";
	private final Logger logger = LogManager.getLogger("Mineventure/FoodHandler");

	private final HashMap<String, ItemFood> itemMap = new HashMap<String, ItemFood>();

	private ItemFood raw_mutton;
	private ItemFood cooked_mutton;
	private ItemFood raw_horse;
	private ItemFood cooked_horse;
	private ItemFood raw_squid;
	private ItemFood cooked_squid;
	private ItemFood purified_flesh;

	public void load() {
		raw_mutton = new ItemFood(modid, "raw_mutton", CreativeTabs.tabFood, 5, 5, true);
		cooked_mutton = new ItemFood(modid, "cooked_mutton", CreativeTabs.tabFood, 8, 10, true);
		raw_horse = new ItemFood(modid, "raw_horse", CreativeTabs.tabFood, 4, 4, true);
		cooked_horse = new ItemFood(modid, "cooked_horse", CreativeTabs.tabFood, 8, 15, true);
		raw_squid = new ItemFood(modid, "raw_squid", CreativeTabs.tabFood, 3, 3, false);
		cooked_squid = new ItemFood(modid, "cooked_squid", CreativeTabs.tabFood, 7, 10, false);
		purified_flesh = new ItemFood(modid, "purified_flesh", CreativeTabs.tabFood, 6, 5, true);
		set("raw_mutton", raw_mutton);
		set("cooked_mutton", cooked_mutton);
		set("raw_horse", raw_horse);
		set("cooked_horse", cooked_horse);
		set("raw_squid", raw_squid);
		set("cooked_squid", cooked_squid);
		set("purified_flesh", purified_flesh);
	}

	private void set(String name, ItemFood itemFood) {
		itemMap.put(name, itemFood);
		GameRegistry.registerItem(itemFood, name);
		Localization.addSimpleNode("en_US", new SimpleNode("item", name, true));
	}

	public ItemFood get(String name) {
		return itemMap.get(name);
	}

	public Logger getLogger() {
		return logger;
	}
}
