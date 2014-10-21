package com.alphaswittle.mineventure.item.tool;

import net.minecraft.creativetab.CreativeTabs;

public class ItemAxe extends net.minecraft.item.ItemAxe {
	public ItemAxe(String modid, String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
