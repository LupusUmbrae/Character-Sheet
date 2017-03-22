package org.moss.charactersheet.gui;

import static java.util.Collections.emptyMap;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.CombatStats;
import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.interfaces.Stats;

/**
 * Generator for combat options
 * @author Jacq
 *
 */
public class CombatOptionsGui implements GenerateGui<CombatStats> {
	private JPanel combatOptions;
	private static final String BASE_ATTACK = "BaseAttack";
	
    /**
     * Creates new generator
     */
    public CombatOptionsGui()
    {
    	this.combatOptions = new JPanel(new GridBagLayout());
    	this.combatOptions.setName("CombatOpts");
        this.combatOptions.setBorder(BorderFactory.createTitledBorder("Combat Options"));
    }

    @Override
    public JPanel generate()
    {
        GridBagConstraints constraint = new GridBagConstraints();

        Font small = new Font("Verdana", Font.BOLD, 8);

        JLabel labelBaseAttack = new JLabel("Base Attack Bonus");
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.gridwidth = 2;
        combatOptions.add(labelBaseAttack, constraint);

        JTextField textBaseAttack = new JTextField(12);
        textBaseAttack.setName(BASE_ATTACK);
        constraint.gridx = 2;
        constraint.gridy = 0;
        constraint.gridwidth = 3;
        combatOptions.add(textBaseAttack, constraint);

        constraint.gridwidth = 1;

        for (int i = 0; i < 4; i++)
        {
            int index = (i * 4) + 1;

            JTextField weapon = new JTextField(8);
            weapon.setName("Weapon" + i);
            constraint.gridx = 0;
            constraint.gridy = index;
            combatOptions.add(weapon, constraint);

            JLabel JLabelWeapon = new JLabel("Weapon");
            JLabelWeapon.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 1;
            combatOptions.add(JLabelWeapon, constraint);

            JTextField attackBonus = new JTextField(8);
            attackBonus.setName("AttackBonus" + i);
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
            damage.setName("Damage" + i);
            constraint.gridx = 3;
            constraint.gridy = index;
            combatOptions.add(damage, constraint);

            JLabel JLabelDamage = new JLabel("Damage");
            JLabelDamage.setFont(small);
            constraint.gridx = 3;
            constraint.gridy = index + 1;
            combatOptions.add(JLabelDamage, constraint);

            JTextField crit = new JTextField(4);
            crit.setName("Crit" + i);
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
            range.setName("Range" + i);
            constraint.gridx = 0;
            constraint.gridy = index + 2;
            combatOptions.add(range, constraint);

            JLabel JLabelRange = new JLabel("Range Increment");
            JLabelRange.setFont(small);
            constraint.gridx = 0;
            constraint.gridy = index + 3;
            combatOptions.add(JLabelRange, constraint);

            JTextField type = new JTextField(4);
            type.setName("Type" + i);
            constraint.gridx = 1;
            constraint.gridy = index + 2;
            combatOptions.add(type, constraint);

            JLabel JLabelType = new JLabel("Type");
            JLabelType.setFont(small);
            constraint.gridx = 1;
            constraint.gridy = index + 3;
            combatOptions.add(JLabelType, constraint);

            JTextField notes = new JTextField(12);
            notes.setName("Notes" + i);
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
        return combatOptions;
    }

	@Override
	public CombatStats getSaveService() {
		int baseAttackBonus = 0;
		Map<Integer, Map<String, String>> combatSkills = new LinkedHashMap<>();
		for (Component comp : combatOptions.getComponents()) {
			String compName = comp.getName();
			if (compName == null || compName.isEmpty()) {
				continue;
			}
			String value = null;
			if (comp instanceof JTextField) {
				value = ((JTextField) comp).getText();
			}
			if (compName.equalsIgnoreCase(BASE_ATTACK)) {
				baseAttackBonus = Integer.parseInt(value);
			} else {
				String weaponNum = compName.substring(compName.length()-1);
				String weaponAttr = compName.substring(0, compName.length()-1);
				int combatIteration = Integer.parseInt(weaponNum);
				Map<String, String> currentEntry = combatSkills.get(combatIteration);
				if (currentEntry == null) {
				    currentEntry = new HashMap<>();
                }
                currentEntry.put(weaponAttr, value);
                combatSkills.put(combatIteration, currentEntry);
			}
		}
		return new CombatStats(baseAttackBonus, combatSkills);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
