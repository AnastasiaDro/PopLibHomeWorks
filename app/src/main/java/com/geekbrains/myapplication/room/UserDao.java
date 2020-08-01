package com.geekbrains.myapplication.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.geekbrains.myapplication.room.User;

import java.util.List;

import butterknife.OnClick;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAll();

    @Query("SELECT * FROM table_users WHERE id = :id")
    Single<List<User>> getAllById(int id);

    //найти по фамилии
    @Query("SELECT * FROM table_users WHERE surname = :surname")
    Single<List<User>> getAllBySurname(String surname);

    @Insert
    Single<Long> insert(User user);

    @Insert
    Single<List<Long>> insertList(List<User> users);

    @Delete
    Single<Integer> delete(User user);

    @Query("DELETE FROM table_users WHERE surname = :surname")
    Single <Integer> deleteUserBySurname(String surname);

    @Update
    Single<Integer> update(User user);
}
