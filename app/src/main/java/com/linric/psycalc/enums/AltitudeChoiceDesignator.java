package com.linric.psycalc.enums;

/**
 * Created by jbueno on 4/1/2018.
 */
public enum AltitudeChoiceDesignator {
    HeightAboveSeaLevel("Altitude", 0),
    PressureDifferential("PressureDifferential", 1),
    BarometricPressure("BarometricPressure", 2),
    PressureInVacuum("PressureInVacuum", 3);

    public static AltitudeChoiceDesignator fromInteger(int x) {
        switch(x) {
            case 0: return HeightAboveSeaLevel;
            case 1: return PressureDifferential;
            case 2: return BarometricPressure;
            case 3: return PressureInVacuum;
            default: return HeightAboveSeaLevel;
        }
    }

    private final String displayName;
    private final int index;


    AltitudeChoiceDesignator(String displayName, int index) {
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
