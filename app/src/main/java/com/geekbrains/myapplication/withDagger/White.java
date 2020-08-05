package com.geekbrains.myapplication.withDagger;

import android.util.Log;

public class White {

    private static final String TAG = "White";

    public White(){
        Green green = new Green();
        Log.d(TAG, "White shows greenStr " + green.show());
        Log.i(TAG, "White: " + green);
    }

}
