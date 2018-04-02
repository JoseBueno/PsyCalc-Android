package com.linric.psycalc;

import android.app.Application;

/**
 * Created by jbueno on 4/1/2018.
 */
public class PsyCalcApp extends Application {

    private static PsyCalcApp psyCalcApp;

    public static synchronized PsyCalcApp getInstance() {
        return psyCalcApp;
    }

    public PsyCalcApp() {
        psyCalcApp = this;
    }

}
