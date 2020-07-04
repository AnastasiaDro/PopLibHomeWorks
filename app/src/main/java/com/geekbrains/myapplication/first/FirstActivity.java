package com.geekbrains.myapplication.first;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.geekbrains.myapplication.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "firstActivity";

    @BindView(R.id.startCountBtn)
    Button startCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.startCountBtn)
      public void onClickStartButton(View view){

    }

    @OnClick(R.id.stopCountBtn)
    public void onClickStopCountBtn(View view){

    }



}