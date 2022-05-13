package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;

public class Elementary2Select extends AppCompatActivity {

    private Button test, study, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary2_select);
        bindComponents();
        setUpActions();

        //language = getIntent().getIntExtra("language",0);
    }

    public void bindComponents(){
        test = findViewById(R.id.test);
        study = findViewById(R.id.study);
        back = findViewById(R.id.back);
    }

    public void setUpActions(){

        study.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2.class));
        });
        test.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Test.class));
        });

    }
}