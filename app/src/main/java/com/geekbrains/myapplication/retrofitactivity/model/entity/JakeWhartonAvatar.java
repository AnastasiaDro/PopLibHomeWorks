package com.geekbrains.myapplication.retrofitactivity.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JakeWhartonAvatar {
    @Expose
    @SerializedName("avatar_url")
    public String avatarUrl;
}
