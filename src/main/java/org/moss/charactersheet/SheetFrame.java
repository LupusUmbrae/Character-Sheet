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
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.gui.animal.AnimalGui;
import org.moss.charactersheet.gui.character.feats.FeatsGui;
import org.moss.charactersheet.gui.character.info.CharInfoGui;
import org.moss.charactersheet.gui.character.inv.InventoryGui;
import org.moss.charactersheet.gui.character.magic.MagicGui;
import org.moss.charactersheet.gui.character.skills.SkillsGui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
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

    private List<Component> page1Components = new ArrayList<>();
    private List<Component> page2Components = new ArrayList<>();
    private List<Component> page3Components = new ArrayList<>();
    private List<Component> page4Components = new ArrayList<>();
    private List<Component> page5Components = new ArrayList<>();
    private List<Component> page6Components = new ArrayList<>();

    private SpringLayout layout = new SpringLayout();

    private Container tabOneCharacterInfo = new JPanel(layout);
    private Container tabTwoSkills = new JPanel(layout);
    private Container tabThreeFeats = new JPanel(layout);
    private Container tabFourInventory = new JPanel(layout);
    private Container tabFiveMagic = new JPanel(layout);
    private Container tabSixAnimal = new JPanel(layout);

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
        tabOneCharacterInfo.setPreferredSize(new Dimension(800, 1000));
        pane1.setViewportView(tabOneCharacterInfo);

        JScrollPane pane2 = new JScrollPane();
        tabTwoSkills.setPreferredSize(new Dimension(800, Skill.getValues().size() * 25));
        pane2.setViewportView(tabTwoSkills);

        JScrollPane pane6 = new JScrollPane();
        tabSixAnimal.setPreferredSize(new Dimension(800, 1000));
        pane6.setViewportView(tabSixAnimal);

        tabbedPanel.addTab("Overview", pane1);
        tabbedPanel.addTab("Skills", pane2);
        tabbedPanel.addTab("Feats and Special Abilities", tabThreeFeats);
        tabbedPanel.addTab("Inventory", tabFourInventory);
        tabbedPanel.addTab("Magic", tabFiveMagic);
        tabbedPanel.addTab("Animals", pane6);

        contentPane.add(tabbedPanel);
        setJMenuBar(new MenuBar(generators, page1Components, tabbedPanel).createMenuBar());

        this.setPreferredSize(new Dimension(920, 1000));

        // Generate components for each of the tab pages
        page1Components.add(charInfoGen.generate());
        page2Components.add(skillsGen.generate());
        page3Components.add(featsGen.generate());
        page4Components.add(invGen.generate());
        page5Components.add(magicGen.generate());
        page6Components.add(animalGen.generate());

        addAllComponents();
    }

    private void addAllComponents() {
        page1Components.forEach(comp -> tabOneCharacterInfo.add(comp));
        page2Components.forEach(comp -> tabTwoSkills.add(comp));
        page3Components.forEach(comp -> tabThreeFeats.add(comp));
        page4Components.forEach(comp -> tabFourInventory.add(comp));
        page5Components.forEach(comp -> tabFiveMagic.add(comp));
        page6Components.forEach(comp -> tabSixAnimal.add(comp));

        pack();
    }
}
