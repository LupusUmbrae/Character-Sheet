package org.moss.charactersheet.services;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.SpeedAndInitiativeStats;
import org.springframework.stereotype.Service;

/**
 * Service to provide save and load logic for {@link SpeedAndInitiativeStats}
 */
@Service
public class SpeedAndInitService implements SaveService<SpeedAndInitiativeStats> {

    private JPanel speedPanel;
    public static final String SPEED = "Speed";
    public static final String INIT = "Initiative";

    @Override
    public SpeedAndInitService withPanel(JPanel panel) {
        this.speedPanel = panel;
        return this;
    }

    @Override
    public SpeedAndInitiativeStats save() {
        int speed = 0;
        int init = 0;

        for (Component comp : speedPanel.getComponents()) {
            if (comp instanceof JTextField) {
                JTextField textComp = (JTextField) comp;
                String textFieldName = textComp.getName();
                String textFieldValue = textComp.getText();
                if (SPEED.equals(textFieldName)) {
                    speed = Integer.parseInt(textFieldValue);
                } else if (INIT.equals(textFieldName)) {
                    init = Integer.parseInt(textFieldValue);
                }
            }
        }
        return new SpeedAndInitiativeStats(speed, init);
    }

    @Override
    public void load() {

    }
}
