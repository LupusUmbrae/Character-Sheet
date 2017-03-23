package org.moss.charactersheet.aspects.enums;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Skill class. Currently contains a static map of all known skills and their corresponding
 * ability modifier.
 */
public class Skill {
    private static final Map<String, Skill> SKILLS_MAP = new TreeMap<>();
    static {
        SKILLS_MAP.put("Appraise", new Skill("Appraise", AbilityScore.INT, false));
        SKILLS_MAP.put("Autohypnosis", new Skill("Autohypnosis", AbilityScore.WIS, false));
        SKILLS_MAP.put("Balance", new Skill("Balance", AbilityScore.DEX, false));
        SKILLS_MAP.put("Bluff", new Skill("Bluff", AbilityScore.CHA, false));
        SKILLS_MAP.put("Climb", new Skill("Climb", AbilityScore.STR, false));
        SKILLS_MAP.put("Concentration", new Skill("Concentration", AbilityScore.CON, false));
        SKILLS_MAP.put("Decipher Script", new Skill("Decipher Script", AbilityScore.INT, false));
        SKILLS_MAP.put("Diplomacy", new Skill("Diplomacy", AbilityScore.CHA, false));
        SKILLS_MAP.put("Disable Device", new Skill("Disable Device", AbilityScore.INT, false));
        SKILLS_MAP.put("Disguise", new Skill("Disguise", AbilityScore.CHA, false));
        SKILLS_MAP.put("Escape Artist", new Skill("Escape Artist", AbilityScore.DEX, false));
        SKILLS_MAP.put("Forgery", new Skill("AutohForgeryypnosis", AbilityScore.INT, false));
        SKILLS_MAP.put("Gather Information", new Skill("Gather Information", AbilityScore.CHA, false));
        SKILLS_MAP.put("Handle Animal", new Skill("Handle Animal", AbilityScore.CHA, false));
        SKILLS_MAP.put("Heal", new Skill("Heal", AbilityScore.WIS, false));
        SKILLS_MAP.put("Hide", new Skill("Hide", AbilityScore.DEX, false));
        SKILLS_MAP.put("Intimidate", new Skill("Intimidate", AbilityScore.CHA, false));
        SKILLS_MAP.put("Jump", new Skill("Jump", AbilityScore.DEX, false));
        SKILLS_MAP.put("Knowledge (Arcana)", new Skill("Knowledge (Arcana)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Arch/Eng)", new Skill("Knowledge (Arch/Eng)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Dungeoneering)", new Skill("Knowledge (Dungeoneering)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Geography)", new Skill("Knowledge (Geography)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (History)", new Skill("Knowledge (History)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Local)", new Skill("Knowledge (Local)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Nature)", new Skill("Knowledge (Nature)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Nobility/Royalty)", new Skill("Knowledge (Nobility/Royalty)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (The Planes)", new Skill("Knowledge (The Planes)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Psionics)", new Skill("Knowledge (Psionics)", AbilityScore.INT, false));
        SKILLS_MAP.put("Knowledge (Religion)", new Skill("Knowledge (Religion)", AbilityScore.INT, false));
        SKILLS_MAP.put("Listen", new Skill("Listen", AbilityScore.WIS, false));
        SKILLS_MAP.put("Move Silently", new Skill("Move Silently", AbilityScore.DEX, false));
        SKILLS_MAP.put("Open Lock", new Skill("Open Lock", AbilityScore.DEX, false));
        SKILLS_MAP.put("Perform (Act)", new Skill("Perform (Act)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Comedy)", new Skill("Perform (Comedy)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Dance)", new Skill("Perform (Dance)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Keyboard)", new Skill("Perform (Keyboard)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Oratory)", new Skill("Perform (Oratory)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Percussion)", new Skill("Perform (Percussion)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (String Instrument)", new Skill("Perform (String Instrument)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Perform (Wind Instrument)", new Skill("Perform (Wind Instrument)", AbilityScore.CHA, false));
        SKILLS_MAP.put("Psicraft", new Skill("Intimidate", AbilityScore.INT, false));
        SKILLS_MAP.put("Ride", new Skill("Intimidate", AbilityScore.DEX, false));
        SKILLS_MAP.put("Search", new Skill("Intimidate", AbilityScore.INT, false));
        SKILLS_MAP.put("Sense Motive", new Skill("Intimidate", AbilityScore.WIS, false));
        SKILLS_MAP.put("Sleight of Hand", new Skill("Intimidate", AbilityScore.DEX, false));
        SKILLS_MAP.put("Spellcraft", new Skill("Intimidate", AbilityScore.INT, false));
        SKILLS_MAP.put("Spot", new Skill("Intimidate", AbilityScore.WIS, false));
        SKILLS_MAP.put("Survival", new Skill("Intimidate", AbilityScore.WIS, false));
        SKILLS_MAP.put("Swim", new Skill("Intimidate", AbilityScore.STR, false));
        SKILLS_MAP.put("Tumble", new Skill("Intimidate", AbilityScore.DEX, false));
        SKILLS_MAP.put("Use Magic Device", new Skill("Intimidate", AbilityScore.CHA, false));
        SKILLS_MAP.put("Use Psionic Device", new Skill("Intimidate", AbilityScore.CHA, false));
        SKILLS_MAP.put("Use Rope", new Skill("Intimidate", AbilityScore.DEX, false));
        
        SKILLS_MAP.put("Craft", new Skill("Craft", AbilityScore.INT, true));
		SKILLS_MAP.put("Knowledge", new Skill("Knowledge", AbilityScore.INT, true));
		SKILLS_MAP.put("Profession", new Skill("Profession", AbilityScore.WIS, true));
		SKILLS_MAP.put("Perform", new Skill("Perform", AbilityScore.CHA, true));
    }
    
    private String skillName;
    private AbilityScore ability;
	private boolean customSkill;

	public Skill(String name, AbilityScore ability, boolean isCustom) {
        this.skillName = name;
        this.ability = ability;
        this.customSkill = isCustom;
    }

    public String getSkillName()
    {
        return skillName;
    }

    public AbilityScore getAbility()
    {
        return ability;
    }

    public boolean isCustomSkill() 
    {
		return customSkill;
	}
    
    /**
     * Returns key set of skill names from <code>SKILLS_MAP</code>
     * @return
     */
    public static Set<String> getValues()
    {
        return SKILLS_MAP.keySet();
    }

    public static Skill getSkill(String name)
    {
        return SKILLS_MAP.get(name);
    }
    
    public static Skill addSkill(String name, AbilityScore ability, boolean isCustom) {
    	SKILLS_MAP.put(name, new Skill(name, ability, isCustom));
    	return SKILLS_MAP.get(name);
    }
}
