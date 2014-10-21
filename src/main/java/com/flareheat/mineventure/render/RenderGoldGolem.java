package com.flareheat.mineventure.render;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.flareheat.mineventure.entity.monster.EntityGoldGolem;
import com.flareheat.mineventure.model.ModelGolem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGoldGolem extends RenderLiving {
	private static ResourceLocation golemTexture = new ResourceLocation("mineventure:textures/entity/golem/gold_golem.png");
	private final ModelGolem golemModel;

	public RenderGoldGolem() {
		super(new ModelGolem(), 0.5F);
		golemModel = (ModelGolem) mainModel;
	}

	public void doRender(EntityGoldGolem golem, double d0, double d1, double d2, float f0, float f1) {
		super.doRender(golem, d0, d1, d2, f0, f1);
	}

	protected ResourceLocation getEntityTexture(EntityGoldGolem golem) {
		return RenderGoldGolem.golemTexture;
	}

	protected void rotateCorpse(EntityGoldGolem golem, float f0, float f1, float f2) {
		super.rotateCorpse(golem, f0, f1, f2);
		if (golem.limbSwingAmount >= 0.01D) {
			final float f3 = 13.0F;
			final float f4 = (golem.limbSwing - (golem.limbSwingAmount * (1.0F - f2))) + 6.0F;
			final float f5 = (Math.abs((f4 % f3) - (f3 * 0.5F)) - (f3 * 0.25F)) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}

	protected void renderEquippedItems(EntityGoldGolem golem, float f0) {
		super.renderEquippedItems(golem, f0);
		if (golem.getHoldRoseTick() != 0) {
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glPushMatrix();
			GL11.glRotatef(5.0F + ((180.0F * golemModel.golemRightArm.rotateAngleX) / (float) Math.PI), 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			final float f1 = 0.8F;
			GL11.glScalef(f1, -f1, f1);
			final int i = golem.getBrightnessForRender(f0);
			final int j = i % 65536;
			final int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			bindTexture(TextureMap.locationBlocksTexture);
			field_147909_c.renderBlockAsItem(Blocks.red_flower, 0, 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
	}

	@Override
	public void doRender(EntityLiving golem, double d0, double d1, double d2, float f0, float f1) {
		this.doRender((EntityGoldGolem) golem, d0, d1, d2, f0, f1);
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase golem, float f0) {
		this.renderEquippedItems((EntityGoldGolem) golem, f0);
	}

	@Override
	protected void rotateCorpse(EntityLivingBase golem, float f0, float f1, float f2) {
		this.rotateCorpse((EntityGoldGolem) golem, f0, f1, f2);
	}

	@Override
	public void doRender(EntityLivingBase golem, double d0, double d1, double d2, float f0, float f1) {
		this.doRender((EntityGoldGolem) golem, d0, d1, d2, f0, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity golem) {
		return this.getEntityTexture((EntityGoldGolem) golem);
	}

	@Override
	public void doRender(Entity golem, double d0, double d1, double d2, float f0, float f1) {
		this.doRender((EntityGoldGolem) golem, d0, d1, d2, f0, f1);
	}
}