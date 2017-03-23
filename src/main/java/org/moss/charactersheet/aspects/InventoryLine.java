package org.moss.charactersheet.aspects;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.gui.character.inv.InventoryGui;

public class InventoryLine {
	public static final String WEIGHT_CHANGE = "value";
    private JTextField textItem;
	private JTextField textLocation;
	private JFormattedTextField textWeight;
	private JButton btnDelete;

	private JPanel gear;

	public InventoryLine(JPanel gear, GridBagConstraints constraints,
			InventoryGui listener, NumberFormatter formatter) {
		this.gear = gear;

		textItem = new JTextField(20);
		gear.add(textItem, constraints);

		textLocation = new JTextField(20);
		constraints.gridx += 2;
		gear.add(textLocation, constraints);

		textWeight = new JFormattedTextField();
		constraints.gridx += 2;
		gear.add(textWeight, constraints);

		textWeight.setFormatterFactory(new DefaultFormatterFactory(
				formatter));
		textWeight.setColumns(3);
		textWeight.addPropertyChangeListener(WEIGHT_CHANGE, listener);

		btnDelete = new JButton(new ImageIcon(this.getClass().getResource(
				"/images/small-delete-icon.jpg")));
		btnDelete.setBorder(null);
		btnDelete.setBackground(null);
		btnDelete.addActionListener(listener);
		btnDelete.setActionCommand("DeleteItem");
		constraints.gridx++;
		gear.add(btnDelete, constraints);

	}

	public void removeItemFromPanel() {
		gear.remove(textItem);
		gear.remove(textLocation);
		gear.remove(textWeight);
		gear.remove(btnDelete);
	}

	public JButton getDeleteButton() {
		return this.btnDelete;
	}

	public void disableDelete() {
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
	}

	public void enableDelete() {
		btnDelete.setEnabled(true);
		btnDelete.setVisible(true);
	}
}