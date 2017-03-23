package org.moss.charactersheet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.services.CharacterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Generates all components for the overall character information
 * Includes:
 * <ul>
 * <li> Meta data </li>
 * <li> Ability scores </li>
 * <li> Combat options </li>
 * <li> Speed and Initiative </li>
 * <li> Grapple </li>
 * <li> Saves </li>
 * <li> AC </li>
 * </ul>
 */
@Component
public class CharInfoGui implements GenerateGui<FullCharacter> {

	private JPanel charInfo = new JPanel(new GridBagLayout());
	private GridBagConstraints ciConstraints = new GridBagConstraints();

	@Autowired
	MetaDataGui metaGui;
	@Autowired
	AbilityScoresGui abilitiesGui;
	@Autowired
	AcGui acGui;
	@Autowired
	SavingThrowsGui savingThrowsGui;
	@Autowired
	GrappleGui grappleGui;
	@Autowired
	CombatOptionsGui combatGui;
	@Autowired
	SpeedComponentsGui speedGui;

	@Autowired
	CharacterInfoService characterInfoService;

	@PostConstruct
	public void setupConstraints() {
		this.ciConstraints.insets = new Insets(2, 0, 0, 0);
	}

	/**
	 * Generates entire Character Info GUI
	 * @return 
	 */
	@Override
	public JPanel generate() {
		charInfo.setBorder(BorderFactory.createTitledBorder("Character Information"));
		addMetaData();
		addAbilityAndCombat();
		addSpeed();
		addGrapple();
		addSaves();
		addAC();
		return charInfo;
	}

	private void addMetaData() {
		charInfo.add(metaGui.generate());
	}

	private void addAbilityAndCombat() {
		JPanel miniPanel = new JPanel();
		GridBagConstraints consts = new GridBagConstraints();
		consts.gridx = 0;
		consts.gridy = 0;
		miniPanel.add(abilitiesGui.generate(), consts);
		consts.gridx++;
		miniPanel.add(combatGui.generate(), consts);
		ciConstraints.gridy = 1;
		charInfo.add(miniPanel, ciConstraints);
	}

	private void addSpeed() {
		JPanel miniPanel = speedGui.generate();
		ciConstraints.gridy++;
		charInfo.add(miniPanel, ciConstraints);
	}

	private void addGrapple() {
		ciConstraints.gridx = 0;
		ciConstraints.gridy = 3;
		charInfo.add(grappleGui.generate(), ciConstraints);
	}

	private void addSaves() {
		ciConstraints.gridy = 4;
		charInfo.add(savingThrowsGui.generate(), ciConstraints);
	}

	private void addAC() {
		ciConstraints.gridy = 5;
		charInfo.add(acGui.generate(), ciConstraints);
	}

	@Override
	public CharacterInfoService getSaveService() {
		return characterInfoService;
	}
}
