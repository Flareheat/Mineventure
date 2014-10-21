package com.alphaswittle.mineventure.util;

public class ObfuscationHelper {

	public static boolean isObfuscated() {
		final String className = "net.minecraft.client.Minecraft";
		try {
			Class.forName(className);
		} catch (final ClassNotFoundException classNotFoundException) {
			return true;
		}
		return false;
	}
}
