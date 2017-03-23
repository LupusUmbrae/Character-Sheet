package org.moss.charactersheet.gui;

import static org.moss.charactersheet.services.GrappleService.BAB;
import static org.moss.charactersheet.services.GrappleService.MISC;
import static org.moss.charactersheet.services.GrappleService.SIZE;
import static org.moss.charactersheet.services.GrappleService.STR;
import static org.moss.charactersheet.services.GrappleService.TOTAL;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.Grapple;
import org.moss.charactersheet.impl.GrappleStats;
import org.moss.charactersheet.services.GrappleService;
import org.moss.charactersheet.util.LabelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generator for grapple
 */
@Component
public class GrappleGui implements GenerateGui<GrappleStats> {
	private final JPanel grapple = new JPanel(new GridBagLayout());

	@Autowired
    GrappleService grappleService;

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
	public GrappleService getSaveService() {
        return grappleService.withPanel(grapple);
	}
}
