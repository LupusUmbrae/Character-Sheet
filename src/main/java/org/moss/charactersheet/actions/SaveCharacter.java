package org.moss.charactersheet.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.moss.charactersheet.actions.api.CustomFileFilter;
import org.moss.charactersheet.actions.api.SaveAction;
import org.moss.charactersheet.actions.exceptions.SaveActionException;
import org.moss.charactersheet.gui.CharInfoGui;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.interfaces.Stats;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

/** Saves character in JSON format */
@Slf4j
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
	 * Saves a character to .sav in JSON format by combining the information from the different screens as provided
	 *
	 * @param generators
	 */
	public void save(List<GenerateGui> generators) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(saveLocation));
			for (GenerateGui gui : generators) {
				if (gui instanceof CharInfoGui) {
					this.save(writer, gui.save());
				}
			}
		} catch (IOException e) {
			log.error("Unable to save. Cause: " + e.getMessage());
			throw new SaveActionException("There was a problem when attempting to save the character to file");
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException x) {
					log.error("Unable to close writer. Cause: " + x.getMessage());
					throw new SaveActionException("An issue occurred when trying to finalise the file. The " +
							"character may not have been save correctly.");
				}
			}
		}
	}

	private void save(BufferedWriter writer, Stats character) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String info = gson.toJson(character, character.getClass());
		writer.append(info);
	}
	
	public File getSaveLocation() {
		return saveLocation;
	}
}
