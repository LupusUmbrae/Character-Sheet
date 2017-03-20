package org.moss.charactersheet.gui;

import javax.swing.JPanel;

import org.moss.charactersheet.impl.FullCharacter;

public interface GenerateGui
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
     * @return <code>Character</code>
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    public FullCharacter save() throws IllegalAccessException, NoSuchFieldException;
    
    /** Loads information from a save file and populates GUI */
    public void load();
}