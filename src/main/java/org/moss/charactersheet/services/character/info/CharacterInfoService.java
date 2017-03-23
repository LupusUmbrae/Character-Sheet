package org.moss.charactersheet.services.character.info;

import javax.swing.JPanel;

import org.moss.charactersheet.gui.character.info.AbilityScoresGui;
import org.moss.charactersheet.gui.character.info.CombatOptionsGui;
import org.moss.charactersheet.gui.character.info.GrappleGui;
import org.moss.charactersheet.gui.character.info.MetaDataGui;
import org.moss.charactersheet.gui.character.info.SavingThrowsGui;
import org.moss.charactersheet.gui.character.info.SpeedComponentsGui;
import org.moss.charactersheet.model.character.info.FullCharacter;
import org.moss.charactersheet.services.SaveService;
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
    public FullCharacter save(JPanel panel) {
        return FullCharacter.builder()
                .info(metaGui.save())
                .abilityStats(abilitiesGui.save())
                .combatStats(combatGui.save())
                .speedStats(speedGui.save())
                .saveStats(savingThrowsGui.save())
                .grappleStats(grappleGui.save())
                .build();
    }

    @Override
    public void load() {

    }
}
