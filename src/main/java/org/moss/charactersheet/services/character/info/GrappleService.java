package org.moss.charactersheet.services.character.info;

import static org.moss.charactersheet.util.StatsHelper.extractStatsFromPanel;

import java.util.Map;

import javax.swing.JPanel;

import org.moss.charactersheet.model.character.info.GrappleStats;
import org.moss.charactersheet.services.SaveService;
import org.springframework.stereotype.Service;

/**
 * Service that provides save and load logic for character {@link GrappleStats}
 */
@Service
public class GrappleService implements SaveService<GrappleStats> {
    public static final String BAB = "BAB";
    public static final String TOTAL = "Total";
    public static final String SIZE = "Size Mod";
    public static final String STR = "Strength Mod";
    public static final String MISC = "Misc Mod";

    @Override
    public GrappleStats save(JPanel panel) {
        Map<String, Integer> stats = extractStatsFromPanel(panel);
        return new GrappleStats(
                stats.get(TOTAL),
                stats.get(BAB),
                stats.get(STR),
                stats.get(SIZE),
                stats.get(MISC));
    }

    @Override
    public void load() {

    }
}
