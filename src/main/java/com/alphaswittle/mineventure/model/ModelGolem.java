package com.alphaswittle.mineventure.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import com.alphaswittle.mineventure.entity.EntityGolem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGolem extends ModelBase {
	public ModelRenderer golemHead;
	public ModelRenderer golemBody;
	public ModelRenderer golemRightArm;
	public ModelRenderer golemLeftArm;
	public ModelRenderer golemLeftLeg;
	public ModelRenderer golemRightLeg;

	public ModelGolem() {
		this(0.0F);
	}

	public ModelGolem(float floatValue) {
		this(floatValue, -7.0F);
	}

	public ModelGolem(float floatValue, float floatValue2) {
		final short short1 = 128;
		final short short2 = 128;
		golemHead = (new ModelRenderer(this)).setTextureSize(short1, short2);
		golemHead.setRotationPoint(0.0F, 0.0F + floatValue2, -2.0F);
		golemHead.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8, 10, 8, floatValue);
		golemHead.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2, 4, 2, floatValue);
		golemBody = (new ModelRenderer(this)).setTextureSize(short1, short2);
		golemBody.setRotationPoint(0.0F, 0.0F + floatValue2, 0.0F);
		golemBody.setTextureOffset(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18, 12, 11, floatValue);
		golemBody.setTextureOffset(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9, 5, 6, floatValue + 0.5F);
		golemRightArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
		golemRightArm.setRotationPoint(0.0F, -7.0F, 0.0F);
		golemRightArm.setTextureOffset(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4, 30, 6, floatValue);
		golemLeftArm = (new ModelRenderer(this)).setTextureSize(short1, short2);
		golemLeftArm.setRotationPoint(0.0F, -7.0F, 0.0F);
		golemLeftArm.setTextureOffset(60, 58).addBox(9.0F, -2.5F, -3.0F, 4, 30, 6, floatValue);
		golemLeftLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
		golemLeftLeg.setRotationPoint(-4.0F, 18.0F + floatValue2, 0.0F);
		golemLeftLeg.setTextureOffset(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, floatValue);
		golemRightLeg = (new ModelRenderer(this, 0, 22)).setTextureSize(short1, short2);
		golemRightLeg.mirror = true;
		golemRightLeg.setTextureOffset(60, 0).setRotationPoint(5.0F, 18.0F + floatValue2, 0.0F);
		golemRightLeg.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, floatValue);
	}

	@Override
	public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f0, f1, f2, f3, f4, f5, entity);
		golemHead.render(f5);
		golemBody.render(f5);
		golemLeftLeg.render(f5);
		golemRightLeg.render(f5);
		golemRightArm.render(f5);
		golemLeftArm.render(f5);
	}

	@Override
	public void setRotationAngles(float f0, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		golemHead.rotateAngleY = f3 / (180F / (float) Math.PI);
		golemHead.rotateAngleX = f4 / (180F / (float) Math.PI);
		golemLeftLeg.rotateAngleX = -1.5F * func_78172_a(f0, 13.0F) * f1;
		golemRightLeg.rotateAngleX = 1.5F * func_78172_a(f0, 13.0F) * f1;
		golemLeftLeg.rotateAngleY = 0.0F;
		golemRightLeg.rotateAngleY = 0.0F;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float f0, float f1, float f2) {
		final EntityGolem entityirongolem = (EntityGolem) entity;
		final int i = entityirongolem.getAttackTimer();

		if (i > 0) {
			golemRightArm.rotateAngleX = -2.0F + (1.5F * func_78172_a(i - f2, 10.0F));
			golemLeftArm.rotateAngleX = -2.0F + (1.5F * func_78172_a(i - f2, 10.0F));
		} else {
			final int j = entityirongolem.getHoldRoseTick();

			if (j > 0) {
				golemRightArm.rotateAngleX = -0.8F + (0.025F * func_78172_a(j, 70.0F));
				golemLeftArm.rotateAngleX = 0.0F;
			} else {
				golemRightArm.rotateAngleX = (-0.2F + (1.5F * func_78172_a(f0, 13.0F))) * f1;
				golemLeftArm.rotateAngleX = (-0.2F - (1.5F * func_78172_a(f0, 13.0F))) * f1;
			}
		}
	}

	private float func_78172_a(float f0, float f1) {
		return (Math.abs((f0 % f1) - (f1 * 0.5F)) - (f1 * 0.25F)) / (f1 * 0.25F);
	}
}