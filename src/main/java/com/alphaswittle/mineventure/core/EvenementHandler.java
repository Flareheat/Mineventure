package com.alphaswittle.mineventure.core;

import net.minecraftforge.common.MinecraftForge;

import com.alphaswittle.mineventure.event.LivingEventHandler;

public class EvenementHandler {

	public void load() {
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
	}
}
