package com.flareheat.mineventure.item.armor;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.flareheat.mineventure.Mineventure;

public class ItemArmor extends net.minecraft.item.ItemArmor {
	private final String name;

	public ItemArmor(String modid, String name, String armorName, CreativeTabs tab, ArmorMaterial material, int type) {
		super(material, 0, type);
		setCreativeTab(tab);
		setTextureName(modid + ":" + name);
		setUnlocalizedName(name);
		this.name = armorName;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem().equals(Mineventure.getArmorHandler().get(name.concat("_leggings")))) {
			return "lightstone:textures/models/armor/".concat(name).concat("_layer_2.png");
		}
		return "lightstone:textures/models/armor/".concat(name).concat("_layer_1.png");
	}
}
