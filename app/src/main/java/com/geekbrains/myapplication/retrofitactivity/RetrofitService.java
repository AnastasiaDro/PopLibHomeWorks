package com.geekbrains.myapplication.retrofitactivity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("/users/JakeWharton")
    Observable<String> getUser();


}
