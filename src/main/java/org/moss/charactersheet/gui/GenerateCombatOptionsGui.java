package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.moss.charactersheet.CharacterSheet;

import static javax.swing.SpringLayout.EAST;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.WEST;

/**
 * Generator for combat options
 * @author Jacq
 *
 */
public class GenerateCombatOptionsGui
{
    private SpringLayout layout;
    private Container tabPanel;
    private List<Component> pageComponents = new ArrayList<Component>();

    /**
     * Creates new generator that considers given parameters
     * @param layout
     * @param panel
     * @param components
     */
    public GenerateCombatOptionsGui(SpringLayout layout, Container panel, List<Component> components)
    {
        this.layout = layout;
        this.tabPanel = panel;
        this.pageComponents = components;
    }

    /**
     * Generates the components required and adds them to the list of components to add to the
     * appropriate panel.
     * Also builds on the layout.
     * @param westComponent
     * @param depth
     */
    public void generate(Component westComponent, int depth)
    {
        JPanel combatOptions = new JPanel(new GridBagLayout());
        combatOptions.setBorder(BorderFactory.createTitledBorder("Combat Options"));

        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel labelBaseAttack = new JLabel("Base Attack Bonus");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridwidth = 2;
        combatOptions.add(labelBaseAttack, constraint);

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

        pageComponents.add(combatOptions);
        layout.putConstraint(WEST, combatOptions, 5, EAST, westComponent);
        layout.putConstraint(NORTH, combatOptions, CharacterSheet.getLineHeight() * depth + 5, NORTH, tabPanel);
    }
}