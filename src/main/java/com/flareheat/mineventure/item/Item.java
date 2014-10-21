package com.flareheat.mineventure.item;

import net.minecraft.creativetab.CreativeTabs;

public class Item extends net.minecraft.item.Item {
	public Item(String modid, String name, CreativeTabs tab) {
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
