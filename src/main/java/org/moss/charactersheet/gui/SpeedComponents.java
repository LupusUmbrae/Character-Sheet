package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.FullCharacter;

/**
 * Generator for speed etc
 * @author Jacq
 *
 */
public class SpeedComponents implements GenerateGui
{
	private static final Map<String, Component> ELEMENTS = new LinkedHashMap<>();
	
	static {
		ELEMENTS.put("Speed", new JTextField(30));
		ELEMENTS.put("Initiative", new JTextField(10));
	}
	
    /**
     * Creates new generator
     */
    public SpeedComponents()
    {
    }

    @Override
    public JPanel generate()
    {
    	List<Component> comps = new LinkedList<>();
        for (Entry<String, Component> elem : ELEMENTS.entrySet()) {
        	String compName = elem.getKey();
        	Component comp = elem.getValue();
        	JLabel label = new JLabel(compName);
        	comp.setName(compName);
        	comps.add(label);
        	comps.add(comp);
        }

        // [Speed] [Initiative]
        JPanel miniPanel = new JPanel(new GridBagLayout());
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
	public FullCharacter save() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

}
