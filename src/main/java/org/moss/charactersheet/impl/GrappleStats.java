package org.moss.charactersheet.impl;

import org.moss.charactersheet.interfaces.Stats;

import lombok.Value;

@Value
public class GrappleStats extends Stats {
	private int total;
	private int bab;
	private int strMod;
	private int sizeMod;
	private int miscMod;
}
