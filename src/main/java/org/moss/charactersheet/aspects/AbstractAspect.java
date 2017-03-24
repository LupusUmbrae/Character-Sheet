package org.moss.charactersheet.aspects;

import java.beans.PropertyChangeEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public abstract class AbstractAspect implements Aspects {
    protected JTextField total;
    protected JFormattedTextField misc;

    protected AbstractAspect(JTextField total, JFormattedTextField misc) {
        this.total = total;
        this.misc = misc;
    }

    /** Method should always be called at the last stage of initialisation of the aspect in order to set up the
     *  formatters for all represented fields.
     */
    protected abstract void setupFormatters();

    /** Method should always be called at the last stage of initialisation of the aspect in order to initialise
     *  attribute values for each of the represented fields.
     */
    protected abstract void calculate();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        calculate();
    }
}
