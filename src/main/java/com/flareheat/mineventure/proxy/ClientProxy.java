package com.flareheat.mineventure.proxy;

import com.flareheat.mineventure.entity.monster.EntityDiamondGolem;
import com.flareheat.mineventure.entity.monster.EntityEmeraldGolem;
import com.flareheat.mineventure.entity.monster.EntityGoldGolem;
import com.flareheat.mineventure.entity.monster.EntityLapisGolem;
import com.flareheat.mineventure.entity.monster.EntityRedstoneGolem;
import com.flareheat.mineventure.entity.monster.EntityStoneGolem;
import com.flareheat.mineventure.entity.monster.EntityWoodGolem;
import com.flareheat.mineventure.entity.passive.EntitySteve;
import com.flareheat.mineventure.render.RenderDiamondGolem;
import com.flareheat.mineventure.render.RenderEmeraldGolem;
import com.flareheat.mineventure.render.RenderGoldGolem;
import com.flareheat.mineventure.render.RenderLapisGolem;
import com.flareheat.mineventure.render.RenderRedstoneGolem;
import com.flareheat.mineventure.render.RenderSteve;
import com.flareheat.mineventure.render.RenderStoneGolem;
import com.flareheat.mineventure.render.RenderWoodGolem;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEntityRender() {
		super.registerEntityRender();
		RenderingRegistry.registerEntityRenderingHandler(EntitySteve.class, new RenderSteve());
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodGolem.class, new RenderWoodGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneGolem.class, new RenderStoneGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldGolem.class, new RenderGoldGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondGolem.class, new RenderDiamondGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldGolem.class, new RenderEmeraldGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneGolem.class, new RenderRedstoneGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityLapisGolem.class, new RenderLapisGolem());
	}
}
