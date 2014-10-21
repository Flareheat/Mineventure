package com.alphaswittle.mineventure.block;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockDroppableOre extends BlockOre {
	private final Item item;
	private final int quantity;

	public BlockDroppableOre(String modid, String name, CreativeTabs tab, float hardness, float resistance, int harvestLevel, Item item, int quantity) {
		super(modid, name, tab, hardness, resistance, harvestLevel);
		this.item = item;
		this.quantity = quantity;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return item;
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return random.nextInt(quantity) + 1;
	}
}
