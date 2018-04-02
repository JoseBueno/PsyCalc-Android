package com.linric.psycalc;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.linric.psycalc.enums.AltitudeChoiceDesignator;
import com.linric.psycalc.enums.FieldChoiceDesignator;
import com.linric.psycalc.enums.MeasurementSystem;

import java.util.Set;

import static com.linric.psycalc.AppConstants.*;

/**
 * Created by jbueno on 4/1/2018.
 */
public class Settings {

    private static Settings settings;
    private final SharedPreferences sharedPreferences;

    public static Settings getInstance() {
        if (settings == null) settings = new Settings();
        return settings;
    }

    private Settings() {
        settings = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(PsyCalcApp.getInstance());
    }

    public void setInputMeasurementSystem(MeasurementSystem measurementSystem){
        sharedPreferences.edit()
                .putInt(DEFAULT_INPUT_MEASUREMENT_SYSTEM, measurementSystem.getIndex())
                .apply();
    }

    public MeasurementSystem getInputMeasurementSystem() {
        return MeasurementSystem
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_INPUT_MEASUREMENT_SYSTEM, 0));
    }

    public void setOutputMeasurementSystem(MeasurementSystem measurementSystem) {
        sharedPreferences.edit()
                .putInt(DEFAULT_OUTPUT_MEASUREMENT_SYSTEM, measurementSystem.getIndex())
                .apply();
    }

    public MeasurementSystem getOutputMeasurementSystem() {
        return MeasurementSystem
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_OUTPUT_MEASUREMENT_SYSTEM, 0));
    }


    public void setInputOneFieldChoice(FieldChoiceDesignator fieldChoiceDesignator) {
        sharedPreferences.edit()
                .putInt(DEFAULT_INPUT_ONE_FIELD_CHOICE, fieldChoiceDesignator.getIndex())
                .apply();
    }

    public FieldChoiceDesignator getInputOneFieldChoice() {
        return FieldChoiceDesignator
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_INPUT_ONE_FIELD_CHOICE, 0));
    }

    public void setInputTwoFieldChoice(FieldChoiceDesignator fieldChoiceDesignator) {
        sharedPreferences.edit()
                .putInt(DEFAULT_INPUT_TWO_FIELD_CHOICE, fieldChoiceDesignator.getIndex())
                .apply();
    }

    public FieldChoiceDesignator getInputTwoFieldChoice() {
        return FieldChoiceDesignator
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_INPUT_TWO_FIELD_CHOICE, 1));
    }

    public void setInputFlowFieldChoice(FieldChoiceDesignator fieldChoiceDesignator) {
        sharedPreferences.edit()
                .putInt(DEFAULT_INPUT_FLOW_FIELD_CHOICE, fieldChoiceDesignator.getIndex())
                .apply();
    }

    public FieldChoiceDesignator getInputFlowMeasurementSystem() {
        return FieldChoiceDesignator
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_INPUT_FLOW_FIELD_CHOICE, 0));
    }

    public void setAltitudeChoice(AltitudeChoiceDesignator altitudeChoice) {
        sharedPreferences.edit()
                .putInt(DEFAULT_ALTITUDE_FIELD_CHOICE, altitudeChoice.getIndex())
                .apply();
    }

    public AltitudeChoiceDesignator getAltitudeChoice() {
        return AltitudeChoiceDesignator
                .fromInteger(
                        sharedPreferences.getInt(DEFAULT_ALTITUDE_FIELD_CHOICE, 0));
    }
}
