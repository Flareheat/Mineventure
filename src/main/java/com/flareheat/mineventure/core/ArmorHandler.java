package com.flareheat.mineventure.core;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flareheat.mineventure.item.armor.ItemArmor;
import com.flareheat.mineventure.localization.Localization;
import com.flareheat.mineventure.localization.node.SimpleNode;

import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorHandler {
	private final String modid = "mineventure";
	private final Logger logger = LogManager.getLogger("Mineventure/ArmorHandler");

	private final HashMap<String, ItemArmor> armorMap = new HashMap<String, ItemArmor>();

	private final ArmorMaterial copper_armor = EnumHelper.addArmorMaterial("copper", 10, new int[]{3, 5, 4, 2}, 14);
	private final ArmorMaterial ruby_armor = EnumHelper.addArmorMaterial("ruby", 15, new int[]{3, 6, 5, 3}, 12);
	private final ArmorMaterial sapphire_armor = EnumHelper.addArmorMaterial("sapphire", 20, new int[]{4, 6, 5, 4}, 21);
	private final ArmorMaterial onyx_armor = EnumHelper.addArmorMaterial("onyx", 40, new int[]{4, 5, 4, 2}, 5);
	private final ArmorMaterial mythril_armor = EnumHelper.addArmorMaterial("mythril", 35, new int[]{5, 5, 5, 5}, 23);

	private Item copper_helmet, copper_chestplate, copper_leggings, copper_boots;
	private Item ruby_helmet, ruby_chestplate, ruby_leggings, ruby_boots;
	private Item sapphire_helmet, sapphire_chestplate, sapphire_leggings, sapphire_boots;
	private Item onyx_helmet, onyx_chestplate, onyx_leggings, onyx_boots;
	private Item mythril_helmet, mythril_chestplate, mythril_leggings, mythril_boots;

	public void load() {
		copper_helmet = new ItemArmor(modid, "copper_helmet", "copper", CreativeTabs.tabCombat, copper_armor, 0);
		copper_chestplate = new ItemArmor(modid, "copper_chestplate", "copper", CreativeTabs.tabCombat, copper_armor, 1);
		copper_leggings = new ItemArmor(modid, "copper_leggings", "copper", CreativeTabs.tabCombat, copper_armor, 2);
		copper_boots = new ItemArmor(modid, "copper_boots", "copper", CreativeTabs.tabCombat, copper_armor, 3);
		ruby_helmet = new ItemArmor(modid, "ruby_helmet", "ruby", CreativeTabs.tabCombat, ruby_armor, 0);
		ruby_chestplate = new ItemArmor(modid, "ruby_chestplate", "ruby", CreativeTabs.tabCombat, ruby_armor, 1);
		ruby_leggings = new ItemArmor(modid, "ruby_leggings", "ruby", CreativeTabs.tabCombat, ruby_armor, 2);
		ruby_boots = new ItemArmor(modid, "ruby_boots", "ruby", CreativeTabs.tabCombat, ruby_armor, 3);
		sapphire_helmet = new ItemArmor(modid, "sapphire_helmet", "sapphire", CreativeTabs.tabCombat, sapphire_armor, 0);
		sapphire_chestplate = new ItemArmor(modid, "sapphire_chestplate", "sapphire", CreativeTabs.tabCombat, sapphire_armor, 1);
		sapphire_leggings = new ItemArmor(modid, "sapphire_leggings", "sapphire", CreativeTabs.tabCombat, sapphire_armor, 2);
		sapphire_boots = new ItemArmor(modid, "sapphire_boots", "sapphire", CreativeTabs.tabCombat, sapphire_armor, 3);
		onyx_helmet = new ItemArmor(modid, "onyx_helmet", "onyx", CreativeTabs.tabCombat, onyx_armor, 0);
		onyx_chestplate = new ItemArmor(modid, "onyx_chestplate", "onyx", CreativeTabs.tabCombat, onyx_armor, 1);
		onyx_leggings = new ItemArmor(modid, "onyx_leggings", "onyx", CreativeTabs.tabCombat, onyx_armor, 2);
		onyx_boots = new ItemArmor(modid, "onyx_boots", "onyx", CreativeTabs.tabCombat, onyx_armor, 3);
		mythril_helmet = new ItemArmor(modid, "mythril_helmet", "mythril", CreativeTabs.tabCombat, mythril_armor, 0);
		mythril_chestplate = new ItemArmor(modid, "mythril_chestplate", "mythril", CreativeTabs.tabCombat, mythril_armor, 1);
		mythril_leggings = new ItemArmor(modid, "mythril_leggings", "mythril", CreativeTabs.tabCombat, mythril_armor, 2);
		mythril_boots = new ItemArmor(modid, "mythril_boots", "mythril", CreativeTabs.tabCombat, mythril_armor, 3);
		set("copper_helmet", copper_helmet);
		set("copper_chestplate", copper_chestplate);
		set("copper_leggings", copper_leggings);
		set("copper_boots", copper_boots);
		set("ruby_helmet", ruby_helmet);
		set("ruby_chestplate", ruby_chestplate);
		set("ruby_leggings", ruby_leggings);
		set("ruby_boots", ruby_boots);
		set("sapphire_helmet", sapphire_helmet);
		set("sapphire_chestplate", sapphire_chestplate);
		set("sapphire_leggings", sapphire_leggings);
		set("sapphire_boots", sapphire_boots);
		set("onyx_helmet", onyx_helmet);
		set("onyx_chestplate", onyx_chestplate);
		set("onyx_leggings", onyx_leggings);
		set("onyx_boots", onyx_boots);
		set("mythril_helmet", mythril_helmet);
		set("mythril_chestplate", mythril_chestplate);
		set("mythril_leggings", mythril_leggings);
		set("mythril_boots", mythril_boots);
	}

	private void set(String name, Item item) {
		armorMap.put(name, (ItemArmor) item);
		GameRegistry.registerItem(item, name);
		Localization.addSimpleNode("en_US", new SimpleNode("item", name, true));
	}

	public ItemArmor get(String name) {
		return armorMap.get(name);
	}

	public Logger getLogger() {
		return logger;
	}
}
