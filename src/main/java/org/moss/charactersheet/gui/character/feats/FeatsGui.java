package org.moss.charactersheet.gui.character.feats;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.model.Stats;
import org.springframework.stereotype.Component;

/**
 * Generator for Feats and Special Abilities
 */
@Component
public class FeatsGui implements GenerateGui {

	private JPanel featsEtc = new JPanel(new GridBagLayout());
	private GridBagConstraints consts = new GridBagConstraints();

	/**
	 * Generates Feats GUI components
	 * @return 
	 */
	@Override
	public JPanel generate() {
		addFeats();
		addSpecialAbilities();
		return featsEtc;
	}

	private void addFeats() {
		JPanel feats = new JPanel(new GridBagLayout());
		feats.setBorder(BorderFactory.createTitledBorder("Feats"));
		GridBagConstraints fCons = new GridBagConstraints();
		fCons.insets = new Insets(2,0,0,0);
		
		JLabel lblFeats = new JLabel("Feat");
		feats.add(lblFeats);
		for (int i = 1; i <= 11; i++) {
			fCons.gridy = i;
			JTextField textFeat = new JTextField(30);
			feats.add(textFeat, fCons);
		}
		
		fCons.gridx = 1;
		fCons.gridy = 0;
		JLabel lblEffects = new JLabel("Effect");
		feats.add(lblEffects);
		for (int i = 1; i <= 11; i++) {
			fCons.gridy = i;
			JTextField textEff = new JTextField(30);
			feats.add(textEff, fCons);
		}
		
		featsEtc.add(feats);
	}

	private void addSpecialAbilities() {
		JPanel specAbs = new JPanel(new GridBagLayout());
		specAbs.setBorder(BorderFactory.createTitledBorder("Special Abilities"));
		GridBagConstraints saCons = new GridBagConstraints();
		saCons.insets = new Insets(2,0,0,0);
		
		JLabel lblAbility = new JLabel("Ability Name");
		specAbs.add(lblAbility);
		for (int i = 1; i <= 11; i++) {
			saCons.gridy = i;
			JTextField textFeat = new JTextField(30);
			specAbs.add(textFeat, saCons);
		}
		
		saCons.gridx = 1;
		saCons.gridy = 0;
		JLabel lblEffects = new JLabel("Effect");
		specAbs.add(lblEffects);
		for (int i = 1; i <= 11; i++) {
			saCons.gridy = i;
			JTextField textEff = new JTextField(30);
			specAbs.add(textEff, saCons);
		}
		
		consts.gridy = 1;
		featsEtc.add(specAbs, consts);
	}

	@Override
	public Stats save() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
