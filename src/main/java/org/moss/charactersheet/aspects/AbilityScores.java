package org.moss.charactersheet.aspects;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.AbilityScore;
import org.moss.charactersheet.util.ListenerFactory;


public class AbilityScores extends AbstractAspect {
    private static Map<AbilityScore, AbilityScores> ABILITY_SCORES = new HashMap<>();

    private JFormattedTextField base;
    private JFormattedTextField enhance;
    private JFormattedTextField miscNeg;
    private JTextField mod;

    private AbilityScore ability;
    private int totalScore = 0;
    private int modScore = 0;

    public AbilityScores(AbilityScore ability, JTextField total, JFormattedTextField base, JFormattedTextField enhance,
                         JFormattedTextField misc, JFormattedTextField miscNeg, JTextField mod) {
        super(total, misc);
        this.base = base;
        this.enhance = enhance;
        this.miscNeg = miscNeg;
        this.mod = mod;
        this.ability = ability;
        setupFormatters();
        calculate();
    }

    @Override
    public void update(Object key, Object value) {
        // TODO Auto-generated method stub
    }

    @Override
    protected void setupFormatters() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        base.setFormatterFactory(new DefaultFormatterFactory(formatter));
        base.setColumns(2);
        base.addPropertyChangeListener("value", this);

        enhance.setFormatterFactory(new DefaultFormatterFactory(formatter));
        enhance.setColumns(2);
        enhance.addPropertyChangeListener("value", this);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        miscNeg.setFormatterFactory(new DefaultFormatterFactory(formatter));
        miscNeg.setColumns(2);
        miscNeg.addPropertyChangeListener("value", this);

        ListenerFactory.registerCaller(ability);
    }

    @Override
    protected void calculate() {
        totalScore = 0;
        if (!base.getText().isEmpty()) {
            totalScore += Integer.parseInt(base.getText());
        }

        if (!enhance.getText().isEmpty()) {
            totalScore += Integer.parseInt(enhance.getText());
        }

        if (!misc.getText().isEmpty()) {
            totalScore += Integer.parseInt(misc.getText());
        }

        if (!miscNeg.getText().isEmpty()) {
            totalScore -= Integer.parseInt(miscNeg.getText());
        }

        total.setText(Integer.toString(totalScore));

        modScore = 0;
        if (totalScore > 0) {
            if (totalScore > 10) {
                modScore = (int) Math.floor((totalScore - 10) / 2.0);
            }
            else if (totalScore < 10) {
                modScore = (int) Math.floor((totalScore - 10) / 2.0);
            }
        }
        mod.setText(Integer.toString(modScore));

        ListenerFactory.callback(this.ability, modScore);
    }

    public static Map<AbilityScore, AbilityScores> getAbilityScores() {
        return ABILITY_SCORES;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getModScore() {
        return modScore;
    }
}
