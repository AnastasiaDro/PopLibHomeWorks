package com.geekbrains.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geekbrains.myapplication.R;
import com.geekbrains.myapplication.presenter.Presenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity {

    private static final String TAG = "MainActivity";

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}