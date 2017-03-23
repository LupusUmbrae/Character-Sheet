package org.moss.charactersheet.gui;

import static org.moss.charactersheet.services.ArmourService.ARMOUR_BONUS;
import static org.moss.charactersheet.services.ArmourService.BASE;
import static org.moss.charactersheet.services.ArmourService.DEFLECT_MOD;
import static org.moss.charactersheet.services.ArmourService.DEX_MOD;
import static org.moss.charactersheet.services.ArmourService.FLAT_AC;
import static org.moss.charactersheet.services.ArmourService.MISC_MOD;
import static org.moss.charactersheet.services.ArmourService.NATURAL_ARMOUR;
import static org.moss.charactersheet.services.ArmourService.SHIELD_BONUS;
import static org.moss.charactersheet.services.ArmourService.SIZE_MOD;
import static org.moss.charactersheet.services.ArmourService.TOTAL;
import static org.moss.charactersheet.services.ArmourService.TOUCH_AC;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.ArmourClass;
import org.moss.charactersheet.impl.ArmourClassStats;
import org.moss.charactersheet.services.ArmourService;
import org.moss.charactersheet.util.LabelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generator for armour class
 */
@Component
public class AcGui implements GenerateGui<ArmourClassStats>  {
    private final JPanel armourClass = new JPanel(new GridBagLayout());

    @Autowired
    ArmourService armourService;

    @Override
    public JPanel generate()
    {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel name = new JLabel("AC");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(name, constraint);

        constraint.gridheight = 1;

        JTextField total = new JTextField(2);
        total.setEditable(false);
        total.setName(TOTAL);
        total.setText("0");
        constraint.gridx = 1;
        constraint.gridy = 0;
        armourClass.add(total, constraint);

        JLabel JLabelTotal = new JLabel("Total");
        JLabelTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 1;
        armourClass.add(JLabelTotal, constraint);

        JLabel JLabelEquals = new JLabel("  =  ");
        constraint.gridx = 2;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelEquals, constraint);

        constraint.gridheight = 1; // reset

        JTextField base = new JTextField(2);
        base.setText("10");
        base.setName(BASE);
        base.setEditable(false);
        constraint.gridx = 3;
        constraint.gridy = 0;
        armourClass.add(base, constraint);

        JLabel JLabelPlus1 = new JLabel("  +  ");
        constraint.gridx = 4;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus1, constraint);

        constraint.gridheight = 1;

        JFormattedTextField textArmour = new JFormattedTextField();
        textArmour.setName(ARMOUR_BONUS);
        constraint.gridx = 5;
        constraint.gridy = 0;
        armourClass.add(textArmour, constraint);

        JLabel JLabelArmour = new JLabel(LabelUtils.multiLine("Armour\nBonus", true));
        JLabelArmour.setFont(small);
        constraint.gridx = 5;
        constraint.gridy = 1;
        armourClass.add(JLabelArmour, constraint);

        JLabel JLabelPlus2 = new JLabel("  +  ");
        constraint.gridx = 6;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus2, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textShield = new JFormattedTextField();
        textShield.setName(SHIELD_BONUS);
        constraint.gridx = 7;
        constraint.gridy = 0;
        armourClass.add(textShield, constraint);

        JLabel labelShield = new JLabel(LabelUtils.multiLine("Shield\nBonus", true));
        labelShield.setFont(small);
        constraint.gridx = 7;
        constraint.gridy = 1;
        armourClass.add(labelShield, constraint);

        JLabel labelPlus3 = new JLabel("  +  ");
        constraint.gridx = 8;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(labelPlus3, constraint);

        constraint.gridheight = 1; // reset

        JTextField textDex = new JTextField(2);
        textDex.setEditable(false);
        textDex.setName(DEX_MOD);
        constraint.gridx = 9;
        constraint.gridy = 0;
        armourClass.add(textDex, constraint);

        JLabel labelDex = new JLabel(LabelUtils.multiLine("Dex\nModifier", true));
        labelDex.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 1;
        armourClass.add(labelDex, constraint);

        JLabel labelPlus4 = new JLabel("  +  ");
        constraint.gridx = 10;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(labelPlus4, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textSize = new JFormattedTextField();
        textSize.setName(SIZE_MOD);
        constraint.gridx = 11;
        constraint.gridy = 0;
        armourClass.add(textSize, constraint);

        JLabel labelSize = new JLabel(LabelUtils.multiLine("Size\nModifier", true));
        labelSize.setFont(small);
        constraint.gridx = 11;
        constraint.gridy = 1;
        armourClass.add(labelSize, constraint);

        JLabel JLabelPlus5 = new JLabel("  +  ");
        constraint.gridx = 12;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus5, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textNatural = new JFormattedTextField();
        textNatural.setName(NATURAL_ARMOUR);
        constraint.gridx = 13;
        constraint.gridy = 0;
        armourClass.add(textNatural, constraint);

        JLabel labelNatural = new JLabel(LabelUtils.multiLine("Natural\nArmour", true));
        labelNatural.setFont(small);
        constraint.gridx = 13;
        constraint.gridy = 1;
        armourClass.add(labelNatural, constraint);

        JLabel JLabelPlus6 = new JLabel("  +  ");
        constraint.gridx = 14;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus6, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textDeflection = new JFormattedTextField();
        textDeflection.setName(DEFLECT_MOD);
        constraint.gridx = 15;
        constraint.gridy = 0;
        armourClass.add(textDeflection, constraint);

        JLabel labelDeflection = new JLabel(LabelUtils.multiLine("Deflection\nModifier", true));
        labelDeflection.setFont(small);
        constraint.gridx = 15;
        constraint.gridy = 1;
        armourClass.add(labelDeflection, constraint);

        JLabel JLabelPlus7 = new JLabel("  +  ");
        constraint.gridx = 16;
        constraint.gridy = 0;
        constraint.gridheight = 2;
        armourClass.add(JLabelPlus7, constraint);

        constraint.gridheight = 1; // reset

        JFormattedTextField textMisc = new JFormattedTextField();
        textMisc.setName(MISC_MOD);
        constraint.gridx = 17;
        constraint.gridy = 0;
        armourClass.add(textMisc, constraint);

        JLabel labelMisc = new JLabel(LabelUtils.multiLine("Misc\nModifier", true));
        labelMisc.setFont(small);
        constraint.gridx = 17;
        constraint.gridy = 1;
        armourClass.add(labelMisc, constraint);

        JLabel labelTouch = new JLabel("Touch AC");
        labelMisc.setFont(small);
        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 3;
        armourClass.add(labelTouch, constraint);
        constraint.gridwidth = 1;

        JTextField textTouch = new JTextField(2);
        textTouch.setName(TOUCH_AC);
        textTouch.setEditable(false);
        constraint.gridx = 4;
        constraint.gridy = 2;
        armourClass.add(textTouch, constraint);

        JLabel labelFlat = new JLabel("Flat-Footed AC");
        constraint.gridx = 5;
        constraint.gridy = 2;
        constraint.gridwidth = 5;
        armourClass.add(labelFlat, constraint);
        constraint.gridwidth = 1;

        JTextField textFlat = new JTextField(2);
        textFlat.setName(FLAT_AC);
        textFlat.setEditable(false);
        constraint.gridx = 10;
        constraint.gridy = 2;
        armourClass.add(textFlat, constraint);

        new ArmourClass(total, textArmour, textShield, textDex, textSize, textNatural, textDeflection, textMisc,
                        textFlat, textTouch);

        return armourClass;
    }

	@Override
	public ArmourService getSaveService() {
        return armourService.withPanel(armourClass);
	}
}
