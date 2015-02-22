package org.moss.charactersheet.impl;

public class GrappleStats {
	private int total;
	private int bab;
	private int strMod;
	private int sizeMod;
	private int miscMod;

	public GrappleStats(int total, int bab, int strMod, int sizeMod, int miscMod) {
		this.total = total;
		this.bab = bab;
		this.sizeMod = sizeMod;
		this.strMod = strMod;
		this.miscMod = miscMod;
	}

	public int getTotal() {
		return total;
	}

	public int getBab() {
		return bab;
	}

	public int getStrMod() {
		return strMod;
	}

	public int getSizeMod() {
		return sizeMod;
	}

	public int getMiscMod() {
		return miscMod;
	}
}
