package org.moss.charactersheet.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.moss.charactersheet.aspects.SkillInfo;
import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.dialog.AddSkillDialog;
import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.util.LabelUtils;


/**
 * Generator for ability scores
 * 
 * @author Jacq
 * 
 */
public class SkillsGui implements ActionListener, GenerateGui
{
    private JPanel skills;
    private int index;

    /**
     * Creates new generator
     */
    public SkillsGui()
    {
    	this.skills = new JPanel(new GridBagLayout());
    }

    /**
     * Generates the components required
     */
    @Override
    public JPanel generate()
    {
    	createSkillsOutline();
        addSkillsToPanel(skills);

        JButton btnAddSkill = new JButton("Add New Skill...");
        btnAddSkill.addActionListener(this);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = Skill.getValues().size() + 2;
        skills.add(btnAddSkill, constraints);
        
        return skills;
    }

    /**
     * Create border and headers for Skills table
     * 
     * @return JPanel
     */
    private void createSkillsOutline()
    {
        skills.setBorder(BorderFactory.createTitledBorder("Character Skills"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 3, 4, 3);

        Font small = new Font("Verdana", Font.BOLD, 10);
        
        // CS
        JLabel labelCS = new JLabel("CS");
        labelCS.setFont(small);
        constraints.gridx = 0;
        skills.add(labelCS, constraints);

        // Skills
        JLabel labelSkills = new JLabel("Skill Name");
        labelSkills.setFont(small);
        constraints.gridx++;
        skills.add(labelSkills, constraints);

        // Ability
        JLabel labelAbility = new JLabel(LabelUtils.multiLine("Key \nAbility"));
        labelAbility.setFont(small);
        constraints.gridx++;
        skills.add(labelAbility, constraints);

        // Skill Mod
        JLabel labelSkillMod = new JLabel(LabelUtils.multiLine("Skill \nModifier"));
        labelSkillMod.setFont(small);
        constraints.gridx++;
        skills.add(labelSkillMod, constraints);

        // Ability Mod
        JLabel labelAbMod = new JLabel(LabelUtils.multiLine("Ability \nModifier"));
        labelAbMod.setFont(small);
        constraints.gridx++;
        skills.add(labelAbMod, constraints);

        // Ranks
        JLabel labelRanks = new JLabel("Ranks");
        labelRanks.setFont(small);
        constraints.gridx++;
        skills.add(labelRanks, constraints);

        // Misc
        JLabel labelMisc = new JLabel(LabelUtils.multiLine("Misc \nModifier"));
        labelMisc.setFont(small);
        constraints.gridx++;
        skills.add(labelMisc, constraints);
    }

    /**
     * Adds all appropriate skills to view
     * 
     * @param skills
     */
    private void addSkillsToPanel(JPanel skills)
    {
        GridBagConstraints constraints = new GridBagConstraints();

        index = 1;
        for (String curSkill : Skill.getValues())
        {
        	if (!Skill.getSkill(curSkill).isCustomSkill())
        	{
        		constraints.gridy = index;
        		constraints.gridx = 0;
        		constraints.insets = new Insets(2, 0, 0, 0);

        		JCheckBox classSkillCB = new JCheckBox();
        		skills.add(classSkillCB, constraints);

        		JLabel labelSkillName = new JLabel(curSkill);
        		labelSkillName.setHorizontalAlignment(SwingConstants.LEFT);
        		constraints.gridx++;
        		skills.add(labelSkillName, constraints);

        		JLabel labelAbilityName = new JLabel(Skill.getSkill(curSkill).getAbility().name());
        		constraints.gridx++;
        		skills.add(labelAbilityName, constraints);

        		JTextField textTotal = new JTextField(2);
        		textTotal.setEditable(false);
        		constraints.gridx++;
        		skills.add(textTotal, constraints);

        		JLabel labelEquals = new JLabel("  =  ");
        		constraints.gridx++;
        		skills.add(labelEquals, constraints);

        		JTextField textAbility = new JTextField(2);
        		textAbility.setEditable(false);
        		constraints.gridx++;
        		skills.add(textAbility, constraints);

        		JLabel labelPlus2 = new JLabel("  +  ");
        		constraints.gridx++;
        		skills.add(labelPlus2, constraints);

        		JFormattedTextField textRanks = new JFormattedTextField();
        		constraints.gridx++;
        		skills.add(textRanks, constraints);

        		JLabel labelPlus3 = new JLabel("  +  ");
        		constraints.gridx++;
        		skills.add(labelPlus3, constraints);

        		JFormattedTextField textMisc = new JFormattedTextField();
        		constraints.gridx++;
        		skills.add(textMisc, constraints);

        		new SkillInfo(new Skill(curSkill, Skill.getSkill(curSkill).getAbility(), false), classSkillCB, textTotal,
        				textAbility, textRanks, textMisc);

        		index++;
        	}
        }
    }

    public void addSkill(Skill skill)
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = index;
        constraints.gridx = 0;
        constraints.insets = new Insets(2, 0, 0, 0);

        JCheckBox classSkillCB = new JCheckBox();
        skills.add(classSkillCB, constraints);

        JLabel labelSkillName = new JLabel(skill.getSkillName());
        constraints.gridx++;
        skills.add(labelSkillName, constraints);

        JLabel labelAbilityName = new JLabel(skill.getAbility().name());
        constraints.gridx++;
        skills.add(labelAbilityName, constraints);

        JTextField textTotal = new JTextField(2);
        textTotal.setEditable(false);
        constraints.gridx++;
        skills.add(textTotal, constraints);

        JLabel labelEquals = new JLabel("  =  ");
        constraints.gridx++;
        skills.add(labelEquals, constraints);

        JTextField textAbility = new JTextField(2);
        textAbility.setEditable(false);
        constraints.gridx++;
        skills.add(textAbility, constraints);

        JLabel labelPlus2 = new JLabel("  +  ");
        constraints.gridx++;
        skills.add(labelPlus2, constraints);

        JFormattedTextField textRanks = new JFormattedTextField();
        constraints.gridx++;
        skills.add(textRanks, constraints);

        JLabel labelPlus3 = new JLabel("  +  ");
        constraints.gridx++;
        skills.add(labelPlus3, constraints);

        JFormattedTextField textMisc = new JFormattedTextField();
        constraints.gridx++;
        skills.add(textMisc, constraints);

        new SkillInfo(new Skill(skill.getSkillName(), skill.getAbility(), true), classSkillCB, textTotal, textAbility,
                      textRanks, textMisc);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() instanceof JButton)
        {
            JButton source = (JButton) e.getSource();
            String text = source.getText();

            if (text.equals("Add New Skill..."))
            {
                AddSkillDialog skillForm = new AddSkillDialog();
                skillForm.setVisible(true);
                skillForm.addWindowListener(new WindowAdapter()
                {

                    @Override
                    public void windowClosed(WindowEvent e)
                    {
                        if (e.getComponent() instanceof JDialog)
                        {
                            JDialog dialog = (JDialog) e.getComponent();
                            if (dialog instanceof AddSkillDialog)
                            {
                                AddSkillDialog addDialog = (AddSkillDialog) dialog;
                                if (addDialog.isSkillAdded())
                                {
                                    addSkill(addDialog.getSkill());
                                    skills.revalidate();
                                    skills.repaint();
                                }

                            }
                        }
                        super.windowClosed(e);
                    }
                });
            }
        }
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
