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
import org.moss.charactersheet.gui.AnimalGui;
import org.moss.charactersheet.gui.CharInfoGui;
import org.moss.charactersheet.gui.FeatsGui;
import org.moss.charactersheet.gui.GenerateGui;
import org.moss.charactersheet.gui.InventoryGui;
import org.moss.charactersheet.gui.MagicGui;
import org.moss.charactersheet.gui.SkillsGui;
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

    private List<Component> page1Components = new ArrayList<>();
    private List<Component> page2Components = new ArrayList<>();
    private List<Component> page3Components = new ArrayList<>();
    private List<Component> page4Components = new ArrayList<>();
    private List<Component> page5Components = new ArrayList<>();
    private List<Component> page6Components = new ArrayList<>();

    private SpringLayout layout;
    /**
     * Page 1
     */
    private Container tabPanel1;
    /**
     * Page 2
     */
    private Container tabPanel2;
    /**
     * Page 3
     */
    private Container tabPanel3;
    /**
     * Page 4
     */
    private Container tabPanel4;
    /**
     * Page 5
     */
    private Container tabPanel5;
    /**
     * Page 6
     */
    private Container tabPanel6;

    @PostConstruct
    public void init() {
        // GUI Generators
        final List<GenerateGui> generators = Arrays.asList(charInfoGen, skillsGen, featsGen,
                invGen, magicGen, animalGen);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Sheet");

        final Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        layout = new SpringLayout();

        JTabbedPane tabbedPanel = new JTabbedPane();

        tabPanel1 = new JPanel(layout);
        tabPanel2 = new JPanel(layout);
        tabPanel3 = new JPanel(layout);
        tabPanel4 = new JPanel(layout);
        tabPanel5 = new JPanel(layout);
        tabPanel6 = new JPanel(layout);

        JScrollPane pane1 = new JScrollPane();
        tabPanel1.setPreferredSize(new Dimension(800, 1000));
        pane1.setViewportView(tabPanel1);

        JScrollPane pane2 = new JScrollPane();
        tabPanel2.setPreferredSize(new Dimension(800, Skill.getValues().size() * 25));
        pane2.setViewportView(tabPanel2);

        JScrollPane pane6 = new JScrollPane();
        tabPanel6.setPreferredSize(new Dimension(800, 1000));
        pane6.setViewportView(tabPanel6);

        tabbedPanel.addTab("Overview", pane1);
        tabbedPanel.addTab("Skills", pane2);
        tabbedPanel.addTab("Feats and Special Abilities", tabPanel3);
        tabbedPanel.addTab("Inventory", tabPanel4);
        tabbedPanel.addTab("Magic", tabPanel5);
        tabbedPanel.addTab("Animals", pane6);

        contentPane.add(tabbedPanel);
        setJMenuBar(new MenuBar(generators, page1Components, tabbedPanel).createMenuBar());

        this.setPreferredSize(new Dimension(920, 1000));

        /*
         * Generate components for first page
         */
        page1Components.add(charInfoGen.generate());

        /*
         * Generate components for second page
         */
        page2Components.add(skillsGen.generate());

        /*
         * Generate components for third page
         */
        page3Components.add(featsGen.generate());

        /*
         * Generate components for fourth page
         */
        page4Components.add(invGen.generate());

        /*
         * Generate components for fifth page
         */
        page5Components.add(magicGen.generate());

        /*
         * Generate components for sixth page
         */
        page6Components.add(animalGen.generate());

        /*
         * Add all components to appropriate tab panels
         */
        addAllComponents();
    }

    private void addAllComponents() {
        for (Component curComp : page1Components) {
            tabPanel1.add(curComp);
        }

        for (Component curComp : page2Components) {
            tabPanel2.add(curComp);
        }

        for (Component curComp : page3Components) {
            tabPanel3.add(curComp);
        }

        for (Component curComp : page4Components) {
            tabPanel4.add(curComp);
        }

        for (Component curComp : page5Components) {
            tabPanel5.add(curComp);
        }

        for (Component curComp : page6Components) {
            tabPanel6.add(curComp);
        }
        pack();
    }
}
