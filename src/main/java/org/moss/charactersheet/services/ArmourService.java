package org.moss.charactersheet.services;

import static org.moss.charactersheet.util.StatsHelper.extractStatsFromPanel;

import java.util.Map;

import javax.swing.JPanel;

import org.moss.charactersheet.impl.ArmourClassStats;
import org.springframework.stereotype.Service;

/**
 * Created by j.train on 22/03/2017.
 */
@Service
public class ArmourService implements SaveService<ArmourClassStats> {
    private JPanel armourPanel;
    public static final String TOTAL = "Total";
    public static final String BASE = "Base";
    public static final String ARMOUR_BONUS = "Armour Bonus";
    public static final String SHIELD_BONUS = "Shield Bonus";
    public static final String DEX_MOD = "Dex Mod";
    public static final String SIZE_MOD = "Size Mod";
    public static final String FLAT_AC = "Flat AC";
    public static final String NATURAL_ARMOUR = "Nat AC";
    public static final String DEFLECT_MOD = "Deflection Mod";
    public static final String TOUCH_AC = "Touch AC";
    public static final String MISC_MOD = "Misc Mod";

    @Override
    public ArmourService withPanel(JPanel panel) {
        this.armourPanel = panel;
        return this;
    }

    @Override
    public ArmourClassStats save() {
        Map<String, Integer> stats = extractStatsFromPanel(armourPanel);
        return new ArmourClassStats(
                stats.get(BASE),
                stats.get(ARMOUR_BONUS),
                stats.get(SHIELD_BONUS),
                stats.get(DEX_MOD),
                stats.get(SIZE_MOD),
                stats.get(NATURAL_ARMOUR),
                stats.get(DEFLECT_MOD),
                stats.get(MISC_MOD),
                stats.get(TOUCH_AC),
                stats.get(FLAT_AC));
    }

    @Override
    public void load() {
        // TODO Auto-generated method stub

    }
}
