package org.moss.charactersheet.impl;

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
	
	public ArmourClassStats(int base, int armourBonus, int shieldBonus, int dexMod,
			int sizeMod, int naturalArmour, int deflectMod, int miscMod, int touch, int flatFoot) {
		this.base = base;
		this.armourBonus = armourBonus;
		this.shieldBonus = shieldBonus;
		this.dexMod = dexMod;
		this.sizeMod = sizeMod;
		this.naturalArmour = naturalArmour;
		this.deflectMod = deflectMod;
		this.miscMod = miscMod;
		this.touch = touch;
		this.flatFloot = flatFoot;
	}

	public int getBase() {
		return base;
	}

	public int getArmourBonus() {
		return armourBonus;
	}

	public int getShieldBonus() {
		return shieldBonus;
	}

	public int getDexMod() {
		return dexMod;
	}

	public int getSizeMod() {
		return sizeMod;
	}

	public int getNaturalArmour() {
		return naturalArmour;
	}

	public int getDeflectMod() {
		return deflectMod;
	}

	public int getMiscMod() {
		return miscMod;
	}

	public int getTouch() {
		return touch;
	}

	public int getFlatFloot() {
		return flatFloot;
	}
}
