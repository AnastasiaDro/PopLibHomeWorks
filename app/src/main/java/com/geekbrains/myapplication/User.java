package com.geekbrains.myapplication;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String surname;
    public String age;


}
