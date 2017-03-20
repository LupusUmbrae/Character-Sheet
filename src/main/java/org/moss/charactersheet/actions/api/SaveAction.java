package org.moss.charactersheet.actions.api;

import java.awt.Container;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.moss.charactersheet.actions.SaveCharacter;
import org.moss.charactersheet.gui.GenerateGui;

/** API Class for use by CharacterSheet. Saves current for to save file */
public class SaveAction {

	public static void save(Container container, List<GenerateGui> generators) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new CustomFileFilter());
		if (fileChooser.showSaveDialog(container) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			SaveCharacter action = new SaveCharacter(file);
			try {
				action.save(generators);
				JOptionPane.showMessageDialog(
						container, "Save Successful", "Save Complete", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception xcp) {
				JOptionPane.showMessageDialog(
						container, xcp.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}
}
