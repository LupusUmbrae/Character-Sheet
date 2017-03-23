package org.moss.charactersheet.services;

import java.awt.Component;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.CombatStats;
import org.springframework.stereotype.Service;

/**
 * Service that provides save and load logic for character {@link CombatStats}
 */
@Service
public class CombatService implements SaveService<CombatStats> {

    private JPanel combatPanel;
    public static final String BASE_ATTACK = "BaseAttack";

    @Override
    public CombatService withPanel(JPanel panel) {
        this.combatPanel = panel;
        return this;
    }

    @Override
    public CombatStats save() {
        int baseAttackBonus = 0;
        Map<Integer, Map<String, String>> combatSkills = new LinkedHashMap<>();
        for (Component comp : combatPanel.getComponents()) {
            String compName = comp.getName();
            if (compName == null || compName.isEmpty()) {
                continue;
            }
            String value = null;
            if (comp instanceof JTextField) {
                value = ((JTextField) comp).getText();
            }
            if (compName.equalsIgnoreCase(BASE_ATTACK)) {
                baseAttackBonus = Integer.parseInt(value);
            } else {
                String weaponNum = compName.substring(compName.length() - 1);
                String weaponAttr = compName.substring(0, compName.length() - 1);
                int combatIteration = Integer.parseInt(weaponNum);
                Map<String, String> currentEntry = combatSkills.get(combatIteration);
                if (currentEntry == null) {
                    currentEntry = new HashMap<>();
                }
                currentEntry.put(weaponAttr, value);
                combatSkills.put(combatIteration, currentEntry);
            }
        }
        return new CombatStats(baseAttackBonus, combatSkills);
    }

    @Override
    public void load() {

    }
}
