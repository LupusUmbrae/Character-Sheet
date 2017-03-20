package org.moss.charactersheet.impl;

import lombok.Value;

@Value
public class ArmourClassStats {
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
