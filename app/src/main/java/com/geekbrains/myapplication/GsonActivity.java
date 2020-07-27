package com.geekbrains.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "GsonActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        String yearGson = "{\n" +
                "  \"time_of_year\": \"Summer\",\n" +
                "  \"year\": 2019, \n " + "}";

        Gson gson = new GsonBuilder().create();
        Year year = gson.fromJson(yearGson, Year.class);

        Log.d(TAG, "onCreate: " + year.timeOfYear);
        Log.d(TAG, "onCreate: " + year.yearName);

    }
}