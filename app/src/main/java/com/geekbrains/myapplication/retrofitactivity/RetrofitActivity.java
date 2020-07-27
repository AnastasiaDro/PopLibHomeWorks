package com.geekbrains.myapplication.retrofitactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekbrains.myapplication.R;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitDifActivity";

    private RetrofitPresenter retrofitPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        retrofitPresenter = new RetrofitPresenter();
        retrofitPresenter.getString();
    }
}