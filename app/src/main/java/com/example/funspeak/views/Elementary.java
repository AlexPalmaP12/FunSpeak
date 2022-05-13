package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class Elementary extends AppCompatActivity {

    private Button count, geometry, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        count = findViewById(R.id.count2);
        geometry = findViewById(R.id.pattern2);
        addition = findViewById(R.id.study);
        subtraction = findViewById(R.id.test);
    }

    public void setUpActions(){
        count.setOnClickListener((view)->{
            startActivity(new Intent(this, ElementaryCount.class));
        });
        geometry.setOnClickListener((view)->{
            startActivity(new Intent(this, ElementaryGeometry.class));
        });
        addition.setOnClickListener((view)->{
            startActivity(new Intent(this, ElementaryAddition.class));
        });
        subtraction.setOnClickListener((view)->{
            startActivity(new Intent(this, ElementarySubtraction.class));
        });
    }

    public void nextActivity(int time, int max){
        Intent intent = (Intent)getIntent().getExtras().get("intent");
        intent.putExtra("time",time);
        intent.putExtra("max",max);
        startActivity(intent);
    }
}