package com.linric.psycalc;

import android.app.Fragment;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.lang.System.out;

/**
 * Created by jbueno on 4/2/2018.
 */
public class InfoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        TextView lblInformation = view.findViewById(R.id.lblInformation);
        lblInformation.setMovementMethod(new ScrollingMovementMethod());

        Display display = getActivity().getWindowManager().getDefaultDisplay();

        Point point = new Point();
        display.getRealSize(point);
//
//        int maxLines = point.y / 100;
//
//        lblInformation.setMaxLines(maxLines);

        return view;

    }
}
