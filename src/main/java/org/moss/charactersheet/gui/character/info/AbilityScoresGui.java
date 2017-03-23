package org.moss.charactersheet.gui.character.info;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.AbilityScores;
import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.model.character.info.AbilityStats;
import org.moss.charactersheet.services.character.info.AbilitiesService;
import org.moss.charactersheet.util.LabelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generator for ability scores
 */
@Component
public class AbilityScoresGui implements GenerateGui<AbilityStats>
{
    @Autowired
    AbilitiesService abilitiesService;
    private JPanel abilityScores;

    @PostConstruct
    public void setupPanel() {
    	this.abilityScores = new JPanel(new GridBagLayout());
    	this.abilityScores.setName("AbilityScores");
    	this.abilityScores.setBorder(BorderFactory.createTitledBorder("Ability Scores"));
    }
    
    @Override
    public JPanel generate()
    {
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        for (int i = 0; i < AbilityScore.values().length; i++)
        {
        	String abilitySN = AbilityScore.values()[i].name();
            int index = i * 2;
            JLabel name = new JLabel(abilitySN);
            constraint.gridx = 0;
            constraint.gridy = index;
            abilityScores.add(name, constraint);

            JLabel longName = new JLabel(AbilityScore.values()[i].getAbilityName());
            longName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            abilityScores.add(longName, constraint);

            JTextField total = new JTextField(2);
            total.setName(abilitySN + "Total");
            total.setEditable(false);
            total.setText("0");
            constraint.gridx = 1;
            constraint.gridy = index;
            abilityScores.add(total, constraint);

            JLabel JLabelTotal = new JLabel("Total");
            JLabelTotal.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelTotal, constraint);

            JLabel JLabelEquals = new JLabel("  =  ");
            constraint.gridx = 2;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelEquals, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField base = new JFormattedTextField();
            base.setName(abilitySN + "Base");
            constraint.gridx = 3;
            constraint.gridy = index;
            abilityScores.add(base, constraint);

            JLabel JLabelBase = new JLabel(LabelUtils.multiLine("Base Score +\nRacial Mod", true));
            JLabelBase.setFont(small);
            constraint.gridx = 3;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelBase, constraint);

            JLabel JLabelPlus1 = new JLabel("  +  ");
            constraint.gridx = 4;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus1, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField enhance = new JFormattedTextField();
            enhance.setName(abilitySN + "Enhance");
            constraint.gridx = 5;
            constraint.gridy = index;
            abilityScores.add(enhance, constraint);

            JLabel JLabelEnhance = new JLabel(LabelUtils.multiLine("Enhancement\nBonuses", true));
            JLabelEnhance.setFont(small);
            constraint.gridx = 5;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelEnhance, constraint);

            JLabel JLabelPlus2 = new JLabel("  +  ");
            constraint.gridx = 6;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus2, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField misc = new JFormattedTextField();
            misc.setName(abilitySN + "Misc");
            constraint.gridx = 7;
            constraint.gridy = index;
            abilityScores.add(misc, constraint);

            JLabel JLabelMisc = new JLabel(LabelUtils.multiLine("Misc\nBonuses", true));
            JLabelMisc.setFont(small);
            constraint.gridx = 7;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMisc, constraint);

            JLabel JLabelPlus3 = new JLabel("  -  ");
            constraint.gridx = 8;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus3, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField miscNeg = new JFormattedTextField();
            miscNeg.setName(abilitySN + "Penalty");
            constraint.gridx = 9;
            constraint.gridy = index;
            abilityScores.add(miscNeg, constraint);

            JLabel JLabelMiscNeg = new JLabel(LabelUtils.multiLine("Misc\nPenalties", true));
            JLabelMiscNeg.setFont(small);
            constraint.gridx = 9;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMiscNeg, constraint);

            JTextField mod = new JTextField(2);
            mod.setName(abilitySN + "Mod");
            mod.setEditable(false);
            mod.setText("0");
            constraint.gridx = 11;
            constraint.gridy = index;
            abilityScores.add(mod, constraint);

            JLabel JLabelMod = new JLabel("Mod");
            JLabelMod.setFont(small);
            constraint.gridx = 11;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMod, constraint);

            AbilityScores.getAbilityScores().put(AbilityScore.values()[i],
                                                 new AbilityScores(AbilityScore.values()[i], total, base, enhance,
                                                                   misc, miscNeg, mod));
        }
        return abilityScores;
    }

	@Override
	public AbilityStats save() {
        return abilitiesService.save(abilityScores);
	}
}
