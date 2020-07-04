package com.geekbrains.myapplication.first;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.geekbrains.myapplication.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "firstActivity";
    private Observable<String> observable;
    private Disposable disposable;
    private FirstPresenter firstPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        firstPresenter = new FirstPresenter();
        observable = firstPresenter.getMsg();
    }


    @OnClick(R.id.startCountBtn)
      public void onClickStartBtn(View view){
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "onNext: " + string);
        }, throwable -> {
            Log.e(TAG, "onError");
        }, () ->{
            Log.d(TAG, "onComplete: ");
        });
        firstPresenter.getMsg();
    }

    @OnClick(R.id.stopCountBtn)
    public void onClickStopCountBtn(View view){
        disposable.dispose();
    }

}