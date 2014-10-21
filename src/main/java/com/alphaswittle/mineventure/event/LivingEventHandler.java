package com.alphaswittle.mineventure.event;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import com.alphaswittle.mineventure.entity.EntityGolem;
import com.alphaswittle.mineventure.entity.monster.EntityDiamondGolem;
import com.alphaswittle.mineventure.entity.monster.EntityEmeraldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityGoldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityLapisGolem;
import com.alphaswittle.mineventure.entity.monster.EntityRedstoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityStoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityWoodGolem;
import com.alphaswittle.mineventure.util.StackHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingEventHandler {

	@SubscribeEvent
	public void onDrop(LivingDropsEvent event) {
		final EntityLivingBase entity = event.entityLiving;
		final Random random = entity.worldObj.rand;
		final int rQuantity = 1 + random.nextInt(2);
		if (entity instanceof EntitySheep) {
			if (event.source.isFireDamage()) {
				final ItemStack stack = StackHelper.get("cooked_mutton", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			} else {
				final ItemStack stack = StackHelper.get("raw_mutton", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			}
		} else if (entity instanceof EntityHorse) {
			if (event.source.isFireDamage()) {
				final ItemStack stack = StackHelper.get("cooked_horse", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			} else {
				final ItemStack stack = StackHelper.get("raw_horse", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			}
		} else if (entity instanceof EntitySquid) {
			if (event.source.isFireDamage()) {
				final ItemStack stack = StackHelper.get("cooked_squid", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			} else {
				final ItemStack stack = StackHelper.get("raw_squid", rQuantity);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.add(entityItem);
			}
		} else if (entity instanceof EntityZombie) {
			if (event.source.isFireDamage()) {
				final ItemStack stack = StackHelper.get("purified_flesh", 1);
				final EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
				event.drops.clear();
				event.drops.add(entityItem);
			} else {
				return;
			}
		}
	}

	@SubscribeEvent
	public void onSpawn(LivingSpawnEvent event) {
		final EntityLivingBase entityLivingBase = event.entityLiving;
		final int rGolem = entityLivingBase.worldObj.rand.nextInt(7);
		if (entityLivingBase instanceof EntityIronGolem) {
			final EntityIronGolem ironGolem = (EntityIronGolem) entityLivingBase;
			if (ironGolem.isPlayerCreated()) {
				return;
			} else {
				EntityGolem golem = null;
				switch (rGolem) {
					case 0 :
						golem = new EntityWoodGolem(ironGolem.worldObj);
						break;
					case 1 :
						golem = new EntityStoneGolem(ironGolem.worldObj);
						break;
					case 2 :
						golem = new EntityGoldGolem(ironGolem.worldObj);
						break;
					case 3 :
						golem = new EntityDiamondGolem(ironGolem.worldObj);
						break;
					case 4 :
						golem = new EntityEmeraldGolem(ironGolem.worldObj);
						break;
					case 5 :
						golem = new EntityLapisGolem(ironGolem.worldObj);
						break;
					case 6 :
						golem = new EntityRedstoneGolem(ironGolem.worldObj);
						break;
				}
				golem.setPosition(ironGolem.posX + 5, ironGolem.posY, ironGolem.posZ + 5);
				ironGolem.worldObj.spawnEntityInWorld(golem);
			}
		}
	}
}
