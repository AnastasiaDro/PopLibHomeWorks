package com.geekbrains.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.geekbrains.myapplication.R;
import com.geekbrains.myapplication.presenter.Presenter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    EditText nameEditText;
    EditText surnameEditText;
    EditText ageEditText;

    @InjectPresenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    @OnClick({R.id.addBtn})
    public void onClickAddBtn(View view){
        Log.d(TAG, "onAddBtn");
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        presenter.addUser(name, surname, age);
    }

    public void init() {
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        ageEditText = findViewById(R.id.ageEditText);
    }

    @Override
    public void clearPutDataFrames() {
        nameEditText.setText("");
        surnameEditText.setText("");
        ageEditText.setText("");
    }
}