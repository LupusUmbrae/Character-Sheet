package org.moss.charactersheet.model.character.info;

import org.moss.charactersheet.model.Stats;

import lombok.Builder;
import lombok.Value;

/**
 * Holds all character information:
 * <li>{@link CharacterInfo}</li>
 * <li>{@link AbilityStats}</li>
 * <li>{@link CombatStats}</li>
 * <li>{@link SpeedAndInitiativeStats}</li>
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
	private SpeedAndInitiativeStats speedStats;
	private GrappleStats grappleStats;
	private SaveStats saveStats;
	private ArmourClassStats acStats;
}