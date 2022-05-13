package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.funspeak.R;



import com.example.funspeak.views.tasks.CompletePhraseTask;
import com.example.funspeak.views.tasks.SelectPhotoTask;
import com.example.funspeak.views.tasks.SynonymsTask;

public class MainActivity extends AppCompatActivity {

    private Button preschool, elementary, elementary2, elementary3, back ;
    private int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindComponents();
        setUpActions();


        language = getIntent().getIntExtra("language",0);
    }

    public void bindComponents(){
        preschool = findViewById(R.id.preschool);
        elementary = findViewById(R.id.elementary);
        elementary2 = findViewById(R.id.elementary2);
        elementary3 = findViewById(R.id.elementary3);
        back = findViewById(R.id.back);
    }

    public void setUpActions(){
        preschool.setOnClickListener((view)->{
            startActivity(new Intent(this, PreschoolSelect.class));
        });
        elementary.setOnClickListener((view)->{
            startActivity(new Intent(this, ElementarySelect.class));
        });
        elementary2.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary2Select.class));
        });
        elementary3.setOnClickListener((view)->{
            startActivity(new Intent(this, Elementary3Select.class));
        });
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, LanguageSelection.class));
        });
    }

    public void nextActivity(){

    }

    public void nextActivity(String type){

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LanguageSelection.class));
    }
}