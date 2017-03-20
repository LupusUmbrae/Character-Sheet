package org.moss.charactersheet.aspects;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.moss.charactersheet.aspects.enums.Skill;
import org.moss.charactersheet.util.ListenerFactory;

/**
 * SkillInfo holds map of Skill and the corresponding info such as the total bonus, ranks
 * and CS boolean etc.
 */
public class SkillInfo extends AbstractAspect {
    private JCheckBox classSkill;
    private JTextField ability;
    private JFormattedTextField ranks;

    private Skill skill;
    private int skillScore;

    protected static final Map<Skill, SkillInfo> SKILL_WITH_INFO_MAP = new HashMap<>();

    /**
     * Creates new SkillInfo object for given skill and adds this to the <code>SKILL_WITH_INFO_MAP</code>
     * @param skill
     * @param classSkillCB
     * @param total
     * @param ability
     * @param ranks
     * @param misc
     */
    public SkillInfo(Skill skill, JCheckBox classSkillCB, JTextField total, JTextField ability,
                     JFormattedTextField ranks, JFormattedTextField misc) {
        super(total, misc);
        this.skill = skill;
        this.classSkill = classSkillCB;
        this.total = total;
        this.ability = ability;
        this.ranks = ranks;
        this.misc = misc;

        setupFormatters();
        calculate();
        SKILL_WITH_INFO_MAP.put(skill, this);
    }

    @Override
    protected void setupFormatters() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setMaximumIntegerDigits(2);
        NumberFormatter formatter = new NumberFormatter(numberFormat);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);

        ranks.setFormatterFactory(new DefaultFormatterFactory(formatter));
        ranks.setColumns(2);
        ranks.addPropertyChangeListener("value", this);

        misc.setFormatterFactory(new DefaultFormatterFactory(formatter));
        misc.setColumns(2);
        misc.addPropertyChangeListener("value", this);

        ListenerFactory.registerListener(skill.getAbility(), this);
    }

    @Override
    protected void calculate() {
        skillScore = 0;
        if (!ability.getText().isEmpty()) {
            skillScore += Integer.parseInt(ability.getText());
        }
        if (!ranks.getText().isEmpty()) {
        	int numRanks = Integer.parseInt(ranks.getText());
            skillScore += numRanks;
        }
        if (!misc.getText().isEmpty()) {
            skillScore += Integer.parseInt(misc.getText());
        }
        total.setText(Integer.toString(skillScore));
    }

    @Override
    public void update(Object key, Object value) {
        if (skill.getAbility().equals(key)) {
            this.ability.setText(value.toString());
        }
        calculate();
    }
}
