package com.flareheat.mineventure.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flareheat.mineventure.Mineventure;
import com.flareheat.mineventure.util.StackHelper;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingHandler {
	private final Logger logger = LogManager.getLogger("Mineventure/CraftingHandler");

	public void load() {
		addToolBlueprint("copper", "copper_ingot");
		addToolBlueprint("ruby", "ruby");
		addToolBlueprint("sapphire", "sapphire");
		addToolBlueprint("topaze", "topaze_gem");
		addToolBlueprint("amethyst", "amethyst_fragment");
		addArmorBlueprint("copper", "copper_ingot");
		addArmorBlueprint("ruby", "ruby");
		addArmorBlueprint("sapphire", "sapphire");
		addArmorBlueprint("onyx", "onyx_ingot");
		addArmorBlueprint("mythril", "mythril_fragment");
		addContainerBlueprint("copper", "copper_ingot");
		addContainerBlueprint("ruby", "ruby");
		addContainerBlueprint("sapphire", "sapphire");
		addContainerBlueprint("onyx", "onyx_ingot");
		addContainerBlueprint("topaze", "topaze_gem");
		addContainerBlueprint("mythril", "mythril_fragment");
		addContainerBlueprint("amethyst", "amethyst_fragment");
		addBlueprint(StackHelper.get("golem_head", 1), new Object[]{" X ", "XCX", " X ", 'X', Blocks.pumpkin, 'C', Blocks.chest});
		addSmeltingBlueprint(StackHelper.get("copper_ingot", 1), StackHelper.get("copper_ore", 1), 1.0f);
		addSmeltingBlueprint(StackHelper.get("onyx_ingot", 1), StackHelper.get("onyx_ore", 1), 1.5f);
		addSmeltingBlueprint(StackHelper.get("cooked_mutton", 1), StackHelper.get("raw_mutton", 1), 2.0f);
		addSmeltingBlueprint(StackHelper.get("cooked_horse", 1), StackHelper.get("raw_horse", 1), 2.0f);
		addSmeltingBlueprint(StackHelper.get("cooked_squid", 1), StackHelper.get("raw_squid", 1), 2.5f);
		addSmeltingBlueprint(StackHelper.get("purified_flesh", 1), new ItemStack(Items.rotten_flesh), 2.0f);
	}

	public void addBlueprint(ItemStack result, Object[] recipe) {
		GameRegistry.addRecipe(result, recipe);
	}

	public void addSmeltingBlueprint(ItemStack result, ItemStack material, float xp) {
		GameRegistry.addSmelting(material, result, xp);
	}

	public void addToolBlueprint(String name, String item) {
		final ItemStack pickaxe = new ItemStack(Mineventure.getToolHandler().get(name.concat("_pickaxe")));
		final ItemStack axe = new ItemStack(Mineventure.getToolHandler().get(name.concat("_axe")));
		final ItemStack shovel = new ItemStack(Mineventure.getToolHandler().get(name.concat("_shovel")));
		final ItemStack hoe = new ItemStack(Mineventure.getToolHandler().get(name.concat("_hoe")));
		final ItemStack sword = new ItemStack(Mineventure.getToolHandler().get(name.concat("_sword")));
		final Item material = Mineventure.getItemHandler().get(item);
		GameRegistry.addRecipe(axe, new Object[]{"XX", "XS", " S", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(axe, new Object[]{"XX", "SX", "S ", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(shovel, new Object[]{"X", "S", "S", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(hoe, new Object[]{"XX", " S", " S", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(hoe, new Object[]{"XX", "S ", "S ", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(pickaxe, new Object[]{"XXX", " S ", " S ", 'X', material, 'S', Items.stick});
		GameRegistry.addRecipe(sword, new Object[]{"X", "X", "S", 'X', material, 'S', Items.stick});
	}

	public void addArmorBlueprint(String name, String item) {
		final ItemStack helmet = new ItemStack(Mineventure.getArmorHandler().get(name.concat("_helmet")));
		final ItemStack chestplate = new ItemStack(Mineventure.getArmorHandler().get(name.concat("_chestplate")));
		final ItemStack leggings = new ItemStack(Mineventure.getArmorHandler().get(name.concat("_leggings")));
		final ItemStack boots = new ItemStack(Mineventure.getArmorHandler().get(name.concat("_boots")));
		final Item material = Mineventure.getItemHandler().get(item);
		GameRegistry.addRecipe(helmet, new Object[]{"XXX", "X X", 'X', material});
		GameRegistry.addRecipe(chestplate, new Object[]{"X X", "XXX", "XXX", 'X', material});
		GameRegistry.addRecipe(leggings, new Object[]{"XXX", "X X", "X X", 'X', material});
		GameRegistry.addRecipe(boots, new Object[]{"X X", "X X", 'X', material});
	}

	public void addContainerBlueprint(String name, String item) {
		final ItemStack block = new ItemStack(Mineventure.getBlockHandler().get(name.concat("_block")));
		final Item material = Mineventure.getItemHandler().get(item);
		GameRegistry.addShapedRecipe(block, new Object[]{"XXX", "XXX", "XXX", 'X', material});
		GameRegistry.addShapelessRecipe(new ItemStack(material, 9), new Object[]{block.getItem()});
	}

	public Logger getLogger() {
		return logger;
	}
}
