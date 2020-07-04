package com.geekbrains.myapplication.second;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geekbrains.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "firstActivity";
    private Single<String> single;
    private Disposable disposable;
    private SecondPresenter secondPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        secondPresenter = new SecondPresenter();
        single = secondPresenter.sendSingleMsg();
    }

    @OnClick(R.id.singleMsgBtn)
    public void onClickSingleMsgBtn(View view){
        disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "onClickSingleMsgBtn " + string);
        }, throwable -> {
            Log.e(TAG, "onClickSingleMsgBtn ", throwable);
        });
    }
}