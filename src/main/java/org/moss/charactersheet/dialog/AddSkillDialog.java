package org.moss.charactersheet.dialog;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.util.LabelUtils;

public class AddSkillDialog extends JDialog implements ActionListener 
{
	private JComboBox<String> comboCustomSkill = new JComboBox<String>();
	private JTextField textSkillName = new JTextField(20);
	private JComboBox<AbilityScore> comboAbility = new JComboBox<AbilityScore>();

	private JButton btnConfirm = new JButton("Confirm");
	private JButton btnCancel = new JButton("Cancel");
	
	private boolean skillAdded;
	private Skill skill;

	public Skill getSkill() 
	{
		return skill;
	}
	
	public boolean isSkillAdded() 
	{
		return skillAdded;
	}

	private void setSkillAdded(boolean skillAdded) 
	{
		this.skillAdded = skillAdded;
	}

	public AddSkillDialog() 
	{
		super();
		init();
	}

	private void init() 
	{
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(600, 200));
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Add New Skill");

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(1, 1));

		JPanel newSkill = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 20, 5, 20);

		// Custom label
		JLabel labelCustom = new JLabel("Custom Skill");
		newSkill.add(labelCustom, constraints);

		// Skill Label
		JLabel labelSkills = new JLabel("Skill Name");
		constraints.gridx = 2;
		newSkill.add(labelSkills, constraints);

		// Ability Label
		JLabel labelAbility = new JLabel(LabelUtils.multiLine("Key \nAbility"));
		constraints.gridx = 4;
		newSkill.add(labelAbility, constraints);

		// Custom Skill
		for (String name : Skill.getValues()) 
		{
			if (Skill.getSkill(name).isCustomSkill())
			{
				comboCustomSkill.addItem(name);
			}
		}
		comboCustomSkill.addItem("Other");
		comboCustomSkill.addActionListener(this);
		constraints.gridx = 0;
		constraints.gridy = 1;
		newSkill.add(comboCustomSkill, constraints);

		// Skill Name
		textSkillName.setMinimumSize(textSkillName.getPreferredSize());
		constraints.gridx = 2;
		newSkill.add(textSkillName, constraints);

		// Corresponding ability
		if (comboAbility.getItemCount() == 0) 
		{
			addAbilities();
		}
		constraints.gridx = 4;
		newSkill.add(comboAbility, constraints);

		// Confirm
		btnConfirm.addActionListener(this);
		constraints.gridx = 0;
		constraints.gridy = 2;
		newSkill.add(btnConfirm, constraints);

		// Cancel
		btnCancel.addActionListener(this);
		constraints.gridx = 4;
		newSkill.add(btnCancel, constraints);

		contentPane.add(newSkill);

		pack();
	}

	private void addAbilities() 
	{
		comboAbility.removeAllItems();
		String chosenSkillName = comboCustomSkill.getSelectedItem().toString();
		
		if (Skill.getValues().contains(chosenSkillName)) 
		{
			comboAbility.addItem(Skill.getSkill(chosenSkillName)
					.getAbility());
		} 
		else
		{
			for (AbilityScore ability : AbilityScore.values())
			{
				comboAbility.addItem(ability);
			}
		}
	}

	public void addSkill() 
	{
		String fullSkillName = comboCustomSkill.getSelectedItem().toString()
				+ " (" + textSkillName.getText() + ")";
		skill = Skill.addSkill(fullSkillName, AbilityScore.valueOf
				(comboAbility.getSelectedItem().toString()), true);
		setSkillAdded(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if (src instanceof JComboBox) 
		{
			JComboBox source = (JComboBox) src;
			if (source.getClass().getName()
					.equals(comboCustomSkill.getClass().getName())) 
			{
				addAbilities();
			}
		} 
		else if (src instanceof JButton) 
		{
			JButton source = (JButton) src;

			if (source.equals(btnConfirm)) 
			{
				addSkill();
				dispose();
			}
			else if (source.equals(btnCancel))
			{
				dispose();
			}
		}
	}
}
