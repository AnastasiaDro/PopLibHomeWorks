package com.geekbrains.myapplication.second;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class SecondPresenter {
    private static final String TAG = "SecondPresenter";

    public Single<String> sendSingleMsg(){
        Single <String> single = Single.create((SingleOnSubscribe<String>) emitter -> {
            String singleMsg = "Это singleMsg";
            Log.d(TAG, "Вывод единственного сообщения в потоке " + Thread.currentThread().getName() + ": " + singleMsg);
            emitter.onSuccess(singleMsg);
        }).subscribeOn(Schedulers.io());
        return single;
    }
}
