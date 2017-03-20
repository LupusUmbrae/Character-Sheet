package org.moss.charactersheet.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores all ability scores for character
 */
public class AbilityStats {

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
