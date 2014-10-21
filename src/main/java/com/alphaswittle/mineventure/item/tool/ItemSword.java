package com.alphaswittle.mineventure.item.tool;

import net.minecraft.creativetab.CreativeTabs;

public class ItemSword extends net.minecraft.item.ItemSword {
	public ItemSword(String modid, String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
