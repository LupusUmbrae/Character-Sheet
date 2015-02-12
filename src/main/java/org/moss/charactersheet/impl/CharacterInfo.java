package org.moss.charactersheet.impl;

import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.enums.Alignment;
import org.moss.charactersheet.impl.enums.Gender;
import org.moss.charactersheet.impl.enums.Size;

/**
 * Stores character meta data
 * @author Jacq
 *
 */
public class CharacterInfo {

	private String characterName;
	private String playerName;
	private String clazz;
	private int level;
	private int ecl;
	private String religion;
	private Alignment align;
	private Size size;
	private Gender gender;
	private String race;
	private int height;
	private int weight;
	private String looks;

	public CharacterInfo(String name, String player, String clazz, int level, int ecl, String religion,
			Alignment align, Size size, Gender gender, String race, int height, int weight, String looks) {
		this.characterName = name;
		this.playerName = player;
		this.level = level;
		this.clazz = clazz;
		this.ecl = ecl;
		this.religion = religion;
		this.align = align;
		this.size = size;
		this.gender = gender;
		this.race = race;
		this.height = height;
		this.weight = weight;
		this.looks = looks;
	}

	public CharacterInfo() {
	}

	/**
	 * Extracts information from given components and returns 
	 * new <code>CharacterInfo</code> object
	 * @param components
	 * @return <code>CharacterInfo</code>
	 */
	public static CharacterInfo createCharacter(List<Component> components) {
		// List should only contain the one panel used to display character info
		Map<String, String> stringValues = new HashMap<>();
		Map<String, Object> enumValues = new HashMap<>();
		for (Component curComp : components) {
			if (curComp instanceof JPanel) {
				JPanel panel = (JPanel) curComp;
				checkComponents(panel, stringValues, enumValues);
				if (stringValues.size() < 10 || enumValues.size() < 3) {
					continue;
				}
				return new CharacterInfo(
						stringValues.get("Character Name"),
						stringValues.get("Player Name"),
						stringValues.get("Class"),
						Integer.parseInt(stringValues.get("Level")),
						Integer.parseInt(stringValues.get("ECL")),
						stringValues.get("Religion"),
						(Alignment) enumValues.get("Alignment"),
						(Size) enumValues.get("Size"),
						(Gender) enumValues.get("Gender"),
						stringValues.get("Race"),
						Integer.parseInt(stringValues.get("Height")),
						Integer.parseInt(stringValues.get("Weight")),
						stringValues.get("Looks")
						);
			}
		}
		return null;
	}

	/**
	 * Extracts information and stores the data in maps for later construction
	 * @param panel
	 * @param stringValues
	 * @param enumValues
	 */
	private static void checkComponents(JComponent panel,
			Map<String, String> stringValues, Map<String, Object> enumValues) {
		for (Component comp : panel.getComponents()) {
			String compName = comp.getName();
			if (comp instanceof JTextField) {
				String text = ((JTextField) comp).getText();
				stringValues.put(compName, text);
			} else if (comp instanceof JComboBox<?>) {
				Object value = ((JComboBox<?>) comp).getSelectedItem();
				enumValues.put(compName, value);
			} else if (comp instanceof JComponent) {
				checkComponents((JComponent) comp, stringValues, enumValues);
			}
		}		
	}

	public String getName() {
		return characterName;
	}

	public String getPlayer() {
		return playerName;
	}

	public String getClazz() {
		return clazz;
	}

	public int getLevel() {
		return level;
	}

	public int getEcl() {
		return ecl;
	}

	public String getReligion() {
		return religion;
	}

	public Alignment getAlign() {
		return align;
	}

	public Size getSize() {
		return size;
	}

	public Gender getGender() {
		return gender;
	}

	public String getRace() {
		return race;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public String getLooks() {
		return looks;
	}
}