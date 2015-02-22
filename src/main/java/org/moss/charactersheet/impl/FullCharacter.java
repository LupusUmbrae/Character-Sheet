package org.moss.charactersheet.impl;

/**
 * Holds all character information:
 * <li><code>CharacterInfo</code></li>
 * <li><code>AbilityStats</code></li>
 * <li><code>CombatStats</code></li>
 * <li><code>SaveStats</code></li>
 * 
 * @author Jacq
 *
 */
public class FullCharacter {

	private CharacterInfo info;
	private AbilityStats abilityStats;
	private CombatStats combatStats;
	private SpeedAndInitiative speedStats;
	private GrappleStats grappleStats;
	private SaveStats saveStats;
	private ArmourClassStats acStats;
	
	public FullCharacter(CharacterInfo info, AbilityStats abilityStats, CombatStats combatStats,
			SpeedAndInitiative speedStats, GrappleStats grappleStats, SaveStats saveStats,
			ArmourClassStats acStats) {
		this.info = info;
		this.abilityStats = abilityStats;
		this.combatStats = combatStats;
		this.speedStats = speedStats;
		this.grappleStats = grappleStats;
		this.saveStats = saveStats;
		this.acStats = acStats;
	}
	
	public FullCharacter() {
	}

	public CharacterInfo getCharInfo() {
		return info;
	}
	
	public AbilityStats getAbilityStats() {
		return abilityStats;
	}
	
	public CombatStats getCombatStat() {
		return combatStats;
	}
	
	public SpeedAndInitiative getSpeedAndInitStats() {
		return speedStats;
	}
	
	public GrappleStats getGrappleStats() {
		return grappleStats;
	}
	
	public SaveStats getSaveStats() {
		return saveStats;
	}
	
	public ArmourClassStats getAcStats() {
		return acStats;
	}
}
