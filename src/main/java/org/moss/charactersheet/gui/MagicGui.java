package org.moss.charactersheet.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.util.LabelUtils;

/**
 * Generates all things magical. Inludes:
 * <ul>
 * <li> Domain information </li>
 * <li> Spells </li>
 * <li> Spells per day </li>
 * <li> Saves </li>
 * <li> Modifiers </li>
 * </ul>
 * @author Jacq
 *
 */
public class MagicGui implements GenerateGui
{

    private Font small;
    private JPanel allMagic = new JPanel(new GridBagLayout());
    private GridBagConstraints consts = new GridBagConstraints();

    /**
     * Creates generator for all magic components
     */
    public MagicGui()
    {
        consts.insets = new Insets(0, 2, 2, 0);
        small = new Font("Verdana", Font.BOLD, 8);
    }

    /**
     * Generates magic screen
     */
    @Override
    public JPanel generate()
    {
        generateMagicBox();
        generateSpellBox();
        generateSpellList();
        return allMagic;
    }

    private void generateSpellList()
    {
        JPanel spellListPanel = new JPanel();
        GridBagLayout spellListLayout = new GridBagLayout();
        GridBagConstraints spellListConstraints = new GridBagConstraints();

        spellListPanel.setBorder(BorderFactory.createTitledBorder("Spell List"));
        spellListPanel.setLayout(spellListLayout);

        JLabel labelSpells = new JLabel("Bobby");
        spellListConstraints.gridx = 0;
        spellListConstraints.gridy = 0;
        spellListPanel.add(labelSpells, spellListConstraints);
        
        consts.gridx = 1;
        consts.gridy = 0;
        allMagic.add(spellListPanel, consts);
    }

    private void generateSpellBox()
    {
        /*
         * Spell block
         */
        JPanel spellsPanel = new JPanel();
        GridBagLayout spellsLayout = new GridBagLayout();
        GridBagConstraints spellConstraints = new GridBagConstraints();

        spellsPanel.setBorder(BorderFactory.createTitledBorder("Spells"));
        spellsPanel.setLayout(spellsLayout);

        spellConstraints.insets = new Insets(0, 0, 4, 2);

        JLabel labelSpellSave = new JLabel("Spell Save");
        spellConstraints.gridx = 0;
        spellConstraints.gridy = 0;
        spellConstraints.gridwidth = 2;
        spellsPanel.add(labelSpellSave, spellConstraints);

        JTextField textSpellSave = new JTextField(8);
        spellConstraints.gridx = 2;
        spellConstraints.gridy = 0;
        spellConstraints.gridwidth = 3;
        spellsPanel.add(textSpellSave, spellConstraints);

        JLabel labelDcMod = new JLabel(LabelUtils.multiLine("DC\nMOD", true));
        labelDcMod.setFont(small);
        spellConstraints.gridx = 2;
        spellConstraints.gridy = 0;
        spellsPanel.add(labelDcMod, spellConstraints);

        JTextArea areaConditionalModifiers = new JTextArea(3, 24);
        areaConditionalModifiers.setBorder(BorderFactory.createTitledBorder("Conditional Mods"));
        spellConstraints.gridx = 0;
        spellConstraints.gridy = 1;
        spellConstraints.gridwidth = 11;
        spellsPanel.add(areaConditionalModifiers, spellConstraints);

        int xPos;
        int index;
        int level;
        spellConstraints.gridwidth = 1;
        JPanel panelDailySpells = new JPanel(new GridBagLayout());

        spellConstraints.gridx = 0;
        spellConstraints.gridy = 2;
        spellConstraints.gridwidth = 11;
        spellsPanel.add(panelDailySpells, spellConstraints);

        GridBagConstraints dailySpellConstraints = new GridBagConstraints();
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                xPos = i * 5;
                index = j;
                level = j;
                if (i > 0)
                {
                    level += 5;
                }

                JTextField textSpellsKnown = new JTextField(2);
                dailySpellConstraints.gridx = xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsKnown, dailySpellConstraints);

                JTextField textSpellsSaveDc = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsSaveDc, dailySpellConstraints);

                JLabel labelLevel = new JLabel(Integer.toString(level));
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(labelLevel, dailySpellConstraints);

                JTextField textSpellsDay = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsDay, dailySpellConstraints);

                if (i == 0)
                {
                    dailySpellConstraints.insets = new Insets(0, 0, 0, 30);
                }

                JTextField textSpellsBonus = new JTextField(2);
                dailySpellConstraints.gridx = ++xPos;
                dailySpellConstraints.gridy = index;
                panelDailySpells.add(textSpellsBonus, dailySpellConstraints);

                dailySpellConstraints.insets = new Insets(0, 0, 0, 0);
            }
        }
        consts.gridy = 1;
        allMagic.add(spellsPanel, consts);
    }

    private void generateMagicBox()
    {
        /*
         * Magic box
         */
        JPanel magicPanel = new JPanel();
        GridBagLayout magicLayout = new GridBagLayout();
        GridBagConstraints magicConstraints = new GridBagConstraints();

        magicPanel.setBorder(BorderFactory.createTitledBorder("Magic"));
        magicPanel.setLayout(magicLayout);
        magicConstraints.anchor = GridBagConstraints.WEST;

        JLabel labelDomains = new JLabel("Domains (Cleric Only)");
        labelDomains.setHorizontalAlignment(SwingConstants.LEFT);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 0;
        magicConstraints.gridwidth = 3;
        magicPanel.add(labelDomains, magicConstraints);

        magicConstraints.gridwidth = 1;

        int index;
        for (int i = 0; i < 2; i++)
        {
            index = i * 2 + 1;
            JTextField textDomain1 = new JTextField(8);
            magicConstraints.gridx = 0;
            magicConstraints.gridy = index;
            magicPanel.add(textDomain1, magicConstraints);

            JTextField textGrantedPower1 = new JTextField(16);
            magicConstraints.gridx = 1;
            magicConstraints.gridy = index;
            magicConstraints.gridwidth = 2;
            magicPanel.add(textGrantedPower1, magicConstraints);

            magicConstraints.gridwidth = 1;

            JLabel labelDomain = new JLabel("Domain Name");
            labelDomain.setFont(small);
            magicConstraints.gridx = 0;
            magicConstraints.gridy = index + 1;
            magicPanel.add(labelDomain, magicConstraints);

            JLabel labelGranted = new JLabel("Domain Name");
            labelGranted.setFont(small);
            magicConstraints.gridx = 1;
            magicConstraints.gridy = index + 1;
            magicPanel.add(labelGranted, magicConstraints);
        }

        JLabel labelSchoolTitle = new JLabel("Speciality School (Wizards Only)");
        labelSchoolTitle.setHorizontalAlignment(SwingConstants.LEFT);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 6;
        magicConstraints.gridwidth = 3;
        magicPanel.add(labelSchoolTitle, magicConstraints);

        magicConstraints.gridwidth = 1;

        JTextField textSchool = new JTextField(8);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 7;
        magicPanel.add(textSchool, magicConstraints);

        JTextField textProhibited1 = new JTextField(8);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 7;
        magicPanel.add(textProhibited1, magicConstraints);

        JTextField textProhibited2 = new JTextField(8);
        magicConstraints.gridx = 2;
        magicConstraints.gridy = 7;
        magicPanel.add(textProhibited2, magicConstraints);

        JLabel labelSchool = new JLabel("Speciality School");
        labelSchool.setFont(small);
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 8;
        magicPanel.add(labelSchool, magicConstraints);

        JLabel labelProhibited1 = new JLabel("Prohibited School");
        labelProhibited1.setFont(small);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 8;
        magicPanel.add(labelProhibited1, magicConstraints);

        JLabel labelProhibited2 = new JLabel("Prohibited School");
        labelProhibited2.setFont(small);
        magicConstraints.gridx = 2;
        magicConstraints.gridy = 8;
        magicPanel.add(labelProhibited2, magicConstraints);

        JLabel labelSpellFailure = new JLabel("Arcane Spell Failure");
        magicConstraints.gridx = 0;
        magicConstraints.gridy = 9;
        magicPanel.add(labelSpellFailure, magicConstraints);

        JTextField textSpellFailure = new JTextField(16);
        magicConstraints.gridx = 1;
        magicConstraints.gridy = 9;
        magicConstraints.gridwidth = 2;
        magicPanel.add(textSpellFailure, magicConstraints);
        
        allMagic.add(magicPanel);
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
