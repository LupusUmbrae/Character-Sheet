package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.Grapple;
import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.impl.GrappleStats;
import org.moss.charactersheet.util.LabelUtils;

/**
 * Generator for grapple
 * @author Jacq
 *
 */
public class GrappleGui implements GenerateGui
{
	private JPanel grapple;
	private static final String BAB = "BAB";
	private static final String TOTAL = "Total";
	private static final String SIZE = "Size Mod";
	private static final String STR = "Strength Mod";
	private static final String MISC = "Misc Mod";
	
    /**
     * Creates new generator
     */
    public GrappleGui()
    {
    	this.grapple = new JPanel(new GridBagLayout());
    }

    @Override
    public JPanel generate()
    {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel name = new JLabel("Grapple");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        grapple.add(name, constraint);

        constraint.gridheight = 1;

        JTextField total = new JTextField(2);
        total.setName(TOTAL);
        total.setEditable(false);
        total.setText("0");
        constraint.gridx = 1;
        constraint.gridy = 0;
        grapple.add(total, constraint);

        JLabel JLabelTotal = new JLabel("Total");
        JLabelTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 1;
        grapple.add(JLabelTotal, constraint);

        JLabel JLabelEquals = new JLabel("  |  ");
        constraint.gridx = 2;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        grapple.add(JLabelEquals, constraint);

        constraint.gridheight = 1; // reset

        JTextField base = new JTextField(2);
        base.setName(BAB);
        base.setEditable(false);
        constraint.gridx = 3;
        constraint.gridy = 0;
        grapple.add(base, constraint);

        JLabel JLabelBase = new JLabel(LabelUtils.multiLine("Base Attack\nBonus", true));
        JLabelBase.setFont(small);
        constraint.gridx = 3;
        constraint.gridy = 1;
        grapple.add(JLabelBase, constraint);

        JLabel JLabelPlus1 = new JLabel("  |  ");
        constraint.gridx = 4;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        grapple.add(JLabelPlus1, constraint);

        constraint.gridheight = 1; // reset

        JTextField strength = new JTextField(2);
        strength.setName(STR);
        strength.setEditable(false);
        constraint.gridx = 5;
        constraint.gridy = 0;
        grapple.add(strength, constraint);

        JLabel JLabelEnchance = new JLabel(LabelUtils.multiLine("Strength\nModifier", true));
        JLabelEnchance.setFont(small);
        constraint.gridx = 5;
        constraint.gridy = 1;
        grapple.add(JLabelEnchance, constraint);

        JLabel JLabelPlus2 = new JLabel("  |  ");
        constraint.gridx = 6;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        grapple.add(JLabelPlus2, constraint);

        constraint.gridheight = 1; // reset

        JTextField size = new JTextField(2);
        size.setName(SIZE);
        size.setEditable(false);
        constraint.gridx = 7;
        constraint.gridy = 0;
        grapple.add(size, constraint);

        JLabel JLabelMisc = new JLabel(LabelUtils.multiLine("Size\nmodifier", true));
        JLabelMisc.setFont(small);
        constraint.gridx = 7;
        constraint.gridy = 1;
        grapple.add(JLabelMisc, constraint);

        JLabel JLabelPlus3 = new JLabel("  |  ");
        constraint.gridx = 8;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        grapple.add(JLabelPlus3, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField misc = new JFormattedTextField();
        misc.setName(MISC);
        constraint.gridx = 9;
        constraint.gridy = 0;
        grapple.add(misc, constraint);

        JLabel JLabelMiscNeg = new JLabel(LabelUtils.multiLine("Misc\nmodifier", true));
        JLabelMiscNeg.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 1;
        grapple.add(JLabelMiscNeg, constraint);

        new Grapple(total, base, strength, size, misc);

        return grapple;
    }

	@Override
	public FullCharacter save() {
		Map<String, Integer> skills = new HashMap<>();
		for (Component comp : grapple.getComponents()) {
			if (comp instanceof JTextField) {
				String compName =  comp.getName();
				String value = ((JTextField) comp).getText();
				int score = 0;
				if (value != null && !value.isEmpty()) {
					score = Integer.parseInt(value);
				}
				skills.put(compName, score);
			}
		}
		GrappleStats stats = new GrappleStats(skills.get(TOTAL),
				                              skills.get(BAB),
				                              skills.get(STR),
				                              skills.get(SIZE),
				                              skills.get(MISC));
		return new FullCharacter(null, null, null, null, stats, null, null);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
