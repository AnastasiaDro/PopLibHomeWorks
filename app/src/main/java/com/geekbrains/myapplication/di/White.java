package com.geekbrains.myapplication.di;

import android.util.Log;

public class White {

    private static final String TAG = "White";

    private Green green;

    public White(Green green){
        this.green = green;
        Log.d(TAG, "White shows greenStr " + green.show());
        Log.i(TAG, "White: " + green);
    }

}
