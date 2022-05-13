package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;
import com.example.funspeak.views.tasks.SelectPhotoTask;
public class PreschoolTest extends AppCompatActivity {

    private Button count, pattern, addition, subtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_preschool_test);
        bindComponents();
        setUpActions();
    }

    public void bindComponents(){
        count = findViewById(R.id.count);
       // pattern = findViewById(R.id.pattern);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
    }

    public void setUpActions(){
        count.setOnClickListener((view)->nextActivity("count"));
        //pattern.setOnClickListener((view)->nextActivity("pattern"));
        addition.setOnClickListener((view)->nextActivity("addition"));
        subtraction.setOnClickListener((View)->nextActivity("subtraction"));
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