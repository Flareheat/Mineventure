package com.alphaswittle.mineventure.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBow extends Item {

	public ItemBow(String modid, String name, CreativeTabs tab, int maxDamage) {
		super(modid, name, tab);
		maxStackSize = 1;
		setMaxDamage(maxDamage);
	}

	public static final String[] bowPullIconNameArray = new String[]{"pulling_0", "pulling_1", "pulling_2"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int time) {
		int j = getMaxItemUseDuration(stack) - time;
		final ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;
		final boolean flag = player.capabilities.isCreativeMode || (EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0);
		if (flag || player.inventory.hasItem(Items.arrow)) {
			float f = j / 20.0F;
			f = ((f * f) + (f * 2.0F)) / 3.0F;
			if (f < 0.1D) {
				return;
			}
			if (f > 1.0F) {
				f = 1.0F;
			}
			final EntityArrow entityarrow = new EntityArrow(world, player, f * 2.0F);
			if (f == 1.0F) {
				entityarrow.setIsCritical(true);
			}
			final int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
			if (k > 0) {
				entityarrow.setDamage(entityarrow.getDamage() + (k * 0.5D) + 0.5D);
			}
			final int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
			if (l > 0) {
				entityarrow.setKnockbackStrength(l);
			}
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0) {
				entityarrow.setFire(100);
			}
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 1.0F, (1.0F / ((itemRand.nextFloat() * 0.4F) + 1.2F)) + (f * 0.5F));
			if (flag) {
				entityarrow.canBePickedUp = 2;
			} else {
				player.inventory.consumeInventoryItem(Items.arrow);
			}
			if (!world.isRemote) {
				world.spawnEntityInWorld(entityarrow);
			}
		}
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.bow;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		final ArrowNockEvent event = new ArrowNockEvent(player, stack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(Items.arrow)) {
			player.setItemInUse(stack, getMaxItemUseDuration(stack));
		}
		return stack;
	}

	@Override
	public int getItemEnchantability() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(getIconString() + "_standby");
		iconArray = new IIcon[bowPullIconNameArray.length];
		for (int i = 0; i < iconArray.length; ++i) {
			iconArray[i] = iconRegister.registerIcon(getIconString() + "_" + bowPullIconNameArray[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int stage) {
		return iconArray[stage];
	}
}
