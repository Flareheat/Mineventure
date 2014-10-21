package com.flareheat.mineventure.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.flareheat.mineventure.entity.monster.EntityDiamondGolem;
import com.flareheat.mineventure.entity.monster.EntityEmeraldGolem;
import com.flareheat.mineventure.entity.monster.EntityGoldGolem;
import com.flareheat.mineventure.entity.monster.EntityLapisGolem;
import com.flareheat.mineventure.entity.monster.EntityRedstoneGolem;
import com.flareheat.mineventure.entity.monster.EntityStoneGolem;
import com.flareheat.mineventure.entity.monster.EntityWoodGolem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHead extends BlockDirectional {
	@SideOnly(Side.CLIENT)
	private IIcon face;
	@SideOnly(Side.CLIENT)
	private IIcon face_;

	public BlockHead(String modid, String name, Material material, SoundType soundType, CreativeTabs tab, float hardness, float resistance) {
		super(modid, name, material, soundType, tab, hardness, resistance);
		setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int i_) {
		return i == 1 ? face : (i == 0 ? face : ((i_ == 2) && (i == 2) ? face_ : ((i_ == 3) && (i == 5) ? face_ : ((i_ == 0) && (i == 3) ? face_ : ((i_ == 1) && (i == 4) ? face_ : blockIcon)))));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		face = iconRegister.registerIcon(getTextureName() + "_top");
		face_ = iconRegister.registerIcon(getTextureName() + "_face");
		blockIcon = iconRegister.registerIcon(getTextureName() + "_side");
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y, z).isReplaceable(world, x, y, z) && World.doesBlockHaveSolidTopSurface(world, x, y - 1, z);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		final int l = MathHelper.floor_double(((entity.rotationYaw * 4.0F) / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if ((world.getBlock(x, y - 1, z) == Blocks.log) && (world.getBlock(x, y - 2, z) == Blocks.log)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.log) && (world.getBlock(x + 1, y - 1, z) == Blocks.log);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.log) && (world.getBlock(x, y - 1, z + 1) == Blocks.log);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityWoodGolem woodGolem = new EntityWoodGolem(world);
				woodGolem.setPlayerCreated(true);
				woodGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(woodGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.log2) && (world.getBlock(x, y - 2, z) == Blocks.log2)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.log2) && (world.getBlock(x + 1, y - 1, z) == Blocks.log2);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.log2) && (world.getBlock(x, y - 1, z + 1) == Blocks.log2);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityWoodGolem woodGolem = new EntityWoodGolem(world);
				woodGolem.setPlayerCreated(true);
				woodGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(woodGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.stone) && (world.getBlock(x, y - 2, z) == Blocks.stone)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.stone) && (world.getBlock(x + 1, y - 1, z) == Blocks.stone);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.stone) && (world.getBlock(x, y - 1, z + 1) == Blocks.stone);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityStoneGolem stoneGolem = new EntityStoneGolem(world);
				stoneGolem.setPlayerCreated(true);
				stoneGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(stoneGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.iron_block) && (world.getBlock(x, y - 2, z) == Blocks.iron_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.iron_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.iron_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.iron_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.iron_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityIronGolem entityirongolem = new EntityIronGolem(world);
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entityirongolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.gold_block) && (world.getBlock(x, y - 2, z) == Blocks.gold_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.gold_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.gold_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.gold_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.gold_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityGoldGolem goldGolem = new EntityGoldGolem(world);
				goldGolem.setPlayerCreated(true);
				goldGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(goldGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.emerald_block) && (world.getBlock(x, y - 2, z) == Blocks.emerald_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.emerald_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.emerald_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.emerald_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.emerald_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityEmeraldGolem emeraldGolem = new EntityEmeraldGolem(world);
				emeraldGolem.setPlayerCreated(true);
				emeraldGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(emeraldGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.diamond_block) && (world.getBlock(x, y - 2, z) == Blocks.diamond_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.diamond_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.diamond_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.diamond_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.diamond_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityDiamondGolem diamondGolem = new EntityDiamondGolem(world);
				diamondGolem.setPlayerCreated(true);
				diamondGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(diamondGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.redstone_block) && (world.getBlock(x, y - 2, z) == Blocks.redstone_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.redstone_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.redstone_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.redstone_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.redstone_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityRedstoneGolem redstoneGolem = new EntityRedstoneGolem(world);
				redstoneGolem.setPlayerCreated(true);
				redstoneGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(redstoneGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		} else if ((world.getBlock(x, y - 1, z) == Blocks.lapis_block) && (world.getBlock(x, y - 2, z) == Blocks.lapis_block)) {
			final boolean flag = (world.getBlock(x - 1, y - 1, z) == Blocks.lapis_block) && (world.getBlock(x + 1, y - 1, z) == Blocks.lapis_block);
			final boolean flag1 = (world.getBlock(x, y - 1, z - 1) == Blocks.lapis_block) && (world.getBlock(x, y - 1, z + 1) == Blocks.lapis_block);

			if (flag || flag1) {
				world.setBlock(x, y, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 1, z, getBlockById(0), 0, 2);
				world.setBlock(x, y - 2, z, getBlockById(0), 0, 2);

				if (flag) {
					world.setBlock(x - 1, y - 1, z, getBlockById(0), 0, 2);
					world.setBlock(x + 1, y - 1, z, getBlockById(0), 0, 2);
				} else {
					world.setBlock(x, y - 1, z - 1, getBlockById(0), 0, 2);
					world.setBlock(x, y - 1, z + 1, getBlockById(0), 0, 2);
				}

				final EntityLapisGolem lapisGolem = new EntityLapisGolem(world);
				lapisGolem.setPlayerCreated(true);
				lapisGolem.setLocationAndAngles(x + 0.5D, y - 1.95D, z + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(lapisGolem);

				for (int l = 0; l < 120; ++l) {
					world.spawnParticle("snowballpoof", x + world.rand.nextDouble(), (y - 2) + (world.rand.nextDouble() * 3.9D), z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(x, y, z, getBlockById(0));
				world.notifyBlockChange(x, y - 1, z, getBlockById(0));
				world.notifyBlockChange(x, y - 2, z, getBlockById(0));

				if (flag) {
					world.notifyBlockChange(x - 1, y - 1, z, getBlockById(0));
					world.notifyBlockChange(x + 1, y - 1, z, getBlockById(0));
				} else {
					world.notifyBlockChange(x, y - 1, z - 1, getBlockById(0));
					world.notifyBlockChange(x, y - 1, z + 1, getBlockById(0));
				}
			}
		}
	}
}
