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

    EditText delIdEditText;
    EditText delSurnameEditText;

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

    @OnClick({R.id.addSeveralUsersBtn})
        public void onClickSevUbtn(View view){
            Log.d(TAG, "onAddSeveralUsersBtn");
        presenter.addUsersList();
    }

    @OnClick(R.id.delByIdBtn)
    public void onDelByIdBtn(View view){
        Log.d(TAG, "onDelByIdBtn");
        int id = Integer.parseInt(delIdEditText.getText().toString());
        presenter.delById(id);
    }

    @OnClick(R.id.delBySurnameBtn)
    public void onDelBySurnameBtn(View view){
        Log.d(TAG, "onDelBySurnameBtn");
        String surname = delSurnameEditText.getText().toString();
        presenter.delBySurname(surname);
    }

    public void init() {
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        delIdEditText = findViewById(R.id.delIdEditText);
        delSurnameEditText = findViewById(R.id.delSurnameEditText);
    }

    @Override
    public void clearPutDataFrames() {
        nameEditText.setText("");
        surnameEditText.setText("");
        ageEditText.setText("");
    }

    @Override
    public void clearDelByIdDataFrame() {
        delIdEditText.setText("");
    }

    @Override
    public void clearDelBySurnameDataFrame() {
        delSurnameEditText.setText("");
    }
}