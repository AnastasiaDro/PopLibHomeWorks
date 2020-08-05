package com.geekbrains.myapplication.withDagger.app;

import com.geekbrains.myapplication.withDagger.DaggerActivity;
import com.geekbrains.myapplication.withDagger.Red;
import com.geekbrains.myapplication.withDagger.White;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerActivity daggerActivity);

    void inject(White white);

    void inject(Red red);
}
