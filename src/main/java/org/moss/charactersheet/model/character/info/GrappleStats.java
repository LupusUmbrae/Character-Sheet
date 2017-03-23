package org.moss.charactersheet.model.character.info;

import org.moss.charactersheet.model.Stats;

import lombok.Value;

@Value
public class GrappleStats extends Stats {
	private int total;
	private int bab;
	private int strMod;
	private int sizeMod;
	private int miscMod;
}
