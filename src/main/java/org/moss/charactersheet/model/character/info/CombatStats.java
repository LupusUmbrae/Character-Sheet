package org.moss.charactersheet.model.character.info;

import java.util.Map;

import org.moss.charactersheet.model.Stats;

import lombok.Value;

/** Stores character combat information */
@Value
public class CombatStats extends Stats {
	private final int baseAttack;
	private final Map<Integer, Map<String, String>> stats;

	public Map<String, String> getStatsForWeaponNum(int weaponNum) {
		return stats.get(weaponNum);
	}
}