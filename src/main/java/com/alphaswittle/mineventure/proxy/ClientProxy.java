package com.alphaswittle.mineventure.proxy;

import com.alphaswittle.mineventure.entity.monster.EntityDiamondGolem;
import com.alphaswittle.mineventure.entity.monster.EntityEmeraldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityGoldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityLapisGolem;
import com.alphaswittle.mineventure.entity.monster.EntityRedstoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityStoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityWoodGolem;
import com.alphaswittle.mineventure.entity.passive.EntitySteve;
import com.alphaswittle.mineventure.render.RenderDiamondGolem;
import com.alphaswittle.mineventure.render.RenderEmeraldGolem;
import com.alphaswittle.mineventure.render.RenderGoldGolem;
import com.alphaswittle.mineventure.render.RenderLapisGolem;
import com.alphaswittle.mineventure.render.RenderRedstoneGolem;
import com.alphaswittle.mineventure.render.RenderSteve;
import com.alphaswittle.mineventure.render.RenderStoneGolem;
import com.alphaswittle.mineventure.render.RenderWoodGolem;

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
