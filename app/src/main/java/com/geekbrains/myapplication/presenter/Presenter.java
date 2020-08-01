package com.geekbrains.myapplication.presenter;

import android.util.Log;

import com.geekbrains.myapplication.App;
import com.geekbrains.myapplication.room.User;
import com.geekbrains.myapplication.room.UserDao;
import com.geekbrains.myapplication.view.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;

public class Presenter extends MvpPresenter <MainView> {

    private static final String TAG = "Presenter";

    private UserDao userDao;

    public Presenter()
    {userDao = App.getAppDatabase().userDao();}

    public void addUser(String name, final String surname, final String age){
        User user = new User();
        user.name = name;
        user.surname = surname;
        user.age = age;

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "addUser: " + id + " "+  name + " " + surname + " " + age);
                }, throwable -> {
                    Log.d(TAG, "addUser: " + throwable);
                });
     getViewState().clearPutDataFrames();
    }
}
