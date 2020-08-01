package com.geekbrains.myapplication.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(value = SingleStateStrategy.class)
    void clearPutDataFrames();
}
