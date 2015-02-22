package org.moss.charactersheet.impl;

import java.util.Map;

/**
 * Stores all saves for character
 * @author Jacq
 *
 */
public class SaveStats {

	private String conditionalMods;
	private Map<String, Map<String, Integer>> stats;
	
	public SaveStats(String conMods, Map<String, Map<String, Integer>> stats) {
		this.conditionalMods = conMods;
		this.stats = stats;
	}

	public String getConditionalModifierInfo() {
		return conditionalMods;
	}
	
	public Map<String, Map<String, Integer>> getAllStats() {
		return stats;
	}
	
	public Map<String, Integer> getStatsForSave(String saveName) {
		return stats.get(saveName);
	}
}
