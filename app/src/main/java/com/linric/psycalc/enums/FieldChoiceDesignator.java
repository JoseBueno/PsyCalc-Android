package com.linric.psycalc.enums;

/**
 *
 * Created by jbueno on 3/29/2018.
 */
public enum FieldChoiceDesignator {
    TemperatureDryBulb("tdb", 0),
    TemperatureWetBulb("twb", 1),
    RelativeHumidity("%RH", 2),
    Heat("Heat", 3),
    Dewpoint("Dewpoint", 4),
    Moisture("Moisture", 5),
    Density("Density", 6),
    Pressure("Pressure", 7),
    PPMw("PPMw", 8),
    PPMv("PPMv", 9),
    Mass("Mass", 10);

    public static FieldChoiceDesignator fromInteger(int x) {
        switch(x) {
            case 0: return TemperatureDryBulb;
            case 1: return TemperatureWetBulb;
            case 2: return RelativeHumidity;
            case 3: return Heat;
            case 4: return Dewpoint;
            case 5: return Moisture;
            case 6: return Density;
            case 7: return Pressure;
            case 8: return PPMw;
            case 9: return PPMv;
            case 10: return Mass;
            default: return TemperatureDryBulb;
        }
    }

    private final String displayName;
    private final int index;


    FieldChoiceDesignator(String displayName, int index) {
        this.displayName = displayName;
        this.index = index;
    }

    @Override
    public String toString(){
        return displayName;
    }

    public int getIndex(){
        return index;
    }
}
