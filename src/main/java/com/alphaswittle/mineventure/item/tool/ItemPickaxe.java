package com.alphaswittle.mineventure.item.tool;

import net.minecraft.creativetab.CreativeTabs;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {
	public ItemPickaxe(String modid, String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
