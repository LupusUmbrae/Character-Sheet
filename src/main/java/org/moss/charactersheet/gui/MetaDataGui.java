package org.moss.charactersheet.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.moss.charactersheet.impl.FullCharacter;
import org.moss.charactersheet.impl.CharacterInfo;
import org.moss.charactersheet.impl.enums.Alignment;
import org.moss.charactersheet.impl.enums.Gender;
import org.moss.charactersheet.impl.enums.Size;

/**
 * Generator for character meta data
 * @author Jacq
 *
 */
public class MetaDataGui implements GenerateGui
{
	private static final Map<String, Component> ELEMENTS = new LinkedHashMap<>();
	private static final int[] PER_LINE = new int[]{2,6,5};

	private JPanel metaData = new JPanel(new GridBagLayout());
	private GridBagConstraints mdConsts = new GridBagConstraints();

	static {
		ELEMENTS.put("Character Name", new JTextField(20));
		ELEMENTS.put("Player Name", new JTextField(20));
		ELEMENTS.put("Class", new JTextField(16));
		ELEMENTS.put("Level", new JTextField(4));
		ELEMENTS.put("ECL", new JTextField(4));
		ELEMENTS.put("Race", new JTextField(8));
		ELEMENTS.put("Size", new JComboBox<Size>(Size.values()));
		ELEMENTS.put("Gender", new JComboBox<Gender>(Gender.values()));
		ELEMENTS.put("Alignment", new JComboBox<Alignment>(Alignment.values()));
		ELEMENTS.put("Religion", new JTextField(12));
		ELEMENTS.put("Height", new JTextField(5));
		ELEMENTS.put("Weight", new JTextField(5));
		ELEMENTS.put("Looks", new JTextField(12));
	}

	/**
	 * Creates new generator
	 */
	public MetaDataGui()
	{
	}

	@Override
	public JPanel generate()
	{
		metaData.setName("MetaData");
		GridBagConstraints consts = new GridBagConstraints();
		consts.gridx = 0;
		consts.gridy = 0;
		mdConsts.gridx = 0;
		mdConsts.gridy = 0;
		JPanel line = new JPanel();
		int lineCount = 0;
		int elementCount = 1;
		for (Entry<String, Component> entry : ELEMENTS.entrySet()) {
			String compName = entry.getKey();
			Component comp = entry.getValue();
			comp.setName(compName);

			JLabel label = new JLabel(compName);
			line.add(label, consts);
			consts.gridy++;
			line.add(comp, consts);
			consts.gridx++;
			consts.gridy = 0;
			if (elementCount == PER_LINE[lineCount]) {
				// Add current line
				metaData.add(line, mdConsts);
				// Reset
				consts.gridx = 0;
				consts.gridy = 0;
				line = new JPanel();
				elementCount = 1;
				// Increase count and consts
				mdConsts.gridy++;
				lineCount++;
			} else {
				elementCount++;
			}
		}
		return metaData;
	}

	@Override
	public FullCharacter save() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		CharacterInfo metaInfo = new CharacterInfo();
		for (Component comp : ELEMENTS.values()) {
			String compName = comp.getName().replace(" ", "");
			for (Field field : CharacterInfo.class.getDeclaredFields()) {
				String fieldName = field.getName();
				field.setAccessible(true);
				Object val = null;
				if (fieldName.equalsIgnoreCase(compName) ||
						fieldName.equalsIgnoreCase(compName.replace("s", "z"))) {
					if (comp instanceof JTextField) {
						val = ((JTextField) comp).getText();
						if (field.getType().isPrimitive()) {
							val = Integer.parseInt(val.toString());
						}
					} else if (comp instanceof JComboBox<?>) {
						val = ((JComboBox<?>) comp).getSelectedItem();
					}
					field.set(metaInfo, val);
					break;
				}
			}
		}
		return new FullCharacter(metaInfo, null, null, null);
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}
}
