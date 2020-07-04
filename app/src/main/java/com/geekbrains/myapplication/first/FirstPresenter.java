package com.geekbrains.myapplication.first;


import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class FirstPresenter {
    private static final String TAG = "FirstPresenter";

    public Observable<String> getMsg() {

        Observable observableStr = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String msg = "msg #"+i;
                    Log.d(TAG, "getMsg в потоке "+ Thread.currentThread().getName() + "сообщение: " + msg);
                    emitter.onNext(msg);
                }
                emitter.onComplete();
            }catch (InterruptedException e){
                Log.d(TAG, "getMsg: not disposed");
            }
        }).subscribeOn(Schedulers.io());
        return observableStr;
    }
}
