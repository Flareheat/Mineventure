package com.flareheat.mineventure.item.tool;

import net.minecraft.creativetab.CreativeTabs;

public class ItemHoe extends net.minecraft.item.ItemHoe {
	public ItemHoe(String modid, String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
