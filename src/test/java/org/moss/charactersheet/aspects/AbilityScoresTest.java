package org.moss.charactersheet.aspects;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;

import java.beans.PropertyChangeListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.moss.charactersheet.aspects.enums.AbilityScore;


@RunWith(MockitoJUnitRunner.class)
public class AbilityScoresTest {

    private static final String EMPTY_STRING = "";

    @Mock
    private JTextField total;
    @Mock
    private JFormattedTextField base;
    @Mock
    private JFormattedTextField enhance;
    @Mock
    private JFormattedTextField misc;
    @Mock
    private JFormattedTextField miscNeg;
    @Mock
    private JTextField mod;

    @Captor
    ArgumentCaptor<String> modCaptor;


    @Before
    public void setup() {
        setupSingleFieldMock(base);
        setupSingleFieldMock(enhance);
        setupSingleFieldMock(misc);
        setupSingleFieldMock(miscNeg);
    }

    private void setupSingleFieldMock(JFormattedTextField cellField) {
        doCallRealMethod().when(cellField).setFormatterFactory(any(DefaultFormatterFactory.class));
        doCallRealMethod().when(cellField).setColumns(anyInt());
        doCallRealMethod().when(cellField).addPropertyChangeListener(any(PropertyChangeListener.class));
        when(cellField.getText()).thenReturn(EMPTY_STRING);
    }

    @Test
    public void testCalculations() {
        AbilityScores scores = new AbilityScores(AbilityScore.STR, total, base, enhance, misc, miscNeg, mod);

        int modExpected = -5;
        for (int i = 1; i < 46; i++) {
            if ((i % 2) == 0) {
                modExpected++;
            }

            when(base.getText()).thenReturn(Integer.toString(i));
            scores.propertyChange(null);

            Mockito.verify(mod, Mockito.times(i + 1)).setText(modCaptor.capture());

            String modString = modCaptor.getValue();

            int modValue = Integer.parseInt(modString);

            assertThat(modValue, is(modExpected));
        }
    }
}
