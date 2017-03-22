package org.moss.charactersheet.services;

import javax.inject.Inject;
import javax.swing.JPanel;

import org.moss.charactersheet.impl.FullCharacter;
import org.springframework.stereotype.Service;

/**
 * Created by j.train on 22/03/2017.
 */
@Service
public class CharacterInfoService implements SaveService<FullCharacter> {

    @Inject
    public CharacterInfoService(){};

    @Override
    public SaveService<FullCharacter> withPanel(JPanel panel) {
        return null;
    }

    @Override
    public FullCharacter save() {
        return FullCharacter.builder()
                .info(metaGui.getSaveService())
                .abilityStats(abilitiesGui.getSaveService())
                .combatStats(combatGui.getSaveService())
                .speedStats(speedGui.getSaveService())
                .saveStats(saveGui.getSaveService())
                .grappleStats(grapGui.getSaveService())
                .build();
    }

    @Override
    public void load() {

    }
}
