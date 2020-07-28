package com.geekbrains.myapplication.retrofitactivity.view;

import com.geekbrains.myapplication.retrofitactivity.model.entity.JakeWhartonAvatar;

import moxy.MvpView;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void setImage(String url);
}
