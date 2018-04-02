package com.linric.psycalc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.linric.psycalc.interfaces.DialogOptionSelected;

/**
 *
 * Created by jbueno on 4/1/2018.
 */
public class OptionsDialogBuilder {

    private Context context;
    private String[] choices;
    private AlertDialog.Builder builder;
    private DialogOptionSelected listener;

    public OptionsDialogBuilder(Context context, DialogOptionSelected listener) {
        this.context = context;
        this.listener = listener;
        builder = new AlertDialog.Builder(context);
        builder.setNegativeButton("Cancel", onCancelClicked);
    }

    public void show(final String[] choices, int selected, final int target) {
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.select_dialog_singlechoice, choices);
        builder.setSingleChoiceItems(adapter, selected, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.updateTarget(target, choices, which);
                dialog.dismiss();
            }
        });
        builder.show();
    }

    DialogInterface.OnClickListener onCancelClicked = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

}
