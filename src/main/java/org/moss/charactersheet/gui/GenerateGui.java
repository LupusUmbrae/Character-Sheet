package org.moss.charactersheet.gui;

import javax.swing.JPanel;

import org.moss.charactersheet.gui.character.info.CharInfoGui;
import org.moss.charactersheet.model.Stats;

public interface GenerateGui<T extends Stats>
{
	/**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @return JPanel
     */
    public JPanel generate();

    /**
     * Saves information for later re-population of fields
     * @return A sub set of the Character Stats for a given GUI, with the complete character formed by the
     * {@link CharInfoGui}
     */
    public T save();
}