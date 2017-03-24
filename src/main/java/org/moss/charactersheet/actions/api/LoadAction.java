package org.moss.charactersheet.actions.api;

import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.moss.charactersheet.actions.LoadCharacter;

/** API Class for Character Sheet. Loads a previous character save file */
public class LoadAction {

	/**
	 * Loads file from disk and populates given components
	 * @param container
	 * @param components
	 */
	public static void load(Container container, List<Component> components) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new CustomFileFilter());
		if (fileChooser.showOpenDialog(container) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			LoadCharacter action = new LoadCharacter(file);
			try {
				action.load(components);
				JOptionPane.showMessageDialog(
						container, "Load Successful", "Load Complete", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception xcp) {
				JOptionPane.showMessageDialog(
						container, xcp.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

}
