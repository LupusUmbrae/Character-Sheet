package org.moss.charactersheet.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.moss.charactersheet.actions.api.CustomFileFilter;
import org.moss.charactersheet.gui.CharInfoGui;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.impl.CharacterInfo;
import org.moss.charactersheet.impl.FullCharacter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Saves character in JSON format
 * @author Jacq
 *
 */
public class SaveCharacter {

	private File saveLocation;
	private final String fileExt = CustomFileFilter.getFileExtension();
	
	public SaveCharacter(File file) {
		if (!file.getPath().toLowerCase().endsWith(".sav")) {
			file = new File(file.getPath() + fileExt);
		}
		this.saveLocation = file;
	}
	
	/**
	 * Saves a character to .sav in JSON format
	 * @param character
	 */
	public void save(FullCharacter character) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(saveLocation));
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String info = gson.toJson(character, character.getClass());
			writer.write(info);
		} catch (IOException e) {
			System.out.println("Unable to save. Cause: " + e.getMessage());
		}
		finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException x) {
					System.out.println("Unable to close writer. Cause: " + x.getMessage());
				}
			}
		}
	}
	
	public File getSaveLocation() {
		return saveLocation;
	}

	public void save(List<GenerateGui> generators) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
//		FullCharacter character = new FullCharacter();
//		for (GenerateGui gui : generators) {
//			FullCharacter saveObject = gui.save();
//			String className = saveObject.getClass().getName();
//			for (Field field : FullCharacter.class.getDeclaredFields()) {
//				if (className.equalsIgnoreCase(field.getName())) {
//					field.setAccessible(true);
//					field.set(character, saveObject);
//					break;
//				}
//			}
//		}
		for (GenerateGui gui : generators) {
			if (gui instanceof CharInfoGui) {
				this.save(gui.save());
			}
		}
	}
}
