package com.alphaswittle.mineventure.localization.node;

import com.alphaswittle.mineventure.localization.Localization;
import com.alphaswittle.mineventure.localization.LocalizationNode;

public class SimpleNode implements LocalizationNode {
	private final String text;
	private final String type;
	private final boolean usesName;

	public SimpleNode(String type, String text, boolean usesName) {
		this.type = type;
		this.text = text;
		this.usesName = usesName;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public boolean usesName() {
		return usesName;
	}

	@Override
	public int compareTo(LocalizationNode localizationNode) {
		return Localization.compare(this, localizationNode);
	}
}
