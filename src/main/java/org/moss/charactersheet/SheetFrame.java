package org.moss.charactersheet;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import org.moss.charactersheet.actions.api.MenuBar;
import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.gui.animal.AnimalGui;
import org.moss.charactersheet.gui.character.info.CharInfoGui;
import org.moss.charactersheet.gui.character.feats.FeatsGui;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.gui.character.inv.InventoryGui;
import org.moss.charactersheet.gui.character.magic.MagicGui;
import org.moss.charactersheet.gui.character.skills.SkillsGui;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class SheetFrame extends JFrame {

    @Autowired
    CharInfoGui charInfoGen;
    @Autowired
    AnimalGui animalGen;
    @Autowired
    MagicGui magicGen;
    @Autowired
    InventoryGui invGen;
    @Autowired
    FeatsGui featsGen;
    @Autowired
    SkillsGui skillsGen;

    private List<Component> characterInfoComponents = new ArrayList<>();

    private SpringLayout layout = new SpringLayout();

    // Tab containers in the order the pages will be displayed on the app
    private Container basicCharacterInfoPage = new JPanel(layout);
    private Container skillsPage = new JPanel(layout);
    private Container featsPage = new JPanel(layout);
    private Container inventoryPage = new JPanel(layout);
    private Container magicPage = new JPanel(layout);
    private Container animalInfoPage = new JPanel(layout);

    @PostConstruct
    public void init() {
        // GUI Generators
        final List<GenerateGui> generators = Arrays.asList(charInfoGen, skillsGen, featsGen, invGen, magicGen, animalGen);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Sheet");

        final Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedPanel = new JTabbedPane();

        JScrollPane pane1 = new JScrollPane();
        basicCharacterInfoPage.setPreferredSize(new Dimension(800, 1000));
        pane1.setViewportView(basicCharacterInfoPage);

        JScrollPane pane2 = new JScrollPane();
        skillsPage.setPreferredSize(new Dimension(800, Skill.getValues().size() * 25));
        pane2.setViewportView(skillsPage);

        JScrollPane pane6 = new JScrollPane();
        animalInfoPage.setPreferredSize(new Dimension(800, 1000));
        pane6.setViewportView(animalInfoPage);

        tabbedPanel.addTab("Overview", pane1);
        tabbedPanel.addTab("Skills", pane2);
        tabbedPanel.addTab("Feats and Special Abilities", featsPage);
        tabbedPanel.addTab("Inventory", inventoryPage);
        tabbedPanel.addTab("Magic", magicPage);
        tabbedPanel.addTab("Animals", pane6);

        contentPane.add(tabbedPanel);
        setJMenuBar(new MenuBar(generators, characterInfoComponents, tabbedPanel).createMenuBar());

        this.setPreferredSize(new Dimension(920, 1000));

        // Generate components for first page
        characterInfoComponents.add(charInfoGen.generate());
        characterInfoComponents.forEach((comp) -> basicCharacterInfoPage.add(comp));

        // Generate panels for subsequent pages
        skillsPage.add(skillsGen.generate());
        featsPage.add(featsGen.generate());
        inventoryPage.add(invGen.generate());
        magicPage.add(magicGen.generate());
        animalInfoPage.add(animalGen.generate());

        // Pack components
        pack();
    }
}
