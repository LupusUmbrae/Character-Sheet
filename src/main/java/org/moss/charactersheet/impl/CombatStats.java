package org.moss.charactersheet.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores character combat information
 * @author Jacq
 *
 */
public class CombatStats {

	private int baseAttack;
	private Map<Integer, Map<String, String>> stats = new HashMap<>();
	
	public CombatStats(int baseAttack, Map<Integer, Map<String, String>> combatSkills) {
		this.baseAttack = baseAttack;
		this.stats = combatSkills;
	}

	public int getBaseAttack() {
		return baseAttack;
	}
	
	public Map<Integer, Map<String, String>> getStats() {
		return stats;
	}
}
