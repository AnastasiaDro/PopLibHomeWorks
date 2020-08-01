package com.geekbrains.myapplication.presenter;

import com.geekbrains.myapplication.App;
import com.geekbrains.myapplication.room.UserDao;

public class Presenter {

    private static final String TAG = "Presenter";

    private UserDao userDao;

    public Presenter()
    {userDao = App.getAppDatabase().userDao();}

    public void addUser(String name, String Surname, String age){

    }
}
