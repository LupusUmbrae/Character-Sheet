package org.moss.charactersheet.model.character.info;

import java.util.HashMap;
import java.util.Map;

import org.moss.charactersheet.model.Stats;

/**
 * Stores all ability scores for character
 */
public class AbilityStats extends Stats {

	private Map<String, Map<String, Integer>> stats = new HashMap<>();

	public AbilityStats(Map<String, Map<String, Integer>> skills) {
		this.stats = skills;
	}

	public Map<String, Map<String, Integer>> getAllStats() {
		return stats;
	}
	
	public Map<String, Integer> getStatsForAbility(String abilityName) {
		return stats.get(abilityName);
	}
}
