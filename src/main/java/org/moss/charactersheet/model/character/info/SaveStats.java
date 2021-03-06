package org.moss.charactersheet.model.character.info;

import java.util.Map;

import org.moss.charactersheet.model.Stats;

import lombok.Value;

/** Stores all saves for character */
@Value
public class SaveStats extends Stats {
	private String conditionalMods;
	private Map<String, Map<String, Integer>> stats;
	
	public Map<String, Integer> getStatsForSave(String saveName) {
		return stats.get(saveName);
	}
}