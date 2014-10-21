package com.alphaswittle.mineventure.localization;

public interface LocalizationNode extends Comparable<LocalizationNode> {
	public String getText();

	public String getType();

	public boolean usesName();
}
