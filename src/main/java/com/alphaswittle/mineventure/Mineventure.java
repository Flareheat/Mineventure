package com.alphaswittle.mineventure;

import java.io.File;

import net.minecraft.client.Minecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alphaswittle.mineventure.core.ArmorHandler;
import com.alphaswittle.mineventure.core.BlockHandler;
import com.alphaswittle.mineventure.core.CraftingHandler;
import com.alphaswittle.mineventure.core.EntityHandler;
import com.alphaswittle.mineventure.core.EvenementHandler;
import com.alphaswittle.mineventure.core.FoodHandler;
import com.alphaswittle.mineventure.core.ItemHandler;
import com.alphaswittle.mineventure.core.ToolHandler;
import com.alphaswittle.mineventure.generation.WorldGenHandler;
import com.alphaswittle.mineventure.localization.Localization;
import com.alphaswittle.mineventure.proxy.CommonProxy;
import com.alphaswittle.mineventure.util.ObfuscationHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "mineventure", name = "Mineventure", version = "1.0")
public class Mineventure {
	@Instance("mineventure")
	public static Mineventure instance;

	@SidedProxy(clientSide = "com.alphaswittle.mineventure.proxy.ClientProxy", serverSide = "com.alphaswittle.mineventure.proxy.CommonProxy")
	public static CommonProxy proxy;

	private static Logger logger = LogManager.getLogger("Mineventure");

	private static String defaultLanguage = "en_US";
	private static String defaultLanguageFile = defaultLanguage.concat(".lang");
	private static String defaultPath = "C:/Users/Skander/Documents/forge/src/main/resources/assets/mineventure/lang/" + defaultLanguageFile;

	private static BlockHandler blockHandler = new BlockHandler();
	private static ItemHandler itemHandler = new ItemHandler();
	private static ArmorHandler armorHandler = new ArmorHandler();
	private static ToolHandler toolHandler = new ToolHandler();
	private static FoodHandler foodHandler = new FoodHandler();
	private static EntityHandler entityHandler = new EntityHandler();
	private static WorldGenHandler worldGenHandler = new WorldGenHandler();
	private static CraftingHandler craftingHandler = new CraftingHandler();
	private static EvenementHandler evenementHandler = new EvenementHandler();

	@EventHandler
	public static void preInit(final FMLPreInitializationEvent event) {
		if (ObfuscationHelper.isObfuscated()) {
			logger.info("Running on an obfuscated environment");
		} else {
			logger.info("Running on a non-obfuscated environment");
		}
		itemHandler.load();
		armorHandler.load();
		blockHandler.load();
		toolHandler.load();
		foodHandler.load();
		entityHandler.load();
		worldGenHandler.load();
		evenementHandler.load();
	}

	@EventHandler
	public static void init(final FMLInitializationEvent event) {
		craftingHandler.load();
		proxy.registerEntityRender();
	}
	@EventHandler
	public static void postInit(final FMLPostInitializationEvent event) {
		if (!Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode().equalsIgnoreCase(defaultLanguage)) {
			defaultLanguage = Minecraft.getMinecraft().getLanguageManager().getCurrentLanguage().getLanguageCode();
		}
		Localization.generateLanguageFile(defaultLanguage, new File(defaultLanguageFile), ObfuscationHelper.isObfuscated() ? null : defaultPath);
	}
	public static Logger getLogger() {
		return logger;
	}

	public static BlockHandler getBlockHandler() {
		return blockHandler;
	}

	public static ItemHandler getItemHandler() {
		return itemHandler;
	}

	public static ArmorHandler getArmorHandler() {
		return armorHandler;
	}

	public static ToolHandler getToolHandler() {
		return toolHandler;
	}

	public static FoodHandler getFoodHandler() {
		return foodHandler;
	}

	public static EntityHandler getEntityHandler() {
		return entityHandler;
	}

	public static WorldGenHandler getWorldGenHandler() {
		return worldGenHandler;
	}

	public static CraftingHandler getCraftingHandler() {
		return craftingHandler;
	}

	public static EvenementHandler getEvenementHandler() {
		return evenementHandler;
	}

	public static boolean isObfuscated() {
		return ObfuscationHelper.isObfuscated();
	}
}