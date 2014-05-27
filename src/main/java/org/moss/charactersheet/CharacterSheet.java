package org.moss.charactersheet;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.aspects.AbilityScores;
import org.moss.charactersheet.aspects.Grapple;
import org.moss.charactersheet.aspects.Saves;
import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.util.LabelUtils;

import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SpringLayout.WEST;


public class CharacterSheet extends JFrame
{

    private static final int LINE_HEIGHT = 25;

    private Map<AbilityScore, AbilityScores> abilityScores = new HashMap<>();

    private Map<Save, Saves> savingThrowsMap = new HashMap<>();

    private List<Component> guiComponenets = new ArrayList<Component>();
    private SpringLayout layout;
    private Container contentPane;


    public CharacterSheet()
    {
        init();
    }

    private void init()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Sheet");

        layout = new SpringLayout();
        contentPane = this.getContentPane();
        contentPane.setLayout(layout);
        this.getContentPane().setPreferredSize(new Dimension(800, 500));

        Component comp;

        characterMetaData();
        comp = abilityScores(contentPane, 6);
        combatOptions(comp, 6);
        comp = speedAndStuff(comp);
        comp = grapple(contentPane, comp);
        savingThrows(contentPane, comp);

        for (Component curComp : guiComponenets)
        {
            contentPane.add(curComp);
        }
        pack();
    }

    /**
     * Generate the character meta data elements
     */
    private void characterMetaData()
    {
        // Char Name
        JLabel labelCharName = new JLabel("Character Name");
        guiComponenets.add(labelCharName);

        JTextField textCharName = new JTextField(20);
        guiComponenets.add(textCharName);

        layout.putConstraint(NORTH, textCharName, 0, SOUTH, labelCharName);
        layout.putConstraint(WEST, textCharName, 0, WEST, labelCharName);

        layout.putConstraint(NORTH, labelCharName, 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelCharName, 5, WEST, contentPane);

        // Player Name
        JLabel labelPlayerName = new JLabel("Player Name");
        guiComponenets.add(labelPlayerName);

        JTextField textPlayerName = new JTextField(20);
        guiComponenets.add(textPlayerName);

        layout.putConstraint(NORTH, textPlayerName, 0, SOUTH, labelPlayerName);
        layout.putConstraint(WEST, textPlayerName, 0, WEST, labelPlayerName);

        layout.putConstraint(NORTH, labelPlayerName, 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelPlayerName, 250, WEST, contentPane);

        // Class
        JLabel labelClass = new JLabel("Class");
        guiComponenets.add(labelClass);

        JTextField textClass = new JTextField(16);
        guiComponenets.add(textClass);

        layout.putConstraint(NORTH, textClass, 0, SOUTH, labelClass);
        layout.putConstraint(WEST, textClass, 0, WEST, labelClass);

        layout.putConstraint(NORTH, labelClass, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelClass, 5, WEST, contentPane);

        // Level
        JLabel labelLevel = new JLabel("Level");
        guiComponenets.add(labelLevel);

        JTextField textLevel = new JTextField(4);
        guiComponenets.add(textLevel);

        layout.putConstraint(NORTH, textLevel, 0, SOUTH, labelLevel);
        layout.putConstraint(WEST, textLevel, 0, WEST, labelLevel);

        layout.putConstraint(NORTH, labelLevel, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelLevel, 5, EAST, textClass);

        // ECL
        JLabel labelEcl = new JLabel("ECL");
        guiComponenets.add(labelEcl);

        JTextField textEcl = new JTextField(4);
        guiComponenets.add(textEcl);

        layout.putConstraint(NORTH, textEcl, 0, SOUTH, labelEcl);
        layout.putConstraint(WEST, textEcl, 0, WEST, labelEcl);

        layout.putConstraint(NORTH, labelEcl, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelEcl, 5, EAST, textLevel);

        // Race/Template
        JLabel labelRace = new JLabel("Race/Template");
        guiComponenets.add(labelRace);

        JTextField textRace = new JTextField(8);
        guiComponenets.add(textRace);

        layout.putConstraint(NORTH, textRace, 0, SOUTH, labelRace);
        layout.putConstraint(WEST, textRace, 0, WEST, labelRace);

        layout.putConstraint(NORTH, labelRace, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelRace, 5, EAST, textEcl);

        // Size
        JLabel labelSize = new JLabel("Size");
        guiComponenets.add(labelSize);

        JComboBox<String> comboSize =
                                      new JComboBox<String>(
                                                            new String[] { "F", "D", "T", "S", "M", "L", "H", "G", "C" });
        guiComponenets.add(comboSize);

        layout.putConstraint(NORTH, comboSize, 0, SOUTH, labelSize);
        layout.putConstraint(WEST, comboSize, 0, WEST, labelSize);

        layout.putConstraint(NORTH, labelSize, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelSize, 5, EAST, textRace);

        // Gender
        JLabel labelGender = new JLabel("Gender");
        guiComponenets.add(labelGender);

        JComboBox<String> comboGender = new JComboBox<String>(new String[] { "F", "M" });
        guiComponenets.add(comboGender);

        layout.putConstraint(NORTH, comboGender, 0, SOUTH, labelGender);
        layout.putConstraint(WEST, comboGender, 0, WEST, labelGender);

        layout.putConstraint(NORTH, labelGender, LINE_HEIGHT * 2 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelGender, 5, EAST, comboSize);

        // Alignment
        JLabel labelAlign = new JLabel("Alignment");
        guiComponenets.add(labelAlign);

        JComboBox<String> comboAlign =
                                       new JComboBox<String>(new String[] { "LG", "NG", "CG", "LN", "TN", "CN", "LE",
                                                                           "NE", "CE" });
        guiComponenets.add(comboAlign);

        layout.putConstraint(NORTH, comboAlign, 0, SOUTH, labelAlign);
        layout.putConstraint(WEST, comboAlign, 0, WEST, labelAlign);

        layout.putConstraint(NORTH, labelAlign, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelAlign, 5, WEST, contentPane);

        // Religion/Patron Deity
        JLabel labelReligion = new JLabel("Religion");
        guiComponenets.add(labelReligion);

        JTextField textReligion = new JTextField(12);
        guiComponenets.add(textReligion);

        layout.putConstraint(NORTH, textReligion, 0, SOUTH, labelReligion);
        layout.putConstraint(WEST, textReligion, 0, WEST, labelReligion);

        layout.putConstraint(NORTH, labelReligion, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelReligion, 5, EAST, labelAlign);

        // Height
        JLabel labelHeight = new JLabel("Height");
        guiComponenets.add(labelHeight);

        JTextField textHeight = new JTextField(5);
        guiComponenets.add(textHeight);

        layout.putConstraint(NORTH, textHeight, 0, SOUTH, labelHeight);
        layout.putConstraint(WEST, textHeight, 0, WEST, labelHeight);

        layout.putConstraint(NORTH, labelHeight, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelHeight, 5, EAST, textReligion);

        // Weight
        JLabel labelWeight = new JLabel("Weight");
        guiComponenets.add(labelWeight);

        JTextField textWeight = new JTextField(5);
        guiComponenets.add(textWeight);

        layout.putConstraint(NORTH, textWeight, 0, SOUTH, labelWeight);
        layout.putConstraint(WEST, textWeight, 0, WEST, labelWeight);

        layout.putConstraint(NORTH, labelWeight, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelWeight, 5, EAST, textHeight);

        // Looks
        JLabel labelLooks = new JLabel("Looks");
        guiComponenets.add(labelLooks);

        JTextField textLooks = new JTextField(12);
        guiComponenets.add(textLooks);

        layout.putConstraint(NORTH, textLooks, 0, SOUTH, labelLooks);
        layout.putConstraint(WEST, textLooks, 0, WEST, labelLooks);

        layout.putConstraint(NORTH, labelLooks, LINE_HEIGHT * 4 + 5, NORTH, contentPane);
        layout.putConstraint(WEST, labelLooks, 5, EAST, textWeight);
    }

    /**
     * Creates the ability score panel and links the boxes together
     */
    // TODO: Move to ability scores factory/class rather than have it here
    private Component abilityScores(Component westComponent, int depth)
    {

        JPanel abilityScores = new JPanel(new GridBagLayout());
        abilityScores.setBorder(BorderFactory.createTitledBorder("Ability Scores"));

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 0, 0, 0);

        Font small = new Font("Verdana", Font.BOLD, 8);

        for (int i = 0; i < AbilityScore.values().length; i++)
        {
            int index = i * 2;
            JLabel name = new JLabel(AbilityScore.values()[i].name());
            constraint.gridx = 0;
            constraint.gridy = index;
            abilityScores.add(name, constraint);

            JLabel longName = new JLabel(AbilityScore.values()[i].getAbilityName());
            longName.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            abilityScores.add(longName, constraint);

            JTextField total = new JTextField(2);
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
            constraint.gridx = 3;
            constraint.gridy = index;
            abilityScores.add(base, constraint);

            JLabel JLabelBase = new JLabel(LabelUtils.multiLine("Base Scaore +\nRacial Mod", true));
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

            JFormattedTextField enchance = new JFormattedTextField();
            constraint.gridx = 5;
            constraint.gridy = index;
            abilityScores.add(enchance, constraint);

            JLabel JLabelEnchance = new JLabel(LabelUtils.multiLine("Enhancement\nbonuses", true));
            JLabelEnchance.setFont(small);
            constraint.gridx = 5;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelEnchance, constraint);

            JLabel JLabelPlus2 = new JLabel("  +  ");
            constraint.gridx = 6;
            constraint.gridy = index;
            constraint.gridheight = 2;
            abilityScores.add(JLabelPlus2, constraint);

            constraint.gridheight = 1; // reset

            JFormattedTextField misc = new JFormattedTextField();
            constraint.gridx = 7;
            constraint.gridy = index;
            abilityScores.add(misc, constraint);

            JLabel JLabelMisc = new JLabel(LabelUtils.multiLine("Misc\nbonuses", true));
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
            constraint.gridx = 9;
            constraint.gridy = index;
            abilityScores.add(miscNeg, constraint);

            JLabel JLabelMiscNeg = new JLabel(LabelUtils.multiLine("Misc\npenalties", true));
            JLabelMiscNeg.setFont(small);
            constraint.gridx = 9;
            constraint.gridy = index + 1;
            abilityScores.add(JLabelMiscNeg, constraint);

            JTextField mod = new JTextField(2);
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

            this.abilityScores.put(AbilityScore.values()[i], new AbilityScores(AbilityScore.values()[i], total, base,
                                                                               enchance, misc, miscNeg, mod));
        }

        guiComponenets.add(abilityScores);
        layout.putConstraint(WEST, abilityScores, 5, WEST, westComponent);
        layout.putConstraint(NORTH, abilityScores, LINE_HEIGHT * 6 + 5, NORTH, contentPane);

        return abilityScores;
    }

    private void combatOptions(Component westComponent, int depth)
    {
        JPanel combatOptions = new JPanel(new GridBagLayout());
        combatOptions.setBorder(BorderFactory.createTitledBorder("Combat Options"));

        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel lableBaseAttack = new JLabel("Base Attack Bonus");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridwidth = 2;
        combatOptions.add(lableBaseAttack, constraint);

        JTextField textBaseAttack = new JTextField(12);
        constraint.gridx = 2;
        constraint.gridy = 0;
        constraint.gridwidth = 3;
        combatOptions.add(textBaseAttack, constraint);

        constraint.gridwidth = 1;

        for (int i = 0; i < 4; i++)
        {
            int index = (i * 4) + 1;

            JTextField weapon = new JTextField(8);
            // weapon.setFont(medium);
            constraint.gridx = 0;
            constraint.gridy = index;
            combatOptions.add(weapon, constraint);

            JLabel JLabelWeapon = new JLabel("Weapon");
            JLabelWeapon.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            combatOptions.add(JLabelWeapon, constraint);

            JTextField attackBonus = new JTextField(8);
            // attackBonus.setFont(medium);
            constraint.gridx = 1;
            constraint.gridy = index;
            constraint.gridwidth = 2;
            combatOptions.add(attackBonus, constraint);

            JLabel JLabelAttackBonus = new JLabel("Attack Bonus");
            JLabelAttackBonus.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 1;
            constraint.gridwidth = 2;
            combatOptions.add(JLabelAttackBonus, constraint);

            constraint.gridwidth = 1;

            JTextField damage = new JTextField(4);
            // damage.setFont(medium);
            constraint.gridx = 3;
            constraint.gridy = index;
            combatOptions.add(damage, constraint);

            JLabel JLabelDamage = new JLabel("Damage");
            JLabelDamage.setFont(small);
            constraint.gridx = 3;
            constraint.gridy = index + 1;
            combatOptions.add(JLabelDamage, constraint);

            JTextField crit = new JTextField(4);
            // crit.setFont(medium);
            constraint.gridx = 4;
            constraint.gridy = index;
            combatOptions.add(crit, constraint);

            JLabel JLabelCrit = new JLabel("Critical");
            JLabelCrit.setFont(small);
            constraint.gridx = 4;
            constraint.gridy = index + 1;
            combatOptions.add(JLabelCrit, constraint);

            // Line 2

            JTextField range = new JTextField(8);
            constraint.gridx = 0;
            constraint.gridy = index + 2;
            combatOptions.add(range, constraint);

            JLabel JLabelRange = new JLabel("Range Increment");
            JLabelRange.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 3;
            combatOptions.add(JLabelRange, constraint);

            JTextField type = new JTextField(4);
            constraint.gridx = 1;
            constraint.gridy = index + 2;
            combatOptions.add(type, constraint);

            JLabel JLabelType = new JLabel("Type");
            JLabelType.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 3;
            combatOptions.add(JLabelType, constraint);

            JTextField notes = new JTextField(12);
            constraint.gridx = 2;
            constraint.gridy = index + 2;
            constraint.gridwidth = 3;
            combatOptions.add(notes, constraint);

            JLabel JLabelNotes = new JLabel("Notes/Ammo");
            JLabelNotes.setFont(small);
            constraint.gridx = 2;
            constraint.gridy = index + 3;
            constraint.gridwidth = 3;
            combatOptions.add(JLabelNotes, constraint);

            constraint.gridwidth = 1;
        }

        guiComponenets.add(combatOptions);
        layout.putConstraint(WEST, combatOptions, 5, EAST, westComponent);
        layout.putConstraint(NORTH, combatOptions, LINE_HEIGHT * depth + 5, NORTH, contentPane);
    }

    private Component speedAndStuff(Component northComponent)
    {
        JLabel labelSpeed = new JLabel("Speed");
        guiComponenets.add(labelSpeed);
        JTextField textSpeed = new JTextField(30);
        guiComponenets.add(textSpeed);

        layout.putConstraint(NORTH, textSpeed, 0, NORTH, labelSpeed);
        layout.putConstraint(WEST, textSpeed, 2, EAST, labelSpeed);

        layout.putConstraint(NORTH, labelSpeed, 0, SOUTH, northComponent);
        layout.putConstraint(WEST, labelSpeed, 5, WEST, contentPane);

        JLabel labelInitMod = new JLabel("Initiative Modifier");
        guiComponenets.add(labelInitMod);
        JTextField textInitMod = new JTextField(10);
        guiComponenets.add(textInitMod);

        layout.putConstraint(NORTH, textInitMod, 0, NORTH, labelInitMod);
        layout.putConstraint(WEST, textInitMod, 2, EAST, labelInitMod);

        layout.putConstraint(NORTH, labelInitMod, 0, SOUTH, northComponent);
        layout.putConstraint(WEST, labelInitMod, 5, EAST, textSpeed);

        return labelSpeed;
    }

    private Component grapple(Component westComponent, Component northComponent)
    {

        JPanel grapple = new JPanel(new GridBagLayout());

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
        constraint.gridx = 9;
        constraint.gridy = 0;
        grapple.add(misc, constraint);

        JLabel JLabelMiscNeg = new JLabel(LabelUtils.multiLine("Misc\nmodifier", true));
        JLabelMiscNeg.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 1;
        grapple.add(JLabelMiscNeg, constraint);

        layout.putConstraint(WEST, grapple, 5, WEST, westComponent);
        layout.putConstraint(NORTH, grapple, 5, SOUTH, northComponent);
        guiComponenets.add(grapple);

        new Grapple(total, base, strength, size, misc);

        return grapple;
    }

    private Component savingThrows(Component westComponent, Component northComponent)
    {
        JPanel savingThrows = new JPanel(new GridBagLayout());
        savingThrows.setBorder(BorderFactory.createTitledBorder("Saving Throws"));

        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel lableTotal = new JLabel("Total");
        lableTotal.setFont(small);
        constraint.gridx = 1;
        constraint.gridy = 0;
        savingThrows.add(lableTotal, constraint);

        JLabel lablelBase = new JLabel(LabelUtils.multiLine("Base\nsave", true));
        lablelBase.setFont(small);
        constraint.gridx = 3;
        constraint.gridy = 0;
        savingThrows.add(lablelBase, constraint);

        JLabel lableAbility = new JLabel(LabelUtils.multiLine("Ability\nmodifier", true));
        lableAbility.setFont(small);
        constraint.gridx = 5;
        constraint.gridy = 0;
        savingThrows.add(lableAbility, constraint);

        JLabel lableMagic = new JLabel(LabelUtils.multiLine("Magic\nModifier", true));
        lableMagic.setFont(small);
        constraint.gridx = 7;
        constraint.gridy = 0;
        savingThrows.add(lableMagic, constraint);

        JLabel lableMisc = new JLabel(LabelUtils.multiLine("Misc\nModifier", true));
        lableMisc.setFont(small);
        constraint.gridx = 9;
        constraint.gridy = 0;
        savingThrows.add(lableMisc, constraint);

        JLabel lableTemp = new JLabel("Temp");
        lableTemp.setFont(small);
        constraint.gridx = 11;
        constraint.gridy = 0;
        savingThrows.add(lableTemp, constraint);

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

        guiComponenets.add(savingThrows);

        layout.putConstraint(WEST, savingThrows, 5, WEST, westComponent);
        layout.putConstraint(NORTH, savingThrows, 5, SOUTH, northComponent);

        return savingThrows;
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new CharacterSheet().setVisible(true);
            }
        });
    }
}
