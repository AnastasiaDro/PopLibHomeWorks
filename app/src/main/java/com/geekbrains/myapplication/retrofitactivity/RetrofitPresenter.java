package com.geekbrains.myapplication.retrofitactivity;

import android.provider.ContactsContract;
import android.util.Log;

import com.geekbrains.myapplication.retrofitactivity.model.entity.JakeWhartonAvatar;
import com.geekbrains.myapplication.retrofitactivity.model.retrofit.RetrofitHelper;
import com.geekbrains.myapplication.retrofitactivity.view.MainView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter <MainView> {

    private static final String TAG = "RetrofitPresenter";

    private RetrofitHelper retrofitHelper;
    private String url;

    public RetrofitPresenter (){
        Log.d(TAG, "RetrofitPresenter: ");
        retrofitHelper = new RetrofitHelper();
    }

    @Override
    protected void onFirstViewAttach() {
        getAvatar();
    }

    public void getAvatar(){
        Observable<JakeWhartonAvatar> single = retrofitHelper.requestServer();
        Disposable dispose = single.observeOn(AndroidSchedulers.mainThread()).subscribe( str -> {
            Log.d(TAG, "onNext: " + str);
            getViewState().setImage(str.avatarUrl);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }


}
