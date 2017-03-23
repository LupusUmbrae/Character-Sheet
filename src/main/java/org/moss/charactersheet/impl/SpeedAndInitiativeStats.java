package org.moss.charactersheet.impl;

import org.moss.charactersheet.interfaces.Stats;

import lombok.Value;

@Value
public class SpeedAndInitiativeStats extends Stats {
	private int speed;
	private int initiative;
}
