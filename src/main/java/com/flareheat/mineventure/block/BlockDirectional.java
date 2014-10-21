package com.flareheat.mineventure.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDirectional extends net.minecraft.block.BlockDirectional {
	public BlockDirectional(String modid, String name, Material material, SoundType soundType, CreativeTabs tab, float hardness, float resistance) {
		super(material);
		setBlockName(name);
		setBlockTextureName(modid + ":" + name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
		setStepSound(soundType);
	}

	public static int getDirection(int face) {
		return face & 3;
	}
}
