package org.moss.charactersheet.util;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTextField;

public final class StatsHelper {
    public static Map<String, Integer> extractStatsFromPanel(JPanel statsPanel) {
        Map<String, Integer> stats = new HashMap<>();
        for (Component comp : statsPanel.getComponents()) {
            if (comp instanceof JTextField) {
                String compName = comp.getName();
                String value = ((JTextField) comp).getText();
                int score = 0;
                if (value != null && !value.isEmpty()) {
                    score = Integer.parseInt(value);
                }
                stats.put(compName, score);
            }
        }
        return stats;
    }
}
