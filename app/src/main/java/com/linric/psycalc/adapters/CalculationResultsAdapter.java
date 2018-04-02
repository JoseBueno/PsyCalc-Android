package com.linric.psycalc.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.linric.psycalc.R;
import com.linric.psycalc.models.CalculationResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jbueno on 4/1/2018.
 */
public class CalculationResultsAdapter extends RecyclerView.Adapter<CalculationResultsAdapter.ViewHolder> {

    List<CalculationResult> results;

    public CalculationResultsAdapter(ArrayList<CalculationResult> results){
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_calc_result, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CalculationResult result = results.get(position);
        holder.lblResultValue.setText(String.valueOf(result.getValue()));
        holder.lblResultUOMDisplay.setText(String.valueOf(result.getDisplay()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final TextView lblResultValue;
        final TextView lblResultUOMDisplay;

        public ViewHolder(View itemView) {
            super(itemView);
            lblResultValue = itemView.findViewById(R.id.lblResultValue);
            lblResultUOMDisplay = itemView.findViewById(R.id.lblResultUOMDisplay);
        }
    }
}
