package org.moss.charactersheet.gui.animal;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.gui.character.info.AcGui;
import org.moss.charactersheet.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generate GUI for Animal Companion
 */
@org.springframework.stereotype.Component
public class AnimalGui implements GenerateGui {

	JPanel animalInfo = new JPanel(new GridBagLayout());
	GridBagConstraints animCons = new GridBagConstraints();

	@Autowired
    AcGui acGui;

	@Override
	public JPanel generate() {
		addBasicInfo();
		addStats();
		addAC();
		addAttackStats();
		addSkills();
		return animalInfo;
	}

	private void addBasicInfo() {
		JPanel basicInfo = new JPanel(new GridBagLayout());
		
		JLabel lblName = new JLabel("Name");
		JTextField textName = new JTextField(30);
		JLabel lblType = new JLabel("Creature Type");
		JTextField textType = new JTextField(30);
		
		basicInfo.add(lblName);
		basicInfo.add(textName);
		basicInfo.add(lblType);
		basicInfo.add(textType);
		
		animalInfo.add(basicInfo);
	}

	private void addStats() {
		JPanel stats = new JPanel(new GridBagLayout());
		GridBagConstraints statCons = new GridBagConstraints();
		statCons.insets = new Insets(0, 2, 0, 4);
		
		// Abilities
		JPanel abilities = new JPanel(new GridBagLayout());
		GridBagConstraints absCons = new GridBagConstraints();
		
		absCons.gridx = 0;
		for (AbilityScore skill : AbilityScore.values()) {
			absCons.gridy = 0;
			JLabel lblSkill = new JLabel(skill.toString());
			JTextField textScore = new JTextField(2);
			abilities.add(lblSkill, absCons);
			absCons.gridy++;
			abilities.add(textScore, absCons);
			absCons.gridx++;
		}
		stats.add(abilities);
		
		// Speed and Initiative
		JPanel speed = new JPanel(new GridBagLayout());
		GridBagConstraints spCons = new GridBagConstraints();
		speed.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblInit = new JLabel("Initiative");
		JTextField textInit = new JTextField(30);
		textInit.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel lblSpeed = new JLabel("Speed");
		JTextField textSpeed = new JTextField(30);
		
		spCons.gridx = 0;
		spCons.gridy = 0;
		speed.add(lblInit, spCons);
		spCons.gridx = 1;
		speed.add(textInit, spCons);
		spCons.gridx = 0;
		spCons.gridy = 1;
		speed.add(lblSpeed, spCons);
		spCons.gridx = 1;
		speed.add(textSpeed, spCons);
		
		statCons.gridx = 1;
		stats.add(speed, statCons);
		
		JPanel hitPoints = new JPanel(new GridBagLayout());
		JTextArea textHP = new JTextArea(3, 20);
		textHP.setBorder(BorderFactory.createTitledBorder("Hit Points"));
		hitPoints.add(textHP);
		
		statCons.gridx++;
		stats.add(hitPoints, statCons);
		
		animCons.gridy = 1;
		animalInfo.add(stats, animCons);
	}

	private void addAC() {
		animCons.gridy++;
		animalInfo.add(acGui.generate(), animCons);
	}

	private void addAttackStats() {
		JPanel stats = new JPanel(new GridBagLayout());
		GridBagConstraints statCons = new GridBagConstraints();
		
		JPanel saves = new JPanel(new GridBagLayout());
		saves.setBorder(BorderFactory.createTitledBorder("Saving Throws"));
		GridBagConstraints savCons = new GridBagConstraints();
		
		savCons.gridy = 0;
		for (Save save : Save.values()) {
			savCons.gridx = 0;
			JLabel lblSave = new JLabel(save.getSaveName());
			JTextField textSave = new JTextField(3);
			textSave.setEditable(false);
			saves.add(lblSave, savCons);
			savCons.gridx++;
			saves.add(textSave, savCons);
			savCons.gridy++;
		}
		stats.add(saves);
		
		JPanel attacks = new JPanel(new GridBagLayout());
		attacks.setBorder(BorderFactory.createTitledBorder("Attacks"));
		GridBagConstraints attCons = new GridBagConstraints();
		
		List<String> labels = Arrays.asList("Weapon", "Bonus", "Damage", "Critical");
		
		attCons.gridy = 0;
		for (int i = 0; i < 3; i++) {
			attCons.gridx = 0;
			for (String label : labels) {
				JLabel lblAttStat = new JLabel(label);
				attacks.add(lblAttStat, attCons);
				attCons.gridx++;
			}
			attCons.gridy++;
			attCons.gridx = 0;
			for (int j = 0; j < 4; j++) {
				JTextField textNum = new JTextField(10);
				attacks.add(textNum, attCons);
				attCons.gridx++;
			}
			
			attCons.gridy++;
		}
		statCons.gridx = 1;
		stats.add(attacks, statCons);
		
		JPanel grapp = new JPanel(new GridBagLayout());
		grapp.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints grapCons = new GridBagConstraints();
		
		JLabel lblGrap = new JLabel("Grapple");
		JLabel lblPers = new JLabel("Personality");
		JTextField textGrap = new JTextField(15);
		JTextField textPers = new JTextField(15);
		
		grapp.add(lblGrap);
		grapCons.gridx = 1;
		grapp.add(textGrap, grapCons);
		grapCons.gridx--;
		grapCons.gridy = 1;
		grapp.add(lblPers, grapCons);
		grapCons.gridx++;
		grapp.add(textPers, grapCons);
		
		statCons.gridx++;
		stats.add(grapp, statCons);
		
		animCons.gridy++;
		animalInfo.add(stats, animCons);
	}

	private void addSkills() {
		// TODO Auto-generated method stub
		JPanel bigPanel = new JPanel(new GridBagLayout());
		GridBagConstraints bpCons = new GridBagConstraints();
		
		JPanel skills = new JPanel(new GridBagLayout());
		skills.setBorder(BorderFactory.createTitledBorder("Skills"));
		GridBagConstraints skCons = new GridBagConstraints();
		
		skCons.gridy = 0;
		for (int i = 0; i < 10; i++) {
			skCons.gridx = 0;
			JTextField textSkill = new JTextField(15);
			JLabel lblPlus = new JLabel(" + ");
			JTextField textMod = new JTextField(3);
			
			skills.add(textSkill, skCons);
			skCons.gridx++;
			skills.add(lblPlus, skCons);
			skCons.gridx++;
			skills.add(textMod, skCons);
			
			skCons.gridy++;
		}
		bigPanel.add(skills);
		addAbilities(bigPanel, bpCons);
		
		animCons.gridy++;
		animalInfo.add(bigPanel, animCons);
	}

	private void addAbilities(JPanel parentPanel, GridBagConstraints parentCons) {
		// | Feats            |
		// |------------------|
		// |Abilities, Tricks |
		JPanel bigPanel = new JPanel(new GridBagLayout());
		GridBagConstraints bpCons = new GridBagConstraints();
		
		// Feats
		JPanel feats = new JPanel(new GridBagLayout());
		feats.setBorder(BorderFactory.createTitledBorder("Feats"));
		GridBagConstraints fCons = new GridBagConstraints();
		
		fCons.gridy = 0;
		fCons.gridx = 0;
		for (int i = 0; i < 6; i++) {
			JTextField textFeat = new JTextField(20);
			if (i != 0 && i % 2 == 0) {
				fCons.gridx = 0;
				fCons.gridy++;
			}
			feats.add(textFeat, fCons);
			fCons.gridx++;
		}
		bigPanel.add(feats);
		bpCons.gridy = 1;
		
		// Special Abilities
		JPanel miniPanel = new JPanel(new GridBagLayout());
		GridBagConstraints miniCons = new GridBagConstraints();
		
		JPanel specAbs = new JPanel(new GridBagLayout());
		specAbs.setBorder(BorderFactory.createTitledBorder("Special Abilities"));
		GridBagConstraints saCons = new GridBagConstraints();
		
		saCons.gridx = 0;
		saCons.gridy = 0;
		for (int i = 0; i < 6; i++) {
			JTextField abil = new JTextField(20);
			specAbs.add(abil, saCons);
			saCons.gridy++;
		}
		miniPanel.add(specAbs);

		// Tricks
		JPanel tricks = new JPanel(new GridBagLayout());
		tricks.setBorder(BorderFactory.createTitledBorder("Tricks"));
		GridBagConstraints trCons = new GridBagConstraints();
		trCons.gridx = 0;
		trCons.gridy = 0;
		for (int i = 0; i < 6; i++) {
			JTextField trick = new JTextField(20);
			tricks.add(trick, trCons);
			trCons.gridy++;
		}
		miniCons.gridx = 1;
		miniPanel.add(tricks, miniCons);
		bigPanel.add(miniPanel, bpCons);
		
		parentCons.gridx = 1;
		parentPanel.add(bigPanel, parentCons);
	}

	@Override
	public Stats save() {
		// TODO Auto-generated method stub
		return null;
	}
}
