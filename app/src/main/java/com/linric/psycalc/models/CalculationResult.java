package com.linric.psycalc.models;

import com.linric.psycalc.enums.FieldChoiceDesignator;

/**
 * Created by jbueno on 4/1/2018.
 */
public class CalculationResult {

    private double value;
    private String display;

    public CalculationResult(double value, String display) {
        this.value = value;
        this.display = display;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
