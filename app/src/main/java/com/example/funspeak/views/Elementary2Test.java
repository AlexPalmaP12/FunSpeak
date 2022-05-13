package com.example.funspeak.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;
import com.example.funspeak.views.tasks.CompletePhraseTask;
import com.example.funspeak.views.tasks.SelectPhotoTask;

public class Elementary2Test extends AppCompatActivity {

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
        multiplication.setOnClickListener((view)->nextActivity("multiplication"));
        division.setOnClickListener((view)->nextActivity("division"));
        addition.setOnClickListener((view)->nextActivity("subtraction2"));
        subtraction.setOnClickListener((View)->nextActivity("addition2"));
    }

    public void nextActivity(String type){
        int r = (int)(Math.random() * 2);
        Intent intent = new Intent(this,  CompletePhraseTask.class );
        //intent.putExtra("language", language);
        intent.putExtra("type",type);
        //Intent intent2 = new Intent(this, SelectDifficulty.class);
        //intent2.putExtra("intent", intent);
        startActivity(intent);
    }
}