package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.Save;
import org.moss.charactersheet.util.ListenerFactory;


public class Saves implements Aspects
{
    private JTextField total;
    private JFormattedTextField base;
    private JTextField ability;
    private JFormattedTextField magic;
    private JFormattedTextField misc;
    private JFormattedTextField temp;

    private Save save;

    private int saveScore;


    public Saves(Save save, JTextField total, JFormattedTextField base, JTextField ability, JFormattedTextField magic,
                 JFormattedTextField misc, JFormattedTextField temp)
    {

        this.save = save;
        this.total = total;
        this.base = base;
        this.ability = ability;
        this.magic = magic;
        this.misc = misc;
        this.temp = temp;

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        base.setFormatterFactory(new DefaultFormatterFactory(formatter));
        base.setColumns(2);
        base.addPropertyChangeListener("value", this);

        magic.setFormatterFactory(new DefaultFormatterFactory(formatter));
        magic.setColumns(2);
        magic.addPropertyChangeListener("value", this);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        temp.setFormatterFactory(new DefaultFormatterFactory(formatter));
        temp.setColumns(2);
        temp.addPropertyChangeListener("value", this);

        ListenerFactory.registerListener(save.getAbility(), this);
    }

    @Override
    public void update(Object key, Object value)
    {
        if (save.getAbility().equals(key))
        {
            this.ability.setText(value.toString());
        }
        calcSave();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        calcSave();
    }

    private void calcSave()
    {
        saveScore = 0;

        if (!base.getText().isEmpty())
        {
            saveScore += Integer.parseInt(base.getText());
        }

        if (!ability.getText().isEmpty())
        {
            saveScore += Integer.parseInt(ability.getText());
        }

        if (!magic.getText().isEmpty())
        {
            saveScore += Integer.parseInt(magic.getText());
        }

        if (!misc.getText().isEmpty())
        {
            saveScore += Integer.parseInt(misc.getText());
        }

        if (!temp.getText().isEmpty())
        {
            saveScore += Integer.parseInt(temp.getText());
        }

        total.setText(Integer.toString(saveScore));
    }

}
