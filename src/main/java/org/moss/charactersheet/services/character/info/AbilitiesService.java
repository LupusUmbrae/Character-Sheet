package org.moss.charactersheet.services.character.info;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.model.character.info.AbilityStats;
import org.moss.charactersheet.services.SaveService;
import org.springframework.stereotype.Service;

/**
 * Service that provides save and load logic for character {@link AbilityStats}
 */
@Service
public class AbilitiesService implements SaveService<AbilityStats> {

    @Override
    public AbilityStats save(JPanel panel) {
        Map<String, Map<String, Integer>> skills = new HashMap<>();
        for (AbilityScore ability : AbilityScore.values()) {
            skills.put(ability.name(), new HashMap<>());
        }
        for (Component comp : panel.getComponents()) {
            String compName = comp.getName();
            if (compName == null || compName.isEmpty()) {
                continue;
            }
            if (comp instanceof JTextField) {
                String value = ((JTextField) comp).getText();
                int score = 0;
                if (value != null && !value.isEmpty()) {
                    score = Integer.parseInt(value);
                }
                String associatedAbility = compName.substring(0, 3);
                String modifier = compName.substring(3);
                skills.get(associatedAbility).put(modifier, score);
            }
        }
        return new AbilityStats(skills);
    }

    @Override
    public void load() {

    }
}
