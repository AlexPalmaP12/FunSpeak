package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;

public class Elementary3 extends AppCompatActivity {

    private Button count, geometry, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary3);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        count = findViewById(R.id.count2);
        geometry = findViewById(R.id.pattern2);
        addition = findViewById(R.id.addition2);
        subtraction = findViewById(R.id.subtraction2);
    }

    public void setUpActions(){
        count.setOnClickListener(v -> nextActivity(13000,10));
        geometry.setOnClickListener(v -> nextActivity(13000,10));
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