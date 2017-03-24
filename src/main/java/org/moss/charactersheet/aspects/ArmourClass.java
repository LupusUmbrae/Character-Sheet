package org.moss.charactersheet.aspects;

import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.util.ListenerFactory;


public class ArmourClass extends AbstractAspect {
    private JFormattedTextField armour;
    private JFormattedTextField shield;
    private JTextField dex;
    private JFormattedTextField size;
    private JFormattedTextField natural;
    private JFormattedTextField deflection;

    private JTextField flat;
    private JTextField touch;

    private int armourClass;
    private int touchScore;
    private int flatScore;

    public ArmourClass(JTextField total, JFormattedTextField armour, JFormattedTextField shield, JTextField dex,
                       JFormattedTextField size, JFormattedTextField natural, JFormattedTextField deflection,
                       JFormattedTextField misc, JTextField flat, JTextField touch) {
        super(total, misc);
        this.armour = armour;
        this.shield = shield;
        this.dex = dex;
        this.size = size;
        this.natural = natural;
        this.deflection = deflection;
        this.flat = flat;
        this.touch = touch;

        setupFormatters();
        calculate();
    }

    @Override
    public void update(Object key, Object value) {
        if (key.equals(AbilityScore.DEX)) {
            this.dex.setText(value.toString());
        }
        calculate();
    }

    @Override
    protected void setupFormatters() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        armour.setFormatterFactory(new DefaultFormatterFactory(formatter));
        armour.setColumns(2);
        armour.addPropertyChangeListener("value", this);

        shield.setFormatterFactory(new DefaultFormatterFactory(formatter));
        shield.setColumns(2);
        shield.addPropertyChangeListener("value", this);

        size.setFormatterFactory(new DefaultFormatterFactory(formatter));
        size.setColumns(2);
        size.addPropertyChangeListener("value", this);

        natural.setFormatterFactory(new DefaultFormatterFactory(formatter));
        natural.setColumns(2);
        natural.addPropertyChangeListener("value", this);

        deflection.setFormatterFactory(new DefaultFormatterFactory(formatter));
        deflection.setColumns(2);
        deflection.addPropertyChangeListener("value", this);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        ListenerFactory.registerListener(AbilityScore.DEX, this);
    }

    @Override
    protected void calculate() {
        armourClass = 10;
        flatScore = 0;
        touchScore = 0;

        if (!armour.getText().isEmpty()) {
            armourClass += Integer.parseInt(armour.getText());
            touchScore -= Integer.parseInt(armour.getText());
        }

        if (!shield.getText().isEmpty()) {
            armourClass += Integer.parseInt(shield.getText());
            touchScore -= Integer.parseInt(shield.getText());
        }

        if (!dex.getText().isEmpty()) {
            armourClass += Integer.parseInt(dex.getText());
            flatScore -= Integer.parseInt(dex.getText());
        }

        if (!size.getText().isEmpty()) {
            armourClass += Integer.parseInt(size.getText());
        }

        if (!natural.getText().isEmpty()) {
            armourClass += Integer.parseInt(natural.getText());
            touchScore -= Integer.parseInt(natural.getText());
        }

        if (!deflection.getText().isEmpty()) {
            armourClass += Integer.parseInt(deflection.getText());
        }

        if (!misc.getText().isEmpty()) {
            armourClass += Integer.parseInt(misc.getText());
        }

        flatScore += armourClass;
        touchScore += armourClass;

        flat.setText(Integer.toString(flatScore));
        touch.setText(Integer.toString(touchScore));
        total.setText(Integer.toString(armourClass));
    }
}
