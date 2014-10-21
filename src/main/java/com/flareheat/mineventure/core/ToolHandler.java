package com.flareheat.mineventure.core;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flareheat.mineventure.item.tool.ItemAxe;
import com.flareheat.mineventure.item.tool.ItemHoe;
import com.flareheat.mineventure.item.tool.ItemPickaxe;
import com.flareheat.mineventure.item.tool.ItemSpade;
import com.flareheat.mineventure.item.tool.ItemSword;
import com.flareheat.mineventure.localization.Localization;
import com.flareheat.mineventure.localization.node.SimpleNode;

import cpw.mods.fml.common.registry.GameRegistry;

public class ToolHandler {
	private final String modid = "mineventure";
	private final Logger logger = LogManager.getLogger("Mineventure/ToolHandler");

	private final HashMap<String, Item> toolMap = new HashMap<String, Item>();

	private final ToolMaterial copper = EnumHelper.addToolMaterial("copper", 1, 240, 4.5f, 1.5f, 14);
	private final ToolMaterial ruby = EnumHelper.addToolMaterial("ruby", 2, 345, 5.5f, 2.0f, 20);
	private final ToolMaterial sapphire = EnumHelper.addToolMaterial("sapphire", 2, 450, 6.5f, 2.5f, 14);
	private final ToolMaterial topaze = EnumHelper.addToolMaterial("topaze", 3, 64, 14.0f, 0.5f, 38);
	private final ToolMaterial amethyst = EnumHelper.addToolMaterial("amethyst", 3, 1024, 12.0f, 3.5f, 20);

	private ItemAxe copper_axe, ruby_axe, sapphire_axe, topaze_axe, amethyst_axe;
	private ItemPickaxe copper_pickaxe, ruby_pickaxe, sapphire_pickaxe, topaze_pickaxe, amethyst_pickaxe;
	private ItemSpade copper_shovel, ruby_shovel, sapphire_shovel, topaze_shovel, amethyst_shovel;
	private ItemHoe copper_hoe, ruby_hoe, sapphire_hoe, topaze_hoe, amethyst_hoe;
	private ItemSword copper_sword, ruby_sword, sapphire_sword, topaze_sword, amethyst_sword;

	public void load() {
		copper_axe = new ItemAxe(modid, "copper_axe", CreativeTabs.tabTools, copper);
		copper_pickaxe = new ItemPickaxe(modid, "copper_pickaxe", CreativeTabs.tabTools, copper);
		copper_shovel = new ItemSpade(modid, "copper_shovel", CreativeTabs.tabTools, copper);
		copper_hoe = new ItemHoe(modid, "copper_hoe", CreativeTabs.tabTools, copper);
		copper_sword = new ItemSword(modid, "copper_sword", CreativeTabs.tabCombat, copper);
		ruby_axe = new ItemAxe(modid, "ruby_axe", CreativeTabs.tabTools, ruby);
		ruby_pickaxe = new ItemPickaxe(modid, "ruby_pickaxe", CreativeTabs.tabTools, ruby);
		ruby_shovel = new ItemSpade(modid, "ruby_shovel", CreativeTabs.tabTools, ruby);
		ruby_hoe = new ItemHoe(modid, "ruby_hoe", CreativeTabs.tabTools, ruby);
		ruby_sword = new ItemSword(modid, "ruby_sword", CreativeTabs.tabCombat, ruby);
		sapphire_axe = new ItemAxe(modid, "sapphire_axe", CreativeTabs.tabTools, sapphire);
		sapphire_pickaxe = new ItemPickaxe(modid, "sapphire_pickaxe", CreativeTabs.tabTools, sapphire);
		sapphire_shovel = new ItemSpade(modid, "sapphire_shovel", CreativeTabs.tabTools, sapphire);
		sapphire_hoe = new ItemHoe(modid, "sapphire_hoe", CreativeTabs.tabTools, sapphire);
		sapphire_sword = new ItemSword(modid, "sapphire_sword", CreativeTabs.tabCombat, sapphire);
		topaze_axe = new ItemAxe(modid, "topaze_axe", CreativeTabs.tabTools, topaze);
		topaze_pickaxe = new ItemPickaxe(modid, "topaze_pickaxe", CreativeTabs.tabTools, topaze);
		topaze_shovel = new ItemSpade(modid, "topaze_shovel", CreativeTabs.tabTools, topaze);
		topaze_hoe = new ItemHoe(modid, "topaze_hoe", CreativeTabs.tabTools, topaze);
		topaze_sword = new ItemSword(modid, "topaze_sword", CreativeTabs.tabCombat, topaze);
		amethyst_axe = new ItemAxe(modid, "amethyst_axe", CreativeTabs.tabTools, amethyst);
		amethyst_pickaxe = new ItemPickaxe(modid, "amethyst_pickaxe", CreativeTabs.tabTools, amethyst);
		amethyst_shovel = new ItemSpade(modid, "amethyst_shovel", CreativeTabs.tabTools, amethyst);
		amethyst_hoe = new ItemHoe(modid, "amethyst_hoe", CreativeTabs.tabTools, amethyst);
		amethyst_sword = new ItemSword(modid, "amethyst_sword", CreativeTabs.tabCombat, amethyst);
		set("copper_shovel", copper_shovel);
		set("copper_pickaxe", copper_pickaxe);
		set("copper_axe", copper_axe);
		set("copper_hoe", copper_hoe);
		set("copper_sword", copper_sword);
		set("ruby_shovel", ruby_shovel);
		set("ruby_pickaxe", ruby_pickaxe);
		set("ruby_axe", ruby_axe);
		set("ruby_hoe", ruby_hoe);
		set("ruby_sword", ruby_sword);
		set("sapphire_shovel", sapphire_shovel);
		set("sapphire_pickaxe", sapphire_pickaxe);
		set("sapphire_axe", sapphire_axe);
		set("sapphire_hoe", sapphire_hoe);
		set("sapphire_sword", sapphire_sword);
		set("topaze_shovel", topaze_shovel);
		set("topaze_pickaxe", topaze_pickaxe);
		set("topaze_axe", topaze_axe);
		set("topaze_hoe", topaze_hoe);
		set("topaze_sword", topaze_sword);
		set("amethyst_shovel", amethyst_shovel);
		set("amethyst_pickaxe", amethyst_pickaxe);
		set("amethyst_axe", amethyst_axe);
		set("amethyst_hoe", amethyst_hoe);
		set("amethyst_sword", amethyst_sword);
	}

	private void set(String name, Item item) {
		toolMap.put(name, item);
		GameRegistry.registerItem(item, name);
		Localization.addSimpleNode("en_US", new SimpleNode("item", name, true));
	}

	public Item get(String name) {
		return toolMap.get(name);
	}

	public Logger getLogger() {
		return logger;
	}
}
