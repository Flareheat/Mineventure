package com.flareheat.mineventure.item.food;

import net.minecraft.creativetab.CreativeTabs;

public class ItemFood extends net.minecraft.item.ItemFood {
	public ItemFood(String modid, String name, CreativeTabs tab, int meat, float saturation, boolean forDogs) {
		super(meat, saturation, forDogs);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
	}
}
