package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;

public class Elementary3 extends AppCompatActivity {

    private Button multiplication, division, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary3);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        division = findViewById(R.id.addition3);
        multiplication = findViewById(R.id.pattern3);
        addition = findViewById(R.id.count3);
        subtraction = findViewById(R.id.subtraction3);
    }

    public void setUpActions(){
        multiplication.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Multiplication.class));
        });
        division.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Division.class));
        });
        addition.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Addition.class));
        });
        subtraction.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Subtraction.class));
        });
    }

    public void nextActivity(int time, int max){
        Intent intent = (Intent)getIntent().getExtras().get("intent");
        intent.putExtra("time",time);
        intent.putExtra("max",max);
        startActivity(intent);
    }
}