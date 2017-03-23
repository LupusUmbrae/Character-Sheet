package org.moss.charactersheet.services.character.info;

import java.util.Arrays;

import javax.swing.JPanel;

import org.moss.charactersheet.model.character.info.CharacterInfo;
import org.moss.charactersheet.services.SaveService;
import org.springframework.stereotype.Service;

/**
 * Service to provide save and load logic for {@link CharacterInfo}
 */
@Service
public class MetadataService implements SaveService<CharacterInfo> {

    @Override
    public CharacterInfo save(JPanel panel) {
        return CharacterInfo.createCharacter(Arrays.asList(panel.getComponents()));
    }

    @Override
    public void load() {

    }
}
