package com.alphaswittle.mineventure.item.tool;

import net.minecraft.creativetab.CreativeTabs;

public class ItemSpade extends net.minecraft.item.ItemSpade {
	public ItemSpade(String modid, String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
