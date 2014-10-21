package com.flareheat.mineventure.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import com.flareheat.mineventure.entity.ai.EntityAIGolemDefendVillage;
import com.flareheat.mineventure.entity.ai.EntityAIGolemLookAtVillager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class EntityGolem extends net.minecraft.entity.monster.EntityGolem {
	private int homeCheckTimer;
	Village villageObj;
	private int attackTimer;
	private int holdRoseTick;

	public EntityGolem(World world) {
		super(world);
		setSize(1.4F, 2.9F);
		getNavigator().setAvoidsWater(true);
		tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
		tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
		tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		tasks.addTask(5, new EntityAIGolemLookAtVillager(this));
		tasks.addTask(6, new EntityAIWander(this, 0.6D));
		tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIGolemDefendVillage(this));
		targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
		targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataWatcher.addObject(16, Byte.valueOf((byte) 0));
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	protected void updateAITick() {
		if (--homeCheckTimer <= 0) {
			homeCheckTimer = 70 + rand.nextInt(50);
			villageObj = worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(posX), MathHelper.floor_double(posY), MathHelper.floor_double(posZ), 32);

			if (villageObj == null) {
				detachHome();
			} else {
				final ChunkCoordinates chunkcoordinates = villageObj.getCenter();
				setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int) (villageObj.getVillageRadius() * 0.6F));
			}
		}
		super.updateAITick();
	}

	@Override
	protected int decreaseAirSupply(int supply) {
		return supply;
	}

	@Override
	protected void collideWithEntity(Entity entity) {
		if ((entity instanceof IMob) && (getRNG().nextInt(20) == 0)) {
			setAttackTarget((EntityLivingBase) entity);
		}
		super.collideWithEntity(entity);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (attackTimer > 0) {
			--attackTimer;
		}

		if (holdRoseTick > 0) {
			--holdRoseTick;
		}

		if ((((motionX * motionX) + (motionZ * motionZ)) > 2.500000277905201E-7D) && (rand.nextInt(5) == 0)) {
			final int i = MathHelper.floor_double(posX);
			final int j = MathHelper.floor_double(posY - 0.20000000298023224D - yOffset);
			final int k = MathHelper.floor_double(posZ);
			final Block block = worldObj.getBlock(i, j, k);
			if (block.getMaterial() != Material.air) {
				worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_" + worldObj.getBlockMetadata(i, j, k), posX + ((rand.nextFloat() - 0.5D) * width), boundingBox.minY + 0.1D, posZ + ((rand.nextFloat() - 0.5D) * width), 4.0D * (rand.nextFloat() - 0.5D), 0.5D, (rand.nextFloat() - 0.5D) * 4.0D);
			}
		}
	}

	@Override
	public boolean canAttackClass(Class clazz) {
		return isPlayerCreated() && EntityPlayer.class.isAssignableFrom(clazz) ? false : super.canAttackClass(clazz);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setBoolean("PlayerCreated", isPlayerCreated());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound) {
		super.readEntityFromNBT(tagCompound);
		setPlayerCreated(tagCompound.getBoolean("PlayerCreated"));
	}

	@Override
	public boolean attackEntityAsMob(Entity entity) {
		attackTimer = 10;
		worldObj.setEntityState(this, (byte) 4);
		final boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 7 + rand.nextInt(15));
		if (flag) {
			entity.motionY += 0.4000000059604645D;
		}
		playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return flag;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte health) {
		if (health == 4) {
			attackTimer = 10;
			playSound("mob.irongolem.throw", 1.0F, 1.0F);
		} else if (health == 11) {
			holdRoseTick = 400;
		} else {
			super.handleHealthUpdate(health);
		}
	}

	public Village getVillage() {
		return villageObj;
	}

	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return attackTimer;
	}

	public void setHoldingRose(boolean isHoldingRose) {
		holdRoseTick = isHoldingRose ? 400 : 0;
		worldObj.setEntityState(this, (byte) 11);
	}

	@Override
	protected String getHurtSound() {
		return "mob.irongolem.hit";
	}

	@Override
	protected String getDeathSound() {
		return "mob.irongolem.death";
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_) {
		playSound("mob.irongolem.walk", 1.0F, 1.0F);
	}

	public int getHoldRoseTick() {
		return holdRoseTick;
	}

	public boolean isPlayerCreated() {
		return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	}

	public void setPlayerCreated(boolean isPlayerCreated) {
		final byte b0 = dataWatcher.getWatchableObjectByte(16);

		if (isPlayerCreated) {
			dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 1)));
		} else {
			dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -2)));
		}
	}

	@Override
	public void onDeath(DamageSource source) {
		if (!isPlayerCreated() && (attackingPlayer != null) && (villageObj != null)) {
			villageObj.setReputationForPlayer(attackingPlayer.getCommandSenderName(), -5);
		}
		super.onDeath(source);
	}
}
