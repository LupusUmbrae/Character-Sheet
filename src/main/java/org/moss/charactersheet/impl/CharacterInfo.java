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

import lombok.Builder;
import lombok.Value;

/** Stores character meta data */
@Builder
@Value
public class CharacterInfo {

	private String characterName;
	private String playerName;
	private String clazz;
	private int level;
	private int ecl;
	private String religion;
	private Alignment alignment;
	private Size size;
	private Gender gender;
	private String race;
	private int height;
	private int weight;
	private String looks;

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
				return CharacterInfo.builder()
						.characterName(stringValues.get("Character Name"))
						.playerName(stringValues.get("Player Name"))
						.clazz(stringValues.get("Class"))
						.level(Integer.parseInt(stringValues.get("Level")))
						.ecl(Integer.parseInt(stringValues.get("ECL")))
						.religion(stringValues.get("Religion"))
						.alignment((Alignment) enumValues.get("Alignment"))
						.size((Size) enumValues.get("Size"))
						.gender((Gender) enumValues.get("Gender"))
						.race(stringValues.get("Race"))
						.height(Integer.parseInt(stringValues.get("Height")))
						.weight(Integer.parseInt(stringValues.get("Weight")))
						.looks(stringValues.get("Looks"))
						.build();
			}
		}
		return CharacterInfo.builder().build();
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
}