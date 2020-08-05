package com.geekbrains.myapplication.di;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekbrains.myapplication.R;

public class DiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di);

        Green green = new Green();
        White white = new White(green);
        Red red = new Red(green);
    }
}