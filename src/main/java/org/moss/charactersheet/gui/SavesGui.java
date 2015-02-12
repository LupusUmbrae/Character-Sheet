package org.moss.charactersheet.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.Saves;
import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.util.LabelUtils;

/**
 * Generator for saves
 * @author Jacq
 *
 */
public class SavesGui implements GenerateGui
{
    private Map<Save, Saves> savingThrowsMap = new HashMap<>();

    /**
     * Creates new generator
     */
    public SavesGui()
    {
    }

    @Override
    public JPanel generate()
    {
        JPanel savingThrows = new JPanel(new GridBagLayout());
        savingThrows.setBorder(BorderFactory.createTitledBorder("Saving Throws"));

        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel labelTotal = new JLabel("Total");
        labelTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 0;
        savingThrows.add(labelTotal, constraint);

        JLabel labelBase = new JLabel(LabelUtils.multiLine("Base\nsave", true));
        labelBase.setFont(small);
        constraint.gridx = 3;
        constraint.gridy = 0;
        savingThrows.add(labelBase, constraint);

        JLabel labelAbility = new JLabel(LabelUtils.multiLine("Ability\nmodifier", true));
        labelAbility.setFont(small);
        constraint.gridx = 5;
        constraint.gridy = 0;
        savingThrows.add(labelAbility, constraint);

        JLabel labelMagic = new JLabel(LabelUtils.multiLine("Magic\nModifier", true));
        labelMagic.setFont(small);
        constraint.gridx = 7;
        constraint.gridy = 0;
        savingThrows.add(labelMagic, constraint);

        JLabel labelMisc = new JLabel(LabelUtils.multiLine("Misc\nModifier", true));
        labelMisc.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 0;
        savingThrows.add(labelMisc, constraint);

        JLabel labelTemp = new JLabel("Temp");
        labelTemp.setFont(small);
        constraint.gridx = 11;
        constraint.gridy = 0;
        savingThrows.add(labelTemp, constraint);

        JLabel labelConditional = new JLabel("Conditional Modifiers");
        constraint.gridx = 12;
        constraint.gridy = 0;
        savingThrows.add(labelConditional, constraint);

        JTextArea areaConditional = new JTextArea(6, 10);
        constraint.gridx = 12;
        constraint.gridy = 1;
        constraint.gridheight = 6;
        savingThrows.add(areaConditional, constraint);

        constraint.gridwidth = 1;
        constraint.gridheight = 1;

        for (int i = 0; i < Save.values().length; i++)
        {
            int index = (i * 2) + 1;

            JLabel labelSaveName = new JLabel(Save.values()[i].getSaveName());
            constraint.gridx = 0;
            constraint.gridy = index;
            savingThrows.add(labelSaveName, constraint);

            JLabel labelAbilityName = new JLabel(Save.values()[i].getAbility().getAbilityName());
            labelAbilityName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            savingThrows.add(labelAbilityName, constraint);

            constraint.gridheight = 2;

            JTextField textTotal = new JTextField(2);
            textTotal.setEditable(false);
            constraint.gridx = 1;
            constraint.gridy = index;
            savingThrows.add(textTotal, constraint);

            JLabel labelEquals = new JLabel("  =  ");
            constraint.gridx = 2;
            constraint.gridy = index;
            savingThrows.add(labelEquals, constraint);

            JFormattedTextField textBase = new JFormattedTextField();
            constraint.gridx = 3;
            constraint.gridy = index;
            savingThrows.add(textBase, constraint);

            JLabel labelPlus1 = new JLabel("  +  ");
            constraint.gridx = 4;
            constraint.gridy = index;
            savingThrows.add(labelPlus1, constraint);

            JTextField textAbility = new JTextField(2);
            textAbility.setEditable(false);
            constraint.gridx = 5;
            constraint.gridy = index;
            savingThrows.add(textAbility, constraint);

            JLabel labelPlus2 = new JLabel("  +  ");
            constraint.gridx = 6;
            constraint.gridy = index;
            savingThrows.add(labelPlus2, constraint);

            JFormattedTextField textMagic = new JFormattedTextField();
            constraint.gridx = 7;
            constraint.gridy = index;
            savingThrows.add(textMagic, constraint);

            JLabel labelPlus3 = new JLabel("  +  ");
            constraint.gridx = 8;
            constraint.gridy = index;
            savingThrows.add(labelPlus3, constraint);

            JFormattedTextField textMisc = new JFormattedTextField();
            constraint.gridx = 9;
            constraint.gridy = index;
            savingThrows.add(textMisc, constraint);

            JLabel labelPlus4 = new JLabel("  +  ");
            constraint.gridx = 10;
            constraint.gridy = index;
            savingThrows.add(labelPlus4, constraint);

            JFormattedTextField textTemp = new JFormattedTextField();
            constraint.gridx = 11;
            constraint.gridy = index;
            savingThrows.add(textTemp, constraint);

            constraint.gridheight = 1;

            savingThrowsMap.put(Save.values()[i], new Saves(Save.values()[i], textTotal, textBase, textAbility,
                                                            textMagic, textMisc, textTemp));
        }

        return savingThrows;
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
