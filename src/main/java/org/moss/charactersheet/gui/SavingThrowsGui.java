package org.moss.charactersheet.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.Saves;
import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.impl.SaveStats;
import org.moss.charactersheet.services.SavingThrowsService;
import org.moss.charactersheet.util.LabelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generator for saving throws
 */
@Component
public class SavingThrowsGui implements GenerateGui<SaveStats> {
    private static final String CONDITIONAL = "Con Mods";
	private Map<Save, Saves> savingThrowsMap = new HashMap<>();
    private JPanel savingThrows;

    @Autowired
    SavingThrowsService savingThrowsService;

    @PostConstruct
    public void setupPanel() {
    	this.savingThrows = new JPanel(new GridBagLayout());
    	this.savingThrows.setBorder(BorderFactory.createTitledBorder("Saving Throws"));
    }

    @Override
    public JPanel generate()
    {
        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel labelTotal = new JLabel("Total");
        labelTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 0;
        savingThrows.add(labelTotal, constraint);

        JLabel labelBase = new JLabel(LabelUtils.multiLine("Base\ngetSaveService", true));
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
        areaConditional.setName(CONDITIONAL);
        constraint.gridx = 12;
        constraint.gridy = 1;
        constraint.gridheight = 6;
        savingThrows.add(areaConditional, constraint);

        constraint.gridwidth = 1;
        constraint.gridheight = 1;

        for (int i = 0; i < Save.values().length; i++)
        {
        	Save save = Save.values()[i];
        	String saveName = save.getSaveName();
        	
            int index = (i * 2) + 1;

            JLabel labelSaveName = new JLabel(saveName);
            constraint.gridx = 0;
            constraint.gridy = index;
            savingThrows.add(labelSaveName, constraint);

            JLabel labelAbilityName = new JLabel(save.getAbility().getAbilityName());
            labelAbilityName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            savingThrows.add(labelAbilityName, constraint);

            constraint.gridheight = 2;

            JTextField textTotal = new JTextField(2);
            textTotal.setName(saveName + " Total");
            textTotal.setEditable(false);
            constraint.gridx = 1;
            constraint.gridy = index;
            savingThrows.add(textTotal, constraint);

            JLabel labelEquals = new JLabel("  =  ");
            constraint.gridx = 2;
            constraint.gridy = index;
            savingThrows.add(labelEquals, constraint);

            JFormattedTextField textBase = new JFormattedTextField();
            textBase.setName(saveName + " Base");
            constraint.gridx = 3;
            constraint.gridy = index;
            savingThrows.add(textBase, constraint);

            JLabel labelPlus1 = new JLabel("  +  ");
            constraint.gridx = 4;
            constraint.gridy = index;
            savingThrows.add(labelPlus1, constraint);

            JTextField textAbility = new JTextField(2);
            textAbility.setName(saveName + " Ability");
            textAbility.setEditable(false);
            constraint.gridx = 5;
            constraint.gridy = index;
            savingThrows.add(textAbility, constraint);

            JLabel labelPlus2 = new JLabel("  +  ");
            constraint.gridx = 6;
            constraint.gridy = index;
            savingThrows.add(labelPlus2, constraint);

            JFormattedTextField textMagic = new JFormattedTextField();
            textMagic.setName(saveName + " Magic");
            constraint.gridx = 7;
            constraint.gridy = index;
            savingThrows.add(textMagic, constraint);

            JLabel labelPlus3 = new JLabel("  +  ");
            constraint.gridx = 8;
            constraint.gridy = index;
            savingThrows.add(labelPlus3, constraint);

            JFormattedTextField textMisc = new JFormattedTextField();
            textMisc.setName(saveName + " Misc");
            constraint.gridx = 9;
            constraint.gridy = index;
            savingThrows.add(textMisc, constraint);

            JLabel labelPlus4 = new JLabel("  +  ");
            constraint.gridx = 10;
            constraint.gridy = index;
            savingThrows.add(labelPlus4, constraint);

            JFormattedTextField textTemp = new JFormattedTextField();
            textTemp.setName(saveName + " Temp");
            constraint.gridx = 11;
            constraint.gridy = index;
            savingThrows.add(textTemp, constraint);

            constraint.gridheight = 1;

            savingThrowsMap.put(save, new Saves(save, textTotal, textBase, textAbility,
                                                textMagic, textMisc, textTemp));
        }

        return savingThrows;
    }

	@Override
	public SavingThrowsService getSaveService() {
        return savingThrowsService.withPanel(savingThrows);
	}
}
