package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.funspeak.R;

public class FinalScore extends AppCompatActivity {

    private TextView finalScore, maxScore;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        bindComponents();
        setUpModel();
        setUpActions();
    }

    private void bindComponents(){
        finalScore = findViewById(R.id.finalScore);
        maxScore = findViewById(R.id.maxScore);
        back = findViewById(R.id.back);
    }

    private void setUpModel(){
        int score = getIntent().getIntExtra("correct",0);
        int max = getIntent().getIntExtra("max",10);

        finalScore.setText("" + score);
        maxScore.setText("" + max);
    }

    private void setUpActions(){
        back.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}