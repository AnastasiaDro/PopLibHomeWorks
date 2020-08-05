package com.geekbrains.myapplication.withDagger;

import android.util.Log;

public class Red {

    private static final String TAG = "Red";

    public Red(){
        Green green = new Green();
        Log.d(TAG, "Red shows greenStr: " + green.show());
        Log.i(TAG, "Red: " + green);
    }

}
