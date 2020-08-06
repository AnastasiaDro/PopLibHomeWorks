package com.geekbrains.myapplication.espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geekbrains.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EspessoActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espesso);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.setTextBtn)
    public void onSetTextBtnClick(View view){
        textView.setText("Засетили текст");
    }
}