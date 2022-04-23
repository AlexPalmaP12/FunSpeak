package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class Preschool extends AppCompatActivity {

    private Button count, pattern, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preschool);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        count = findViewById(R.id.count);
        pattern = findViewById(R.id.pattern);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
    }

    public void setUpActions(){
        count.setOnClickListener((view)->{
            startActivity(new Intent(this, Count.class));
        });
        pattern.setOnClickListener(v -> nextActivity(13000,10));
        addition.setOnClickListener(v -> nextActivity(13000,10));
        subtraction.setOnClickListener(v -> nextActivity(13000,10));
    }

    public void nextActivity(int time, int max){
        Intent intent = (Intent)getIntent().getExtras().get("intent");
        intent.putExtra("time",time);
        intent.putExtra("max",max);
        startActivity(intent);
    }
}