package com.alphaswittle.mineventure.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphaswittle.mineventure.entity.monster.EntityDiamondGolem;
import com.alphaswittle.mineventure.entity.monster.EntityEmeraldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityGoldGolem;
import com.alphaswittle.mineventure.entity.monster.EntityLapisGolem;
import com.alphaswittle.mineventure.entity.monster.EntityRedstoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityStoneGolem;
import com.alphaswittle.mineventure.entity.monster.EntityWoodGolem;
import com.alphaswittle.mineventure.entity.passive.EntitySteve;
import com.alphaswittle.mineventure.localization.Localization;
import com.alphaswittle.mineventure.localization.node.DoubleNode;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	private final Logger logger = LogManager.getLogger("Mineventure/EntityHandler");

	public void load() {
		registerEntity();
		registerSpawn();
		registerLocalization();
	}

	private void registerEntity() {
		EntityRegistry.registerGlobalEntityID(EntitySteve.class, "Steve", EntityRegistry.findGlobalUniqueEntityId(), 0x0066FF, 0x996600);
		EntityRegistry.registerGlobalEntityID(EntityWoodGolem.class, "WoodGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityStoneGolem.class, "StoneGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityGoldGolem.class, "GoldGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityDiamondGolem.class, "DiamondGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityEmeraldGolem.class, "EmeraldGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityRedstoneGolem.class, "RedstoneGolem", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerGlobalEntityID(EntityLapisGolem.class, "LapisGolem", EntityRegistry.findGlobalUniqueEntityId());
	}

	private void registerSpawn() {

	}

	private void registerLocalization() {
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "Steve", "steve", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "WoodGolem", "wood_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "StoneGolem", "stone_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "GoldGolem", "gold_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "DiamondGolem", "diamond_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "EmeraldGolem", "emerald_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "RedstoneGolem", "redstone_golem", true));
		Localization.addDoubleNode("en_US", new DoubleNode("entity", "LapisGolem", "lapis_golem", true));
	}

	public Logger getLogger() {
		return logger;
	}
}
