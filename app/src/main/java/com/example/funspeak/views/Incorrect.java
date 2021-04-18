package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.funspeak.R;

public class Incorrect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incorrect);

        CountDownTimer mCountDownTimer=new CountDownTimer(250,250) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                startActivity((Intent) getIntent().getExtras().get("intent"));
            }
        };
        mCountDownTimer.start();
    }

    @Override
    public void onBackPressed() {
    }
}