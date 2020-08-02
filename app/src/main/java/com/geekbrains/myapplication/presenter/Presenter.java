package com.geekbrains.myapplication.presenter;

import android.util.Log;

import com.geekbrains.myapplication.App;
import com.geekbrains.myapplication.room.User;
import com.geekbrains.myapplication.room.UserDao;
import com.geekbrains.myapplication.view.MainView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpPresenter;

public class Presenter extends MvpPresenter <MainView> {

    private static final String TAG = "Presenter";

    private UserDao userDao;

    public Presenter()
    {userDao = App.getAppDatabase().userDao();}

//Добавляет пользователя, чьи имя, фамилия и возраст введены в соответствующие строки
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

    //Добавляет список пользователей, массив в качестве заглушки
    public void addUsersList() {
        List <User> usersList = new ArrayList<>();
        for (int i=10; i < 15; i++) {
            User user = new User();
            user.name = String.valueOf(i);
            user.surname = String.valueOf(i);
            user.age = String.valueOf(i);
            usersList.add(user);
        }
        //id в логе ниже будут указаны не так, как будут в бд.
        //В бд id генерируются автоматически и поэтому не будут равны 0,
        //а тут выводится только созданный массив
        Log.d(TAG, "usersList = "+ usersList.toString());

        Disposable disposable = userDao.insertList(usersList).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "addUsersList: ");
                }, throwable -> {
                    Log.d(TAG, "addUsersList: " + throwable);
                });
    }

    //удаление пользователя по Id;
    public void delById(int id) {
        Log.d(TAG, "id удаляемого пользователя= " + id);
        User user = new User();
        user.id = id;
        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(mId -> {
                    Log.d(TAG, "deleteUser. Всего удалено: " + mId);
                }, throwable -> {
                    Log.d(TAG, "ОШИБКА deleteUser, id: " + throwable);
                });
        getViewState().clearDelByIdDataFrame();

        //Проверим, что останется после удаления по id
//        Disposable disposableTwo = userDao.getAll().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(bdDataList->{
//                    Log.d(TAG, "После удаления по id: " + bdDataList);
//        });
    }

    //удаление пользователя по фамилии;
    public void delBySurname(String surname) {
        Log.d(TAG, "Фамилия удаляемого пользователя = " + surname);
//        User user = new User();
//        user.surname = surname;
        Disposable disposable = userDao.deleteUserBySurname(surname).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(mSurname -> {
                    Log.d(TAG, "delUserBySurname. Всего удалено: " + mSurname);
                }, throwable -> {
                    Log.d(TAG, "ОШИБКА delUserBySurname: " + throwable);
                });
        getViewState().clearDelBySurnameDataFrame();

//        //Проверим, что останется после удаления по фамилии
//        Disposable disposableTwo = userDao.getAll().subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(bdDataList->{
//                    Log.d(TAG, "После удаления по фамилии: " + bdDataList);
//                });
    }

    public void updateUserById(int id){
        User user = new User();
        user.id = id;
        user.surname = "updated";
        user.name = "updated";
        user.age = "updated";
        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(updatedNum->{
                    Log.d(TAG, "обновим по id: " + user.id);
                });

    }

    public void checkBd(){
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bdDataList->{
                    Log.d(TAG, "Содержимое базы данных " + bdDataList);
                });
        getViewState().clearUpdateByIdDataFrame();
    }
}
