package com.geekbrains.myapplication.retrofitactivity;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RetrofitPresenter {

    private static final String TAG = "RetrofitPresenter";

    private RetrofitHelper retrofitHelper;

    public RetrofitPresenter (){
        retrofitHelper = new RetrofitHelper();
    }

    public void getString() {
        AtomicReference<String> urlStr = null;
        Observable<String> single = retrofitHelper.requestServer();
        Disposable dispose = single.observeOn(AndroidSchedulers.mainThread()).subscribe( str -> {
            Log.d(TAG, "onNext: " + str);
            urlStr.set(str);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
        return ;
    }

    public void getAvatarUrl(){
        Gson gson = new GsonBuilder().create();
        String avatarUrl = gson.fromJson(getString(), JakeWharton.class);
    }


}
