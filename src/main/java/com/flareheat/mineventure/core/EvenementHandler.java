package com.flareheat.mineventure.core;

import net.minecraftforge.common.MinecraftForge;

import com.flareheat.mineventure.event.LivingEventHandler;

public class EvenementHandler {

	public void load() {
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
	}
}
