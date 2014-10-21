package com.alphaswittle.mineventure.core;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphaswittle.mineventure.item.Item;
import com.alphaswittle.mineventure.localization.Localization;
import com.alphaswittle.mineventure.localization.node.SimpleNode;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHandler {
	private final String modid = "mineventure";
	private final Logger logger = LogManager.getLogger("Mineventure/ItemHandler");

	private final HashMap<String, Item> itemMap = new HashMap<String, Item>();

	private Item copper_ingot;
	private Item ruby;
	private Item sapphire;
	private Item onyx_ingot;
	private Item topaze_gem;
	private Item mythril_fragment;
	private Item amethyst_fragment;

	public void load() {
		copper_ingot = new Item(modid, "copper_ingot", CreativeTabs.tabMaterials);
		ruby = new Item(modid, "ruby", CreativeTabs.tabMaterials);
		sapphire = new Item(modid, "sapphire", CreativeTabs.tabMaterials);
		onyx_ingot = new Item(modid, "onyx_ingot", CreativeTabs.tabMaterials);
		topaze_gem = new Item(modid, "topaze_gem", CreativeTabs.tabMaterials);
		mythril_fragment = new Item(modid, "mythril_fragment", CreativeTabs.tabMaterials);
		amethyst_fragment = new Item(modid, "amethyst_fragment", CreativeTabs.tabMaterials);
		set("copper_ingot", copper_ingot);
		set("ruby", ruby);
		set("sapphire", sapphire);
		set("onyx_ingot", onyx_ingot);
		set("topaze_gem", topaze_gem);
		set("mythril_fragment", mythril_fragment);
		set("amethyst_fragment", amethyst_fragment);
	}

	private void set(String name, Item item) {
		itemMap.put(name, item);
		GameRegistry.registerItem(item, name);
		Localization.addSimpleNode("en_US", new SimpleNode("item", name, true));
	}

	public Item get(String name) {
		return itemMap.get(name);
	}

	public Logger getLogger() {
		return logger;
	}
}
