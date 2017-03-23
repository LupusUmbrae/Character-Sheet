package org.moss.charactersheet.model.character.info;

import java.awt.Component;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.model.enums.Alignment;
import org.moss.charactersheet.model.enums.Gender;
import org.moss.charactersheet.model.enums.Size;
import org.moss.charactersheet.model.Stats;

import lombok.Builder;
import lombok.Value;

/** Stores character meta data */
@Builder
@Value
public class CharacterInfo extends Stats {

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
			checkComponents(curComp, stringValues, enumValues);
			if (stringValues.size() < 10 || enumValues.size() < 3) {
				continue;
			}
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

	/**
	 * Extracts information and stores the data in maps for later construction
	 * @param comp
	 * @param stringValues
	 * @param enumValues
	 */
	private static void checkComponents(Component comp,
										Map<String, String> stringValues, Map<String, Object> enumValues) {
		String compName = comp.getName();
		if (comp instanceof JTextField) {
			String text = ((JTextField) comp).getText();
			stringValues.put(compName, text);
		} else if (comp instanceof JComboBox<?>) {
			Object value = ((JComboBox<?>) comp).getSelectedItem();
			enumValues.put(compName, value);
		} else if (comp instanceof JPanel) {
			Arrays.stream(((JPanel) comp).getComponents())
				.forEach((childComp)-> checkComponents(childComp, stringValues, enumValues));
		}
	}
}