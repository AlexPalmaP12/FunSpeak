package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class Elementary2 extends AppCompatActivity {

    private Button multiplication, division, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary2);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        multiplication = findViewById(R.id.pattern3);
        division = findViewById(R.id.addition3);
        addition = findViewById(R.id.count3);
        subtraction = findViewById(R.id.subtraction3);
    }

    public void setUpActions(){
        multiplication.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Multiplication.class));
        });
        division.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Division.class));
        });
        addition.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Addition.class));
        });
        subtraction.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Subtraction.class));
        });
    }

    public void nextActivity(int time, int max){
        Intent intent = (Intent)getIntent().getExtras().get("intent");
        intent.putExtra("time",time);
        intent.putExtra("max",max);
        startActivity(intent);
    }
}