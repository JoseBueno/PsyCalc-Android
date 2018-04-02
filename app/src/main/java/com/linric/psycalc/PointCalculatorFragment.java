package com.linric.psycalc;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.linric.psycalc.adapters.CalculationResultsAdapter;
import com.linric.psycalc.enums.AltitudeChoiceDesignator;
import com.linric.psycalc.enums.FieldChoiceDesignator;
import com.linric.psycalc.enums.MeasurementSystem;
import com.linric.psycalc.interfaces.DialogOptionSelected;
import com.linric.psycalc.models.CalculationResult;

import java.util.ArrayList;

/**
 * Created by jbueno on 4/1/2018.
 */
public class PointCalculatorFragment
        extends Fragment
        implements DialogOptionSelected {

    private EditText txtPointAltitude;
    private EditText txtPointInputOne;
    private EditText txtPointInputTwo;
    private Button btnPointAltitude;
    private Button btnPointInputOne;
    private Button btnPointInputTwo;
    private RecyclerView lstPointCalcResults;

    private String[] altitudeChoices;
    private String[] inputChoices;
    private String[] outputChoices;

    private OptionsDialogBuilder optionsDialogBuilder;

    private int selectedAltitudeOption;
    private int selectedInputOneOption;
    private int selectedInputTwoOption;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_point_calculator, container, false);
        initUI(view);
        loadArrays(Settings.getInstance().getInputMeasurementSystem());
        setButtonLabels();
        loadEmptyResults();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    private void setButtonLabels() {
        Settings settings = Settings.getInstance();

        selectedAltitudeOption = settings.getAltitudeChoice().getIndex();
        btnPointAltitude.setText(altitudeChoices[selectedAltitudeOption]);
        selectedInputOneOption = settings.getInputOneFieldChoice().getIndex();
        btnPointInputOne.setText(inputChoices[selectedInputOneOption]);
        selectedInputTwoOption = settings.getInputTwoFieldChoice().getIndex();
        btnPointInputTwo.setText(inputChoices[selectedInputTwoOption]);
    }

    private void initUI(View view) {

        txtPointAltitude = view.findViewById(com.linric.psycalc.R.id.txtPointAltitude);
        txtPointInputOne = view.findViewById(com.linric.psycalc.R.id.txtPointInputOne);
        txtPointInputTwo = view.findViewById(com.linric.psycalc.R.id.txtPointInputTwo);

        txtPointAltitude.clearFocus();
        txtPointAltitude.addTextChangedListener(pointInputsWatcher);
        txtPointInputOne.addTextChangedListener(pointInputsWatcher);
        txtPointInputTwo.addTextChangedListener(pointInputsWatcher);

        btnPointAltitude = view.findViewById(R.id.btnPointAltitude);
        btnPointInputOne = view.findViewById(R.id.btnPointInputOne);
        btnPointInputTwo = view.findViewById(R.id.btnPointInputTwo);

        lstPointCalcResults = view.findViewById(R.id.lstPointCalcResults);
        lstPointCalcResults.setHasFixedSize(true);
        lstPointCalcResults.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        btnPointAltitude.setOnClickListener(onSomethingClicked);
        btnPointInputOne.setOnClickListener(onSomethingClicked);
        btnPointInputTwo.setOnClickListener(onSomethingClicked);

    }

    private final View.OnClickListener onSomethingClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (optionsDialogBuilder == null) {
                optionsDialogBuilder = new OptionsDialogBuilder(getContext(), PointCalculatorFragment.this);
            }

            Settings settings = Settings.getInstance();

            switch (v.getId()) {
                case R.id.btnPointAltitude:
                    optionsDialogBuilder.show(altitudeChoices, selectedAltitudeOption, R.id.btnPointAltitude);
                    break;
                case R.id.btnPointInputOne:
                    optionsDialogBuilder.show(inputChoices, selectedInputOneOption, R.id.btnPointInputOne);
                    break;
                case R.id.btnPointInputTwo:
                    optionsDialogBuilder.show(inputChoices, selectedInputTwoOption, R.id.btnPointInputTwo);
                    break;
            }
        }
    };

    private final TextWatcher pointInputsWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    void loadArrays(MeasurementSystem measurementSystem) {
        if (measurementSystem == MeasurementSystem.IP) {
            altitudeChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputAltitudeChoiceIP);
            inputChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputUnitsIP);
            outputChoices = getResources().getStringArray(R.array.outputUnitsIP);
        } else {
            altitudeChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputAltitudeChoiceSI);
            inputChoices = getResources().getStringArray(com.linric.psycalc.R.array.inputUnitsSI);
            outputChoices = getResources().getStringArray(R.array.outputUnitsSI);
        }
    }

    private void loadEmptyResults() {
        ArrayList<CalculationResult> results = new ArrayList<>();
        for (int i = 0; i < outputChoices.length; i++) {
            results.add(new CalculationResult(0, outputChoices[i]));
        }

        lstPointCalcResults.setAdapter(new CalculationResultsAdapter(results));

    }

    @Override
    public void updateTarget(int target, String[] choices, int selected) {

        Settings settings = Settings.getInstance();

        switch (target) {
            case R.id.btnPointAltitude:
                selectedAltitudeOption = selected;
                break;
            case R.id.btnPointInputOne:
                selectedInputOneOption = selected;
                break;
            case R.id.btnPointInputTwo:
                selectedInputTwoOption = selected;
                break;
        }

        ((Button) getActivity().findViewById(target)).setText(choices[selected]);

    }
}
