package org.moss.charactersheet.gui.character.info;

import static org.moss.charactersheet.services.character.info.SpeedAndInitService.INIT;
import static org.moss.charactersheet.services.character.info.SpeedAndInitService.SPEED;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.model.character.info.SpeedAndInitiativeStats;
import org.moss.charactersheet.services.character.info.SpeedAndInitService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generator for speed etc
 */
@org.springframework.stereotype.Component
public class SpeedComponentsGui implements GenerateGui<SpeedAndInitiativeStats> {
	private static final Map<String, JTextField> ELEMENTS = new LinkedHashMap<>();
	private final JPanel miniPanel = new JPanel(new GridBagLayout());

	@Autowired
	SpeedAndInitService speedService;

	static {
		ELEMENTS.put(SPEED, new JTextField(30));
		ELEMENTS.put(INIT, new JTextField(10));
	}

    @Override
    public JPanel generate()
    {
    	List<Component> comps = new LinkedList<>();
        for (Entry<String, JTextField> elem : ELEMENTS.entrySet()) {
        	String compName = elem.getKey();
        	JTextField comp = elem.getValue();
        	JLabel label = new JLabel(compName);
        	comp.setName(compName);
        	comps.add(label);
        	comps.add(comp);
        }

        // [Speed] [Initiative]
        GridBagConstraints consts = new GridBagConstraints();
        consts.gridx = 0;
        consts.gridy = 0;
        for (Component comp : comps) {
        	if (consts.gridy != 0 && consts.gridy % 2 == 0) {
        		consts.gridx++;
        		consts.gridy = 0;
        	}
        	miniPanel.add(comp, consts);
        	consts.gridy++;
        }
        
        return miniPanel;
    }

	@Override
	public SpeedAndInitiativeStats save() {
		return speedService.save(miniPanel);
	}
}
