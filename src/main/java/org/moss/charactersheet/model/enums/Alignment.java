package org.moss.charactersheet.model.enums;

/**
 * All possible Alignment enums to bridge between combo box and <code>CharacterInfo</code>
 */
public enum Alignment {
	
	LG("Lawful Good"),
	NG("Neutral Good"),
	CG("Chaotic Good"),
	LE("Lawful Evil"),
	NE("Neutral Evil"),
	CE("Chaotic Evil"),
	LN("Lawful Neutral"),
	TN("True Neutral"),
	CN("Chaotic Neutral");
	
	private String align;
	
	private Alignment(String align) {
		this.align = align;
	}
	
	public Alignment getAlignmentAbbr() {
		return Alignment.valueOf(align);
	}
	
	public String getAlignment() {
		return align;
	}
}
