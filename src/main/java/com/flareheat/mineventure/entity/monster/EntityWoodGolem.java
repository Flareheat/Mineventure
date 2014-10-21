package com.flareheat.mineventure.entity.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.flareheat.mineventure.entity.EntityGolem;

public class EntityWoodGolem extends EntityGolem {

	public EntityWoodGolem(World world) {
		super(world);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		final int j = rand.nextInt(3);
		int k;

		for (k = 0; k < j; ++k) {
			func_145778_a(Item.getItemFromBlock(Blocks.red_flower), 1, 0.0F);
		}

		k = 3 + rand.nextInt(3);

		for (int l = 0; l < k; ++l) {
			dropItem(Item.getItemFromBlock(Blocks.planks), 1);
		}
	}
}
