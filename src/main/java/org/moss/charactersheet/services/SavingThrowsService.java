package org.moss.charactersheet.services;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.impl.SaveStats;
import org.springframework.stereotype.Service;

/**
 * Service that provides save and load logic for character saving throws ({@link SaveStats})
 */
@Service
public class SavingThrowsService implements SaveService<SaveStats> {
    private JPanel savingThrowsPanel;

    @Override
    public SavingThrowsService withPanel(JPanel panel) {
        this.savingThrowsPanel = panel;
        return this;
    }

    @Override
    public SaveStats save() {
        Map<String, Map<String, Integer>> skills = new HashMap<>();
        for (Save save : Save.values()) {
            String saveName = save.getSaveName();
            skills.put(saveName, new HashMap<>());
        }
        String conMods = "";
        for (Component comp : savingThrowsPanel.getComponents()) {
            if (comp instanceof JTextField) {
                String compName = comp.getName();
                String[] parts = compName.split(" ");
                String saveName = parts[0];
                String modifier = parts[1];
                String value = ((JTextField) comp).getText();
                int score = 0;
                if (value != null && !value.isEmpty()) {
                    score = Integer.parseInt(value);
                }
                skills.get(saveName).put(modifier, score);
            } else if (comp instanceof JTextArea) {
                conMods = ((JTextArea) comp).getText();
            }
        }
        return new SaveStats(conMods, skills);
    }

    @Override
    public void load() {

    }
}
