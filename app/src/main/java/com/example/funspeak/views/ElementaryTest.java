package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;
import com.example.funspeak.views.tasks.SelectPhotoTask;

public class ElementaryTest extends AppCompatActivity {

    private Button count, geometry, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_elementary);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        addition = findViewById(R.id.study);
        subtraction = findViewById(R.id.test);
        count = findViewById(R.id.count2);
        geometry = findViewById(R.id.pattern2);

    }

    public void setUpActions(){
        addition.setOnClickListener((view)->nextActivity("addition"));
        subtraction.setOnClickListener((View)->nextActivity("subtraction1"));
        count.setOnClickListener((view)->nextActivity("count1"));
        geometry.setOnClickListener((view)->nextActivity("geometry"));

    }

    public void nextActivity(String type){
        int r = (int)(Math.random() * 2);
        Intent intent = new Intent(this,  SelectPhotoTask.class );
        //intent.putExtra("language", language);
        intent.putExtra("type",type);
        //Intent intent2 = new Intent(this, SelectDifficulty.class);
        //intent2.putExtra("intent", intent);
        startActivity(intent);
    }
}