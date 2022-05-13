package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class Elementary3Select extends AppCompatActivity {

    private Button test, study, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary3_select);
        bindComponents();
        setUpActions();

        //language = getIntent().getIntExtra("language",0);
    }

    public void bindComponents(){
        study = findViewById(R.id.study);
        test = findViewById(R.id.test);
        //back = findViewById(R.id.back);
    }

    public void setUpActions(){

        study.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3.class));
        });
        test.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Test.class));
        });

    }
}