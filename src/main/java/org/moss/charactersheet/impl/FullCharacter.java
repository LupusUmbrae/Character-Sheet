package org.moss.charactersheet.impl;

import org.moss.charactersheet.interfaces.Stats;

import lombok.Builder;
import lombok.Value;

/**
 * Holds all character information:
 * <li>{@link CharacterInfo}</li>
 * <li>{@link AbilityStats}</li>
 * <li>{@link CombatStats}</li>
 * <li>{@link SpeedAndInitiative}</li>
 * <li>{@link GrappleStats}</li>
 * <li>{@link SaveStats}</li>
 * <li>{@link ArmourClassStats}</li>
 */
@Builder
@Value
public class FullCharacter extends Stats {
	private CharacterInfo info;
	private AbilityStats abilityStats;
	private CombatStats combatStats;
	private SpeedAndInitiative speedStats;
	private GrappleStats grappleStats;
	private SaveStats saveStats;
	private ArmourClassStats acStats;
}