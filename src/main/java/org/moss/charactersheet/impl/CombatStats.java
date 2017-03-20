package org.moss.charactersheet.impl;

import java.util.HashMap;
import java.util.Map;

import lombok.Value;

/** Stores character combat information */
@Value
public class CombatStats {
	private final int baseAttack;
	private final Map<Integer, Map<String, String>> stats;

	public Map<String, String> getStatsForWeaponNum(int weaponNum) {
		return stats.get(weaponNum);
	}
}