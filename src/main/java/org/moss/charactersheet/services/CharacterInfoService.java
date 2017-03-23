package org.moss.charactersheet.services;

import javax.swing.JPanel;

import org.moss.charactersheet.gui.AbilityScoresGui;
import org.moss.charactersheet.gui.CombatOptionsGui;
import org.moss.charactersheet.gui.GrappleGui;
import org.moss.charactersheet.gui.MetaDataGui;
import org.moss.charactersheet.gui.SavingThrowsGui;
import org.moss.charactersheet.gui.SpeedComponentsGui;
import org.moss.charactersheet.impl.FullCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service that provides save and load logic for {@link FullCharacter}
 */
@Service
public class CharacterInfoService implements SaveService<FullCharacter> {

    @Autowired
    MetaDataGui metaGui;
    @Autowired
    AbilityScoresGui abilitiesGui;
    @Autowired
    CombatOptionsGui combatGui;
    @Autowired
    SpeedComponentsGui speedGui;
    @Autowired
    SavingThrowsGui savingThrowsGui;
    @Autowired
    GrappleGui grappleGui;

    @Override
    public SaveService<FullCharacter> withPanel(JPanel panel) {
        return null;
    }

    @Override
    public FullCharacter save() {
        return FullCharacter.builder()
                .info(metaGui.getSaveService().save())
                .abilityStats(abilitiesGui.getSaveService().save())
                .combatStats(combatGui.getSaveService().save())
                .speedStats(speedGui.getSaveService().save())
                .saveStats(savingThrowsGui.getSaveService().save())
                .grappleStats(grappleGui.getSaveService().save())
                .build();
    }

    @Override
    public void load() {

    }
}
