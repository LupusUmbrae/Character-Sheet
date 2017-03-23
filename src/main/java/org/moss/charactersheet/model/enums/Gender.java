package org.moss.charactersheet.model.enums;

/**
 * Gender enum to bridge between combo box and <code>CharacterInfo</code>
 */
public enum Gender {
	M("Male"),
	F("Female");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public Gender getGenderAbbr() {
		return Gender.valueOf(gender);
	}
}
