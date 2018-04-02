package com.linric.psycalc;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class HostActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigationView;

    private static final String TAG_FRAGMENT_POINT = "PointFragment";
    private static final String TAG_FRAGMENT_INFO = "InfoFragment";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment target = null;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_point:
                    mTextMessage.setText(R.string.menu_point);
                    target = getFragmentManager().findFragmentByTag(TAG_FRAGMENT_POINT);
                    if (target == null) {
                        target = new PointCalculatorFragment();
                        transaction.add(R.id.fragmentMain, target, TAG_FRAGMENT_POINT);
                    } else {
                        transaction.replace(R.id.fragmentMain, target, TAG_FRAGMENT_POINT);
                    }
                    transaction.addToBackStack(null).commit();
                    return true;
                case R.id.navigation_mixing:
                    mTextMessage.setText(R.string.menu_mixing);
                    return true;
                case R.id.navigation_process:
                    mTextMessage.setText(R.string.menu_process);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.menu_settings);
                    return true;
                case R.id.navigation_info:
                    mTextMessage.setText(R.string.menu_info);
                    target = getFragmentManager().findFragmentByTag(TAG_FRAGMENT_INFO);
                    if (target == null) {
                        target = new InfoFragment();
                        transaction.add(R.id.fragmentMain, target, TAG_FRAGMENT_INFO);
                    } else {
                        transaction.replace(R.id.fragmentMain, target, TAG_FRAGMENT_INFO);
                    }
                    transaction.addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        PointCalculatorFragment pointFragment = new PointCalculatorFragment();

        getFragmentManager().beginTransaction()
                .add(com.linric.psycalc.R.id.fragmentMain, pointFragment, TAG_FRAGMENT_POINT).commit();
    }

}
