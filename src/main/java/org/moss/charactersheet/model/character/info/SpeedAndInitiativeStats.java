package org.moss.charactersheet.model.character.info;

import org.moss.charactersheet.model.Stats;

import lombok.Value;

@Value
public class SpeedAndInitiativeStats extends Stats {
	private int speed;
	private int initiative;
}
