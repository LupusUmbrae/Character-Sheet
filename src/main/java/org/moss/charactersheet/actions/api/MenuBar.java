package org.moss.charactersheet.actions.api;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import org.moss.charactersheet.gui.GenerateGui;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuBar {

	private final List<GenerateGui> generators;
	private final List<Component> components;
	private Container container;

	/** Constructs menu bar. Contains New [character, animal], Save, Load */
	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);

		JMenu newMenu = new JMenu("New...");
		newMenu.setMnemonic(KeyEvent.VK_N);
		JMenuItem charItem = new JMenuItem("Character", KeyEvent.VK_C);
		charItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetTextFields(container);
			}

			private void resetTextFields(Container c) {
				Component[] cpts = c.getComponents();
				for (Component cpt : cpts) {
					if (cpt instanceof Container) {
						resetTextFields((Container) cpt);
					} else if (cpt instanceof JTextField) {
						((JTextField)cpt).setText("");
					}
				}
			}
		});
		JMenuItem aniItem = new JMenuItem("Animal", KeyEvent.VK_A);
		newMenu.add(charItem);
		newMenu.add(aniItem);

		JMenuItem saveItem = new JMenuItem("Save", KeyEvent.VK_S);
		saveItem.addActionListener(e -> SaveAction.save(container, generators));
		JMenuItem loadItem = new JMenuItem("Load", KeyEvent.VK_L);
		loadItem.addActionListener(e -> LoadAction.load(container, components));

		menu.add(newMenu);
		menu.add(loadItem);
		menu.add(saveItem);
		return menuBar;
	}
}
