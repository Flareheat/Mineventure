package com.alphaswittle.mineventure.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockContainer extends Block {
	public BlockContainer(String modid, String name, Material material, SoundType soundType, CreativeTabs tab, float hardness, float resistance, String tool, int level) {
		super(modid, name, material, soundType, tab, hardness, resistance);
		this.setHarvestLevel(tool, level);
	}
}
