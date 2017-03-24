package org.moss.charactersheet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.moss.charactersheet.impl.FullCharacter;

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
 * @author Jacq
 *
 */
public class CharInfoGui implements GenerateGui<FullCharacter> {

	private JPanel charInfo = new JPanel(new GridBagLayout());
	private GridBagConstraints ciConstraints = new GridBagConstraints();
	private MetaDataGui metaGui = new MetaDataGui();
	private AbilityScoresGui abilitiesGui = new AbilityScoresGui();
	private CombatOptionsGui combatGui = new CombatOptionsGui();
	private SpeedComponents speedGui = new SpeedComponents();
	private GrappleGui grapGui = new GrappleGui();
	private SavesGui saveGui = new SavesGui();
	private AcGui acGui = new AcGui();

	public CharInfoGui()
	{
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
		charInfo.add(grapGui.generate(), ciConstraints);
	}

	private void addSaves() {
		ciConstraints.gridy = 4;
		charInfo.add(saveGui.generate(), ciConstraints);
	}

	private void addAC() {
		ciConstraints.gridy = 5;
		charInfo.add(acGui.generate(), ciConstraints);
	}

	@Override
	public FullCharacter save() {
		return FullCharacter.builder()
				.info(metaGui.save())
				.abilityStats(abilitiesGui.save())
				.combatStats(combatGui.save())
				.speedStats(speedGui.save())
				.saveStats(saveGui.save())
				.grappleStats(grapGui.save())
				.build();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}
}
