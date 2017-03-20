package org.moss.charactersheet.aspects.inv;

import java.util.HashMap;
import java.util.HashSet;

public class WeightMap {

	private static final HashMap<Integer, HashSet<Integer>> STR_LOAD_MAP = new HashMap<>();
	
	static
	{
		STR_LOAD_MAP.put(1, new HashSet<Integer>());
		STR_LOAD_MAP.get(1).add(3);
		
		
	}
	
}
