package org.moss.charactersheet.model.character.info;

import org.moss.charactersheet.model.Stats;

import lombok.Value;

@Value
public class ArmourClassStats extends Stats {
	private int base;
	private int armourBonus;
	private int shieldBonus;
	private int dexMod;
	private int sizeMod;
	private int naturalArmour;
	private int deflectMod;
	private int miscMod;
	private int touch;
	private int flatFloot;
}
