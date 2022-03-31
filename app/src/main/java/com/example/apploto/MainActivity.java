package com.example.apploto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEdtNumberCount;
    Button mBtnRao,mBtnReset,mBtnAdd;
    TextView mTvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        event();
    }

    private void event() {
    }

    private void initView() {
        mBtnRao = findViewById(R.id.bottonRao);
        mBtnReset = findViewById(R.id.bottonReset);
        mBtnAdd = findViewById(R.id.bottonAdd);
        mEdtNumberCount = findViewById(R.id.editTextNumberCount);
        mTvResult = findViewById(R.id.textViewResult);

        // Disable View
        isEnableView(false,mBtnRao);
        isEnableView(false,mBtnReset);
    }

    private void isEnableView(boolean isEnable, View view){
        view.setEnabled(isEnable);
    }

}