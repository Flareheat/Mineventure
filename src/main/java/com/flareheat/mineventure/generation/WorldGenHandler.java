package com.flareheat.mineventure.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.ChestGenHooks;

import com.flareheat.mineventure.Mineventure;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenHandler implements IWorldGenerator {
	public void load() {
		GameRegistry.registerWorldGenerator(this, 0);
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(Mineventure.getItemHandler().get("copper_ingot")), 5, 10, 0));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1 :
				generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0 :
				generateWorld(world, random, chunkX * 16, chunkZ * 16);
			case 1 :
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateNether(World world, Random random, int x, int z) {
		final int rx = x + random.nextInt(16);
		final int ry = random.nextInt(256);
		final int rz = z + random.nextInt(16);
		for (int i = 0; i < 150; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("onyx_ore"), 0, 7, Blocks.netherrack)).generate(world, random, rx, ry, rz);
		}
		for (int i = 0; i < 150; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("topaze_ore"), 0, 5, Blocks.netherrack)).generate(world, random, rx, ry, rz);
		}
	}

	private void generateWorld(World world, Random random, int x, int z) {
		for (int i = 0; i < 20; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("copper_ore"), 0, 7, Blocks.stone)).generate(world, random, x + random.nextInt(16), random.nextInt(96), z + random.nextInt(16));
		}
		for (int i = 0; i < 10; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("ruby_ore"), 0, 5, Blocks.stone)).generate(world, random, x + random.nextInt(16), random.nextInt(48), z + random.nextInt(16));
		}
		for (int i = 0; i < 8; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("sapphire_ore"), 0, 3, Blocks.stone)).generate(world, random, x + random.nextInt(16), random.nextInt(24), z + random.nextInt(16));
		}
	}

	private void generateEnd(World world, Random random, int x, int z) {
		final int rx = x + random.nextInt(16);
		final int ry = random.nextInt(256);
		final int rz = z + random.nextInt(16);
		for (int i = 0; i < 150; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("mythril_ore"), 0, 7, Blocks.end_stone)).generate(world, random, rx, ry, rz);
		}
		for (int i = 0; i < 150; i++) {
			(new WorldGenMinable(Mineventure.getBlockHandler().get("amethyst_ore"), 0, 5, Blocks.end_stone)).generate(world, random, rx, ry, rz);
		}
	}
}
