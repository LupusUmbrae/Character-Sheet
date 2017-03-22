package org.moss.charactersheet.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.InventoryLine;
import org.moss.charactersheet.interfaces.Stats;
import org.moss.charactersheet.util.ListenerFactory;
import org.moss.charactersheet.util.listeners.Accumulator;

/**
 * Generates the inventory screen. Includes:
 * <ul>
 * <li> Carry Capacity </li>
 * <li> Money </li>
 * <li> Gear </li>
 * <li> Magical Items </li>
 * </ul>
 * @author Jacq
 *
 */
public class InventoryGui implements ActionListener, PropertyChangeListener, GenerateGui
{

    private static final String WEIGHT = "weight";
    private NumberFormatter formatter;

    private static final JButton BTN_ADD_ITEM = new JButton("Add Item...");
    private int buttonY;
    private boolean buttonCreated;

    private JPanel inv = new JPanel(new GridBagLayout());
    private JPanel gear = new JPanel(new GridBagLayout());
    private JPanel misc = new JPanel(new GridBagLayout());

    private Map<JButton, InventoryLine> inventory = new HashMap<>();

    /**
     * Creates generator for inventory
     */
    public InventoryGui()
    {
        DecimalFormat numberFormat = new DecimalFormat("#,##0.00");
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMaximumIntegerDigits(3);

        this.formatter = new NumberFormatter(numberFormat);
        this.formatter.setAllowsInvalid(false);
        this.formatter.setCommitsOnValidEdit(true);
        ListenerFactory.registerCaller(WEIGHT, Accumulator.createFloatAccumulator(WEIGHT));
    }

    /**
     * Generates inventory screen
     * @return 
     */
    @Override
    public JPanel generate()
    {
        addMiscPanel();
        addGearPanel();
        addMagicItemsPanel();
        return inv;
    }

    private void addMiscPanel()
    {
        addCcPanel();
        addMoneyPanel();
        inv.add(misc);
    }

    private void addCcPanel()
    {
        JPanel carryCapPan = new JPanel(new GridBagLayout());
        carryCapPan.setBorder(BorderFactory.createTitledBorder("Carrying Capacity"));

        GridBagConstraints ccConstraints = new GridBagConstraints();
        ccConstraints.insets = new Insets(0, 2, 2, 0);

        JLabel labelLight = new JLabel("Light Load (lb)");
        carryCapPan.add(labelLight, ccConstraints);

        JTextField textLight = new JTextField(3);
        textLight.setEditable(false);
        ccConstraints.gridx = 2;
        carryCapPan.add(textLight, ccConstraints);

        JLabel labelMed = new JLabel("Medium Load (lb)");
        ccConstraints.gridx = 0;
        ccConstraints.gridy = 2;
        carryCapPan.add(labelMed, ccConstraints);

        JTextField textMed = new JTextField(3);
        textMed.setEditable(false);
        ccConstraints.gridx = 2;
        carryCapPan.add(textMed, ccConstraints);

        JLabel labelHeavy = new JLabel("Heavy Load (lb)");
        ccConstraints.gridx = 0;
        ccConstraints.gridy = 4;
        carryCapPan.add(labelHeavy, ccConstraints);

        JTextField textHeavy = new JTextField(3);
        textHeavy.setEditable(false);
        ccConstraints.gridx = 2;
        carryCapPan.add(textHeavy, ccConstraints);

        misc.add(carryCapPan);
    }

    private void addMoneyPanel()
    {
        JPanel moneyPan = new JPanel(new GridBagLayout());
        moneyPan.setBorder(BorderFactory.createTitledBorder("Money Pouch"));

        GridBagConstraints monConstraints = new GridBagConstraints();
        monConstraints.insets = new Insets(0, 2, 2, 0);

        JLabel labelCopper = new JLabel("Copper");
        moneyPan.add(labelCopper, monConstraints);

        JTextField textCopper = new JTextField(3);
        textCopper.setEditable(false);
        monConstraints.gridx = 2;
        moneyPan.add(textCopper, monConstraints);

        JLabel labelSilver = new JLabel("Silver");
        monConstraints.gridx = 0;
        monConstraints.gridy = 2;
        moneyPan.add(labelSilver, monConstraints);

        JTextField textSilver = new JTextField(3);
        textSilver.setEditable(false);
        monConstraints.gridx = 2;
        moneyPan.add(textSilver, monConstraints);

        JLabel labelGold = new JLabel("Gold");
        monConstraints.gridx = 0;
        monConstraints.gridy = 4;
        moneyPan.add(labelGold, monConstraints);

        JTextField textGold = new JTextField(3);
        textGold.setEditable(false);
        monConstraints.gridx = 2;
        moneyPan.add(textGold, monConstraints);

        JLabel labelPlat = new JLabel("Platinum");
        monConstraints.gridx = 0;
        monConstraints.gridy = 6;
        moneyPan.add(labelPlat, monConstraints);

        JTextField textPlat = new JTextField(3);
        textPlat.setEditable(false);
        monConstraints.gridx = 2;
        moneyPan.add(textPlat, monConstraints);

        misc.add(moneyPan);
    }

    private void addGearPanel()
    {
        gear.setBorder(BorderFactory.createTitledBorder("Gear"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0, 2, 2, 0);

        putItemLabelsOnPanel(constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;

        for (int i = 0; i < 10; i++)
        {
            InventoryLine initialItem = new InventoryLine(gear, constraints, this, formatter);
            inventory.put(initialItem.getDeleteButton(), initialItem);
            constraints.gridx = 2;
            constraints.gridy++;
        }

        putBtnAddItemOnPanel(constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        inv.add(gear, constraints);
    }

    private void putItemLabelsOnPanel(GridBagConstraints constraints)
    {
        JLabel labelItem = new JLabel("Item");
        constraints.gridy = 2;
        constraints.gridx = 2;
        gear.add(labelItem, constraints);

        JLabel labelLoc = new JLabel("Location");
        constraints.gridx = 4;
        gear.add(labelLoc, constraints);

        JLabel labelWeight = new JLabel("Weight");
        constraints.gridx = 6;
        gear.add(labelWeight, constraints);
    }

    private void putBtnAddItemOnPanel(GridBagConstraints constraints)
    {
        if (!buttonCreated)
        {
            BTN_ADD_ITEM.addActionListener(this);
            BTN_ADD_ITEM.setActionCommand("AddItem");

            gear.add(BTN_ADD_ITEM, constraints);
            buttonCreated = true;
        }
        buttonY = constraints.gridy;
    }

    private void addMagicItemsPanel()
    {
        JPanel magicPan = new JPanel(new GridBagLayout());
        magicPan.setBorder(BorderFactory.createTitledBorder("Magical Items"));

        magicPan.setAlignmentX(0);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 0, 2, 0);

        JLabel labelHead = new JLabel("Head");
        magicPan.add(labelHead, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JTextField textHead = new JTextField(20);
        magicPan.add(textHead, constraints);

        constraints.gridy = 3;
        JLabel labelEyes = new JLabel("Eyes");
        magicPan.add(labelEyes, constraints);

        constraints.gridy++;
        JTextField textEyes = new JTextField(20);
        magicPan.add(textEyes, constraints);

        constraints.gridy = 6;
        JLabel labelNeck = new JLabel("Neck");
        magicPan.add(labelNeck, constraints);

        constraints.gridy++;
        JTextField textNeck = new JTextField(20);
        magicPan.add(textNeck, constraints);

        constraints.gridy = 9;
        JLabel labelShoul = new JLabel("Shoulders");
        magicPan.add(labelShoul, constraints);

        constraints.gridy++;
        JTextField textShoul = new JTextField(20);
        magicPan.add(textShoul, constraints);

        constraints.gridy = 12;
        JLabel labelRing1 = new JLabel("Ring 1");
        magicPan.add(labelRing1, constraints);

        constraints.gridy++;
        JTextField textRing1 = new JTextField(20);
        magicPan.add(textRing1, constraints);

        constraints.gridy = 15;
        JLabel labelRing2 = new JLabel("Ring 2");
        magicPan.add(labelRing2, constraints);

        constraints.gridy++;
        JTextField textRing2 = new JTextField(20);
        magicPan.add(textRing2, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        JLabel labelHands = new JLabel("Hands");
        magicPan.add(labelHands, constraints);

        constraints.gridy++;
        JTextField textHands = new JTextField(20);
        magicPan.add(textHands, constraints);

        constraints.gridy = 3;
        JLabel labelArms = new JLabel("Arms/Wrists");
        magicPan.add(labelArms, constraints);

        constraints.gridy++;
        JTextField textArms = new JTextField(20);
        magicPan.add(textArms, constraints);

        constraints.gridy = 6;
        JLabel labelBody = new JLabel("Body");
        magicPan.add(labelBody, constraints);

        constraints.gridy++;
        JTextField textBody = new JTextField(20);
        magicPan.add(textBody, constraints);

        constraints.gridy = 9;
        JLabel labelTorso = new JLabel("Torso");
        magicPan.add(labelTorso, constraints);

        constraints.gridy++;
        JTextField textTorso = new JTextField(20);
        magicPan.add(textTorso, constraints);

        constraints.gridy = 12;
        JLabel labelWaist = new JLabel("Waist");
        magicPan.add(labelWaist, constraints);

        constraints.gridy++;
        JTextField textWaist = new JTextField(20);
        magicPan.add(textWaist, constraints);

        constraints.gridy = 15;
        JLabel labelFeet = new JLabel("Feet");
        magicPan.add(labelFeet, constraints);

        constraints.gridy++;
        JTextField textFeet = new JTextField(20);
        magicPan.add(textFeet, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        inv.add(magicPan, constraints);
        constraints.insets = new Insets(0, 0, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getActionCommand().equals("AddItem"))
        {
            GridBagConstraints constraints = new GridBagConstraints();

            gear.remove(BTN_ADD_ITEM);
            gear.revalidate();
            gear.repaint();
            buttonCreated = false;

            constraints.gridx = 2;
            constraints.gridy = buttonY;
            InventoryLine newInvItem = new InventoryLine(gear, constraints, this, formatter);
            inventory.put(newInvItem.getDeleteButton(), newInvItem);

            if (inventory.size() > 1)
            {
                for (InventoryLine itemInInv : inventory.values())
                {
                    itemInInv.enableDelete();
                }
            }

            buttonY += 2;
            constraints.gridy = buttonY;
            constraints.gridx = 2;
            putBtnAddItemOnPanel(constraints);
            gear.revalidate();
            gear.repaint();
        }
        else if (e.getActionCommand().equals("DeleteItem"))
        {
            JButton src = (JButton) e.getSource();
            inventory.get(src).removeItemFromPanel();
            inventory.remove(src);
            if (inventory.size() == 1)
            {
                for (InventoryLine curLine : inventory.values())
                {
                    curLine.disableDelete();
                }
            }
            gear.revalidate();
            gear.repaint();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        if (InventoryLine.WEIGHT_CHANGE.equals(evt.getPropertyName()))
        {
            if (evt.getNewValue() != null)
            {
                ListenerFactory.callback(WEIGHT, ((Number) evt.getNewValue()).floatValue());
            }
        }
    }

	@Override
	public Stats getSaveService() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
