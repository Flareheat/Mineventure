package com.alphaswittle.mineventure.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockOre extends Block {
	public BlockOre(String modid, String name, CreativeTabs tab, float hardness, float resistance, int harvestLevel) {
		super(modid, name, Material.rock, net.minecraft.block.Block.soundTypeStone, tab, hardness, resistance);
		this.setHarvestLevel("pickaxe", harvestLevel);
	}
}
