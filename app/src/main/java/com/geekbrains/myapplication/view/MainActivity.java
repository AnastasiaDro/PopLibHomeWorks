package com.geekbrains.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekbrains.myapplication.R;
import com.geekbrains.myapplication.firstExc.CalcAmount;

public class MainActivity extends AppCompatActivity {

    CalcAmount calcAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcAmount = new CalcAmount();
        calcAmount.calcSum(5);
    }
}