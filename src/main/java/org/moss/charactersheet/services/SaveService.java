package org.moss.charactersheet.services;

import javax.swing.JPanel;

import org.moss.charactersheet.gui.CharInfoGui;
import org.moss.charactersheet.interfaces.Stats;

public interface SaveService<T extends Stats> {

    SaveService<T> withPanel(JPanel panel);

    /**
     * Saves information for later re-population of fields
     *
     * @return A sub set of the Character Stats for a given GUI, with the complete character formed by the
     * {@link CharInfoGui}
     */
    public T save();

    /**
     * Loads information from a getSaveService file and populates GUI
     */
    public void load();
}
