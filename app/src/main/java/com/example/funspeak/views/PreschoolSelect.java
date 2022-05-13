package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;
import com.example.funspeak.tasksbuilders.SelectPhotoTaskBuilder;
import com.example.funspeak.views.tasks.SelectPhotoTask;

public class PreschoolSelect extends AppCompatActivity {
    private Button test, study, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preschool_select);
        bindComponents();
        setUpActions();

        //language = getIntent().getIntExtra("language",0);
    }

    public void bindComponents(){
        test = findViewById(R.id.subtraction5);
        study = findViewById(R.id.addition5);
        back = findViewById(R.id.back);
    }

    public void setUpActions(){

        study.setOnClickListener((view)->{
            startActivity(new Intent(this, Preschool.class));
        });
        test.setOnClickListener((view)->{
            startActivity(new Intent(this, PreschoolTest.class));
        });

    }
}
