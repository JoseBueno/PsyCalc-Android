package com.linric.psycalc.enums;

/**
 *
 * Created by jbueno on 3/29/2018.
 */
public enum MeasurementSystem {
    IP("IP", 0), SI("SI", 1);

    public static MeasurementSystem fromInteger(int x) {
        switch(x) {
            case 0: return IP;
            case 1: return SI;
            default: return IP;
        }
    }

    private final String displayName;
    private final int index;

    MeasurementSystem(String displayName, int index) {
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
