package org.moss.charactersheet.actions;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.CharacterInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** Loads character information from JSON .sav file */
public class LoadCharacter {

	private static CharacterInfo CHAR_INFO;
	private final File saveFile;
	
	public LoadCharacter(File saveFile) {
		this.saveFile = saveFile;
	}
	
	public void load(List<Component> components) throws FileNotFoundException {
		FileReader fr = new FileReader(saveFile);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		CHAR_INFO = gson.fromJson(fr, CharacterInfo.class);
		for (Component curComp : components) {
			if (curComp instanceof JPanel) {
				JPanel panel = (JPanel) curComp;
				checkComponents(panel);
			}
		}
	}

	private static void checkComponents(JPanel panel) {
		for (Component comp : panel.getComponents()) {
			if (comp instanceof JPanel) {
				checkComponents((JPanel) comp);
			}
			if (comp instanceof JTextField) {
				populateStringField((JTextField) comp);
			} else if (comp instanceof JComboBox<?>) {
				populateEnumField((JComboBox<?>) comp);
			}
		}		
	}

	private static void populateEnumField(JComboBox<?> comp) {
		String compName = comp.getName();
		if (compName.equals("Gender")) {
			comp.setSelectedItem(CHAR_INFO.getGender());
		} else if (compName.equals("Size")) {
			comp.setSelectedItem(CHAR_INFO.getSize());
		} else if (compName.equals("Alignment")) {
			comp.setSelectedItem(CHAR_INFO.getAlignment());
		}
	}

	private static void populateStringField(JTextField comp) {
		String compName = comp.getName();
		if (compName == null) {
			return;
		}
		if (compName.equals("Character Name")) {
			comp.setText(CHAR_INFO.getCharacterName());
		} else if (compName.equals("Player Name")) {
			comp.setText(CHAR_INFO.getPlayerName());
		} else if (compName.equals("Class")) {
			comp.setText(CHAR_INFO.getClazz());
		} else if (compName.equals("Race")) {
			comp.setText(CHAR_INFO.getRace());
		} else if (compName.equals("Religion")) {
			comp.setText(CHAR_INFO.getReligion());
		} else if (compName.equals("Looks")) {
			comp.setText(CHAR_INFO.getLooks());
		} else if (compName.equals("Height")) {
			comp.setText(Integer.toString(CHAR_INFO.getHeight()));
		} else if (compName.equals("Weight")) {
			comp.setText(Integer.toString(CHAR_INFO.getWeight()));
		} else if (compName.equals("Level")) {
			comp.setText(Integer.toString(CHAR_INFO.getLevel()));
		} else if (compName.equals("ECL")) {
			comp.setText(Integer.toString(CHAR_INFO.getEcl()));
		}
	}
}