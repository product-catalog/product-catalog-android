package com.pcatalog.productcatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.NumberPicker;

/**
 * UI component for double (floating point) values. Can be used
 * for money and other measures.
 */
public class DoublePicker
        extends NumberPicker {

    private int decimals;
    private NumberPicker integerPicker;
    private NumberPicker fractionPicker;

    public DoublePicker(
            Context context) {

        super(context);

        LayoutInflater
                .from(
                        context)
                .inflate(
                        R.layout.double_picker,
                        this);

        integerPicker =
                (NumberPicker) findViewById(
                        R.id.integer_picker);

        fractionPicker =
                (NumberPicker) findViewById(
                        R.id.fraction_picker);
    }

    public int getDecimals() {

        return decimals;
    }

    /**
     * Sets the amount of digits after separator.
     *
     * @param decimals Anount of decimals.
     */
    public void setDecimals(final int decimals) {

        this.decimals = decimals;

        this.setFormatter(new DoublePicker.Formatter() {

            @Override
            public String format(int i) {

                return String.format(
                        "%." + decimals + "f",
                        i);
            }
        });
    }

    public void setValue(double value) {

        integerPicker.setValue((int) value);

        fractionPicker.setValue(
                Integer.valueOf(
                        String
                                .valueOf(value)
                                .split(".")
                                [1]));
    }

    public NumberPicker getIntegerPicker() {
        return integerPicker;
    }

    public void setIntegerPicker(NumberPicker integerPicker) {
        this.integerPicker = integerPicker;
    }

    public NumberPicker getFractionPicker() {
        return fractionPicker;
    }

    public void setFractionPicker(NumberPicker fractionPicker) {
        this.fractionPicker = fractionPicker;
    }
}
