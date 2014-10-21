package com.alphaswittle.mineventure.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.alphaswittle.mineventure.entity.passive.EntitySteve;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSteve extends RenderBiped {
	private static final ResourceLocation steveTextures = new ResourceLocation("mineventure:textures/entity/steve.png");

	public RenderSteve() {
		super(new ModelBiped(), 0.5f);
	}

	protected ResourceLocation getEntityTexture(EntitySteve entitySteve) {
		return steveTextures;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntitySteve) entity);
	}
}