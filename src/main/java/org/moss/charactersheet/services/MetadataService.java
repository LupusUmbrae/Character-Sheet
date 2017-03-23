package org.moss.charactersheet.services;

import java.util.Arrays;

import javax.swing.JPanel;

import org.moss.charactersheet.impl.CharacterInfo;
import org.springframework.stereotype.Service;

/**
 * Service to provide save and load logic for {@link CharacterInfo}
 */
@Service
public class MetadataService implements SaveService<CharacterInfo> {
    private JPanel metadataPanel;

    @Override
    public MetadataService withPanel(JPanel panel) {
        this.metadataPanel = panel;
        return this;
    }

    @Override
    public CharacterInfo save() {
        return CharacterInfo.createCharacter(Arrays.asList(metadataPanel.getComponents()));
    }

    @Override
    public void load() {

    }
}
