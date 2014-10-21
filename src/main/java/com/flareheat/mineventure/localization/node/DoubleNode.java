package com.flareheat.mineventure.localization.node;

import com.flareheat.mineventure.localization.Localization;
import com.flareheat.mineventure.localization.LocalizationNode;

public class DoubleNode implements LocalizationNode {
	private final String type;
	private final String text;
	private final String textToUse;
	private final boolean usesName;

	public DoubleNode(String type, String originalText, String textToUse, boolean usesName) {
		this.type = type;
		text = originalText;
		this.textToUse = textToUse;
		this.usesName = usesName;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getText() {
		return text;
	}

	public String getTextToUse() {
		return textToUse;
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
