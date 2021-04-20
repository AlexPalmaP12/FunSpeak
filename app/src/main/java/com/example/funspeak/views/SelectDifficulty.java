package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class SelectDifficulty extends AppCompatActivity {

    private Button easy, normal, hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        easy = findViewById(R.id.easy);
        normal = findViewById(R.id.normal);
        hard = findViewById(R.id.hard);
    }

    public void setUpActions(){
        easy.setOnClickListener(v -> nextActivity(10000,10));
        normal.setOnClickListener(v -> nextActivity(5000,15));
        hard.setOnClickListener(v -> nextActivity(2000, 20));
    }

    public void nextActivity(int time, int max){
        Intent intent = (Intent)getIntent().getExtras().get("intent");
        intent.putExtra("time",time);
        intent.putExtra("max",max);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
    }
}