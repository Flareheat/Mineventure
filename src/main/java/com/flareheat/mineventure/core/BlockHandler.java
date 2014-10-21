package com.flareheat.mineventure.core;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flareheat.mineventure.Mineventure;
import com.flareheat.mineventure.block.BlockContainer;
import com.flareheat.mineventure.block.BlockDroppableOre;
import com.flareheat.mineventure.block.BlockHead;
import com.flareheat.mineventure.block.BlockOre;
import com.flareheat.mineventure.localization.Localization;
import com.flareheat.mineventure.localization.node.SimpleNode;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHandler {
	private final String modid = "mineventure";
	private final Logger logger = LogManager.getLogger("Mineventure/BlockHandler");

	private final HashMap<String, Block> blockMap = new HashMap<String, Block>();

	private Block copper_ore;
	private Block ruby_ore;
	private Block sapphire_ore;
	private Block onyx_ore;
	private Block topaze_ore;
	private Block mythril_ore;
	private Block amethyst_ore;
	private Block copper_block;
	private Block ruby_block;
	private Block sapphire_block;
	private Block onyx_block;
	private Block topaze_block;
	private Block mythril_block;
	private Block amethyst_block;
	private Block golem_head;

	public void load() {
		copper_ore = new BlockOre(modid, "copper_ore", CreativeTabs.tabBlock, 5f, 10f, 1);
		ruby_ore = new BlockDroppableOre(modid, "ruby_ore", CreativeTabs.tabBlock, 5f, 10f, 2, Mineventure.getItemHandler().get("ruby"), 4);
		sapphire_ore = new BlockDroppableOre(modid, "sapphire_ore", CreativeTabs.tabBlock, 5f, 10f, 2, Mineventure.getItemHandler().get("sapphire"), 3);
		onyx_ore = new BlockOre(modid, "onyx_ore", CreativeTabs.tabBlock, 6f, 10f, 1);
		topaze_ore = new BlockDroppableOre(modid, "topaze_ore", CreativeTabs.tabBlock, 6f, 10f, 2, Mineventure.getItemHandler().get("topaze_gem"), 3);
		mythril_ore = new BlockDroppableOre(modid, "mythril_ore", CreativeTabs.tabBlock, 7f, 10f, 3, Mineventure.getItemHandler().get("mythril_fragment"), 2);
		amethyst_ore = new BlockDroppableOre(modid, "amethyst_ore", CreativeTabs.tabBlock, 7f, 10f, 3, Mineventure.getItemHandler().get("amethyst_fragment"), 2);
		copper_block = new BlockContainer(modid, "copper_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 0);
		ruby_block = new BlockContainer(modid, "ruby_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 1);
		sapphire_block = new BlockContainer(modid, "sapphire_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 1);
		onyx_block = new BlockContainer(modid, "onyx_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 0);
		topaze_block = new BlockContainer(modid, "topaze_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 2);
		mythril_block = new BlockContainer(modid, "mythril_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 2);
		amethyst_block = new BlockContainer(modid, "amethyst_block", Material.iron, Block.soundTypeMetal, CreativeTabs.tabBlock, 10f, 10f, "pickaxe", 3);
		golem_head = new BlockHead(modid, "golem_head", Material.gourd, Block.soundTypeSnow, CreativeTabs.tabBlock, 2f, 2f);
		set("copper_ore", copper_ore);
		set("ruby_ore", ruby_ore);
		set("sapphire_ore", sapphire_ore);
		set("onyx_ore", onyx_ore);
		set("topaze_ore", topaze_ore);
		set("mythril_ore", mythril_ore);
		set("amethyst_ore", amethyst_ore);
		set("copper_block", copper_block);
		set("ruby_block", ruby_block);
		set("sapphire_block", sapphire_block);
		set("onyx_block", onyx_block);
		set("topaze_block", topaze_block);
		set("mythril_block", mythril_block);
		set("amethyst_block", amethyst_block);
		set("golem_head", golem_head);
	}

	private void set(String name, Block block) {
		blockMap.put(name, block);
		GameRegistry.registerBlock(block, name);
		Localization.addSimpleNode("en_US", new SimpleNode("tile", name, true));
	}

	public Block get(String name) {
		return blockMap.get(name);
	}

	public Logger getLogger() {
		return logger;
	}
}
