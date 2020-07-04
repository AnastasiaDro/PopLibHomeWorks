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

    private FirstPresenter firstPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        firstPresenter = new FirstPresenter();
    }


    @OnClick(R.id.startCountBtn)
      public void onClickStartBtn(View view){
        firstPresenter.getMsg();
    }

    @OnClick(R.id.stopCountBtn)
    public void onClickStopCountBtn(View view){

    }



}