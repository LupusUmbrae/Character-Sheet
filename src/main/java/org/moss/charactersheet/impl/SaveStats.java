package org.moss.charactersheet.impl;

import java.util.Map;

import lombok.Value;

/** Stores all saves for character */
@Value
public class SaveStats {
	private String conditionalMods;
	private Map<String, Map<String, Integer>> stats;
	
	public Map<String, Integer> getStatsForSave(String saveName) {
		return stats.get(saveName);
	}
}