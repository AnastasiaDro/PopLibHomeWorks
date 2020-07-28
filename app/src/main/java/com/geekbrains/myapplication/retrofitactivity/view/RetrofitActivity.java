package com.geekbrains.myapplication.retrofitactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.geekbrains.myapplication.R;
import com.geekbrains.myapplication.retrofitactivity.RetrofitPresenter;
import com.geekbrains.myapplication.retrofitactivity.model.GlideLoader;
import com.geekbrains.myapplication.retrofitactivity.model.entity.JakeWhartonAvatar;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class RetrofitActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "RetrofitDifActivity";


    private GlideLoader glideLoader;

    @BindView(R.id.imageView)
    ImageView imageView;

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @ProvidePresenter
    public RetrofitPresenter providePresenter() {
        return new RetrofitPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        glideLoader = new GlideLoader(this);
    }

    @Override
    public void setImage(String url) {
        glideLoader.loadImage(url, imageView);
    }
}