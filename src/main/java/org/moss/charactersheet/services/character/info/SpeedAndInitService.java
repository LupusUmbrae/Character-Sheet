package org.moss.charactersheet.services.character.info;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.model.character.info.SpeedAndInitiativeStats;
import org.moss.charactersheet.services.SaveService;
import org.springframework.stereotype.Service;

/**
 * Service to provide save and load logic for {@link SpeedAndInitiativeStats}
 */
@Service
public class SpeedAndInitService implements SaveService<SpeedAndInitiativeStats> {
    public static final String SPEED = "Speed";
    public static final String INIT = "Initiative";

    @Override
    public SpeedAndInitiativeStats save(JPanel panel) {
        int speed = 0;
        int init = 0;

        for (Component comp : panel.getComponents()) {
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
