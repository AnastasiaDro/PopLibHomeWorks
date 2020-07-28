package com.geekbrains.myapplication.retrofitactivity.model.retrofit;

import com.geekbrains.myapplication.retrofitactivity.model.entity.JakeWhartonAvatar;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/users/JakeWharton")
    Observable<JakeWhartonAvatar> getAvatar();


}
