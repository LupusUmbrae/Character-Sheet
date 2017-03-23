package org.moss.charactersheet.services;

import javax.swing.JPanel;

import org.moss.charactersheet.gui.character.info.CharInfoGui;
import org.moss.charactersheet.model.Stats;

public interface SaveService<T extends Stats> {

    /**
     * Saves information for later re-population of fields
     *
     * @return A sub set of the Character Stats for a given GUI, with the complete character formed by the
     * {@link CharInfoGui}
     * @param panel
     */
    public T save(JPanel panel);

    /**
     * Loads information from a save file and populates GUI
     */
    public void load();
}
