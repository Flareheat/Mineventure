package com.flareheat.mineventure.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.village.Village;

import com.flareheat.mineventure.entity.EntityGolem;

public class EntityAIGolemDefendVillage extends EntityAITarget {
	EntityGolem theGolem;
	EntityLivingBase villageAgressorTarget;

	public EntityAIGolemDefendVillage(EntityGolem golem) {
		super(golem, false, true);
		theGolem = golem;
		setMutexBits(1);
	}

	@Override
	public boolean shouldExecute() {
		final Village village = theGolem.getVillage();

		if (village == null) {
			return false;
		} else {
			villageAgressorTarget = village.findNearestVillageAggressor(theGolem);

			if (!isSuitableTarget(villageAgressorTarget, false)) {
				if (taskOwner.getRNG().nextInt(20) == 0) {
					villageAgressorTarget = village.func_82685_c(theGolem);
					return isSuitableTarget(villageAgressorTarget, false);
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	@Override
	public void startExecuting() {
		theGolem.setAttackTarget(villageAgressorTarget);
		super.startExecuting();
	}
}