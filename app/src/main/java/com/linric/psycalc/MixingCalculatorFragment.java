package com.linric.psycalc;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.linric.psycalc.adapters.CalculationResultsAdapter;
import com.linric.psycalc.enums.MeasurementSystem;
import com.linric.psycalc.interfaces.DialogOptionSelected;
import com.linric.psycalc.models.CalculationResult;

import java.util.ArrayList;

/**
 * Created by jbueno on 4/2/2018.
 */
public class MixingCalculatorFragment
        extends Fragment
        implements DialogOptionSelected {

    private EditText txtMixingAltitude;
    private EditText txtMixingInputOneA;
    private EditText txtMixingInputOneB;
    private EditText txtMixingInputOneAirflow;
    private EditText txtMixingInputTwoA;
    private EditText txtMixingInputTwoB;
    private EditText txtMixingInputTwoAirflow;

    private Button btnMixingAltitude;
    private Button btnMixingInputOneA;
    private Button btnMixingInputOneB;
    private Button btnMixingInputOneAirflow;
    private Button btnMixingInputTwoA;
    private Button btnMixingInputTwoB;
    private Button btnMixingInputTwoAirflow;

    private RecyclerView lstMixingCalcResults;

    private String[] altitudeChoices;
    private String[] inputChoices;
    private String[] airFlowChoices;
    private String[] outputChoices;

    private OptionsDialogBuilder optionsDialogBuilder;

    private int selectedAltitudeOption;
    private int selectedInputOneAOption;
    private int selectedInputOneBOption;
    private int selectedInputOneAirflowOption;
    private int selectedInputTwoAOption;
    private int selectedInputTwoBOption;
    private int selectedInputTwoAirflowOption;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_mixing_calculator, container, false);

        initUI(view);

        loadArrays(Settings.getInstance().getInputMeasurementSystem());
        initButtonLabels();
        loadEmptyResults();

        return view;

    }

    private void initUI(View view) {

        txtMixingAltitude = view.findViewById(R.id.txtMixingAltitude);
        txtMixingInputOneA = view.findViewById(R.id.txtMixingInputOneA);
        txtMixingInputOneB = view.findViewById(R.id.txtMixingInputOneB);
        txtMixingInputOneAirflow = view.findViewById(R.id.txtMixingInputOneAirflow);
        txtMixingInputTwoA = view.findViewById(R.id.txtMixingInputTwoA);
        txtMixingInputTwoB = view.findViewById(R.id.txtMixingInputTwoB);
        txtMixingInputTwoAirflow = view.findViewById(R.id.txtMixingInputTwoAirflow);

        btnMixingAltitude = view.findViewById(R.id.btnMixingAltitude);
        btnMixingInputOneA = view.findViewById(R.id.btnMixingInputOneA);
        btnMixingInputOneB = view.findViewById(R.id.btnMixingInputOneB);
        btnMixingInputOneAirflow = view.findViewById(R.id.btnMixingInputOneAirflow);
        btnMixingInputTwoA = view.findViewById(R.id.btnMixingInputTwoA);
        btnMixingInputTwoB = view.findViewById(R.id.btnMixingInputTwoB);
        btnMixingInputTwoAirflow = view.findViewById(R.id.btnMixingInputTwoAirflow);

        btnMixingAltitude.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputOneA.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputOneB.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputOneAirflow.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputTwoA.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputTwoB.setOnClickListener(onMeasurementButtonClicked);
        btnMixingInputTwoAirflow.setOnClickListener(onMeasurementButtonClicked);

        lstMixingCalcResults = view.findViewById(R.id.lstMixingCalcResults);
        lstMixingCalcResults.setHasFixedSize(true);
        lstMixingCalcResults.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }

    private void initButtonLabels() {
        Settings settings = Settings.getInstance();

        selectedAltitudeOption = settings.getAltitudeChoice().getIndex();
        selectedInputOneAOption = settings.getInputOneFieldChoice().getIndex();
        selectedInputTwoAOption = selectedInputOneAOption;
        selectedInputOneBOption = settings.getInputTwoFieldChoice().getIndex();
        selectedInputTwoBOption = selectedInputOneBOption;
        selectedInputOneAirflowOption = settings.getInputFlowFieldChoice().getIndex();
        selectedInputTwoAirflowOption = selectedInputOneAirflowOption;

        btnMixingAltitude.setText(altitudeChoices[selectedAltitudeOption]);
        btnMixingInputOneA.setText(inputChoices[selectedInputOneAOption]);
        btnMixingInputTwoA.setText(inputChoices[selectedInputOneAOption]);
        btnMixingInputOneB.setText(inputChoices[selectedInputOneBOption]);
        btnMixingInputTwoB.setText(inputChoices[selectedInputOneBOption]);
        btnMixingInputOneAirflow.setText(airFlowChoices[selectedInputOneAirflowOption]);
        btnMixingInputTwoAirflow.setText(airFlowChoices[selectedInputOneAirflowOption]);

    }

    private final View.OnClickListener onMeasurementButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (optionsDialogBuilder == null) {
                optionsDialogBuilder = new OptionsDialogBuilder(getContext(), MixingCalculatorFragment.this);
            }

            switch (v.getId()) {
                case R.id.btnMixingAltitude:
                    optionsDialogBuilder.show(altitudeChoices, selectedAltitudeOption, R.id.btnMixingAltitude);
                    break;
                case R.id.btnMixingInputOneA:
                    optionsDialogBuilder.show(inputChoices, selectedInputOneAOption, R.id.btnMixingInputOneA);
                    break;
                case R.id.btnMixingInputOneB:
                    optionsDialogBuilder.show(inputChoices, selectedInputOneBOption, R.id.btnMixingInputOneB);
                    break;
                case R.id.btnMixingInputOneAirflow:
                    optionsDialogBuilder.show(airFlowChoices, selectedInputOneAirflowOption, R.id.btnMixingInputOneAirflow);
                    break;
                case R.id.btnMixingInputTwoA:
                    optionsDialogBuilder.show(inputChoices, selectedInputTwoAOption, R.id.btnMixingInputTwoA);
                    break;
                case R.id.btnMixingInputTwoB:
                    optionsDialogBuilder.show(inputChoices, selectedInputTwoBOption, R.id.btnMixingInputTwoB);
                    break;
                case R.id.btnMixingInputTwoAirflow:
                    optionsDialogBuilder.show(airFlowChoices, selectedInputTwoAirflowOption, R.id.btnMixingInputTwoAirflow);
                    break;
            }
        }
    };

    @Override
    public void updateTarget(int target, String[] choices, int selected) {

        switch (target) {
            case R.id.btnMixingAltitude:
                selectedAltitudeOption = selected;
                break;
            case R.id.btnMixingInputOneA:
                selectedInputOneAOption = selected;
                break;
            case R.id.btnMixingInputOneB:
                selectedInputOneBOption = selected;
                break;
            case R.id.btnMixingInputOneAirflow:
                selectedInputOneAirflowOption = selected;
                break;
            case R.id.btnMixingInputTwoA:
                selectedInputTwoAOption = selected;
                break;
            case R.id.btnMixingInputTwoB:
                selectedInputTwoBOption = selected;
                break;
            case R.id.btnMixingInputTwoAirflow:
                selectedInputTwoAirflowOption = selected;
                break;
        }

        ((Button) getActivity().findViewById(target)).setText(choices[selected]);

    }

    private void loadArrays(MeasurementSystem measurementSystem) {
        if (measurementSystem == MeasurementSystem.IP) {
            altitudeChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputAltitudeChoiceIP);
            inputChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputUnitsIP);
            airFlowChoices = getResources().getStringArray(R.array.inputFlowChoiceIP);
            outputChoices = getResources().getStringArray(R.array.outputUnitsIP);
        } else {
            altitudeChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputAltitudeChoiceSI);
            inputChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputUnitsSI);
            airFlowChoices = getResources().getStringArray(R.array.inputFlowChoiceSI);
            outputChoices = getResources().getStringArray(R.array.outputUnitsSI);
        }
    }

    private void loadEmptyResults() {
        ArrayList<CalculationResult> results = new ArrayList<>();
        for (int i = 0; i < outputChoices.length; i++) {
            results.add(new CalculationResult(0, outputChoices[i]));
        }

        lstMixingCalcResults.setAdapter(new CalculationResultsAdapter(results));

    }


}
