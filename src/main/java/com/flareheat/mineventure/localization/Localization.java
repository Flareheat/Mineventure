package com.flareheat.mineventure.localization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flareheat.mineventure.localization.node.DoubleNode;
import com.flareheat.mineventure.localization.node.SimpleNode;
import com.google.common.io.Files;

public class Localization {
	private static Map<String, List<SimpleNode>> simpleMap = new HashMap<String, List<SimpleNode>>();
	private static Map<String, List<DoubleNode>> doubleMap = new HashMap<String, List<DoubleNode>>();

	public static void addSimpleNode(String language, SimpleNode node) {
		if (!simpleMap.containsKey(language)) {
			simpleMap.put(language, new ArrayList<SimpleNode>());
		}
		simpleMap.get(language).add(node);
	}

	public static void addDoubleNode(String language, DoubleNode nodeDouble) {
		if (!doubleMap.containsKey(language)) {
			doubleMap.put(language, new ArrayList<DoubleNode>());
		}
		doubleMap.get(language).add(nodeDouble);
	}

	public static void generateLanguageFile(String language, File file, String Path) {
		final ArrayList<LocalizationNode> list = new ArrayList<LocalizationNode>();
		for (final SimpleNode node : simpleMap.get(language)) {
			list.add(node);
		}
		for (final DoubleNode nodeDouble : doubleMap.get(language)) {
			list.add(nodeDouble);
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			final String line = reader.readLine();
			if ((line == null) || !line.startsWith("count")) {
				reader.close();
			} else {
				final int count = Integer.valueOf(line.split("=")[1]);
				if (count == list.size()) {
					reader.close();
					return;
				}
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
		Collections.sort(list);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write("count=" + list.size());
			writer.newLine();
			for (final LocalizationNode node : list) {
				if (node instanceof DoubleNode) {
					final DoubleNode nodeDouble = (DoubleNode) node;
					final String text = nodeDouble.getText();
					final String textToUse = nodeDouble.getTextToUse();
					if (textToUse.contains("_")) {
						final String first = Localization.capitalize(textToUse.split("_")[0]);
						final String second = Localization.capitalize(textToUse.split("_")[1]);
						if (nodeDouble.usesName()) {
							writer.write(node.getType().concat(".").concat(text).concat(".name=").concat(first).concat(" ").concat(second));
							writer.newLine();
						} else {
							writer.write(node.getType().concat(".").concat(text).concat("=").concat(first).concat(" ").concat(second));
							writer.newLine();
						}
					} else {
						final String word = Localization.capitalize(textToUse);
						if (node.usesName()) {
							writer.write(node.getType().concat(".").concat(text).concat(".name=").concat(word));
							writer.newLine();
						} else {
							writer.write(node.getType().concat(".").concat(text).concat("=").concat(word));
							writer.newLine();
						}
					}
				} else {
					final String text = node.getText();
					if (text.contains("_")) {
						final String first = Localization.capitalize(text.split("_")[0]);
						final String second = Localization.capitalize(text.split("_")[1]);
						if (node.usesName()) {
							writer.write(node.getType().concat(".").concat(text).concat(".name=").concat(first).concat(" ").concat(second));
							writer.newLine();
						} else {
							writer.write(node.getType().concat(".").concat(text).concat("=").concat(first).concat(" ").concat(second));
							writer.newLine();
						}
					} else {
						final String world = Localization.capitalize(text);
						if (node.usesName()) {
							writer.write(node.getType().concat(".").concat(text).concat(".name=").concat(world));
							writer.newLine();
						} else {
							writer.write(node.getType().concat(".").concat(text).concat("=").concat(world));
							writer.newLine();
						}
					}
				}
			}
			writer.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		if (Path != null) {
			try {
				Files.copy(file, new File(Path));
				file.delete();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int compare(LocalizationNode firstNode, LocalizationNode secondNode) {
		final int i = firstNode.getType().length();
		final int j = secondNode.getType().length();
		final int k = Math.min(i, j);
		final char[] arrayOfChar1 = firstNode.getType().toCharArray();
		final char[] arrayOfChar2 = secondNode.getType().toCharArray();
		for (int m = 0; m < k; m++) {
			final int n = arrayOfChar1[m];
			final int i1 = arrayOfChar2[m];
			if (n != i1) {
				return n - i1;
			}
		}
		return i - j;
	}

	private static String capitalize(String source) {
		return source.substring(0, 1).toUpperCase().concat(source.substring(1));
	}
}
