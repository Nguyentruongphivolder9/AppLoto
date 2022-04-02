package com.example.apploto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtInput;
    Button mBtnRao,mBtnReset,mBtnAdd;
    TextView mTvResult;
    ArrayList<Integer> mArrNumber;
    Random mRandom;
    String mResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        event();
    }

    private void event() {

        // Thêm số
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNumber = mEdtInput.getText().toString();     // lấy dữ liệu

                if (textNumber.isEmpty()){
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    return; // thoát
                }

                int number = Integer.parseInt(textNumber);

                if (number < 10){
                    Toast.makeText(MainActivity.this, "Not less than 10", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mArrNumber.size() > 0){
                    mArrNumber.clear();
                }

                // Add value into array ( thêm giá trị vào number)
                for (int i = 1; i <= number; i++){
                    mArrNumber.add(i);
                }

                isEnableView(false,mBtnAdd);
                isEnableView(false,mEdtInput);

                isEnableView(true,mBtnRao);
                isEnableView(true,mBtnReset);
            }
        });

        // Chơi lại
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // xoá dữ liệu trong mảng
                if (mArrNumber != null && mArrNumber.size() > 0){
                    mArrNumber.clear();
                }
                // xoá giao diện trong edittext
                mEdtInput.setText("");

                isEnableView(false,mBtnRao);
                isEnableView(false,mBtnReset);

                isEnableView(true,mBtnAdd);
                isEnableView(true,mEdtInput);

                // clear result
                mResult = "";
                mTvResult.setText(mResult);
            }
        });

        // Rao
        mBtnRao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mArrNumber.size() > 0) {
                    // random trả về vị trí ngẫu nhiên
                    int index = mRandom.nextInt(mArrNumber.size());
                    int value = mArrNumber.get(index);
                    // lấy giá trị vị trí đó hiển thị lên
                    if (mArrNumber.size() == 1) {
                        mResult += value;
                    }else {
                        mResult += value + " - ";
                    }
                    // xoá giá trị vị trí đó
                    mArrNumber.remove(index);

                }else {
                    Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void initView() {
        mBtnRao = findViewById(R.id.bottonRao);
        mBtnReset = findViewById(R.id.bottonReset);
        mBtnAdd = findViewById(R.id.bottonAdd);
        mEdtInput = findViewById(R.id.editTextNumberCount);
        mTvResult = findViewById(R.id.textViewResult);

        // Disable View
        isEnableView(false,mBtnRao);
        isEnableView(false,mBtnReset);

        // Declare array
        mArrNumber = new ArrayList<>();
        mRandom = new Random();

    }

    private void isEnableView(boolean isEnable, View view){
        view.setEnabled(isEnable);
    }

}