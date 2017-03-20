package org.moss.charactersheet.gui;

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

import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.impl.SpeedAndInitiative;
import org.moss.charactersheet.interfaces.Stats;

/**
 * Generator for speed etc
 * @author Jacq
 *
 */
public class SpeedComponents implements GenerateGui<SpeedAndInitiative> {
	private static final Map<String, JTextField> ELEMENTS = new LinkedHashMap<>();
	private JPanel miniPanel;
	
	static {
		ELEMENTS.put("Speed", new JTextField(30));
		ELEMENTS.put("Initiative", new JTextField(10));
	}
	
    /**
     * Creates new generator
     */
    public SpeedComponents()
    {
    	this.miniPanel = new JPanel(new GridBagLayout());
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
	public SpeedAndInitiative save() {
		JTextField speedField = ELEMENTS.get("Speed");
		int speed = Integer.parseInt(speedField.getText());
		
		JTextField initField = ELEMENTS.get("Initiative");
		int initiative = Integer.parseInt(initField.getText());
		
		return new SpeedAndInitiative(speed, initiative);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
