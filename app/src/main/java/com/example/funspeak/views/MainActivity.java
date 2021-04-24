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

    private Button animals, food, verbs, synonyms, back;
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
        animals = findViewById(R.id.animals);
        food = findViewById(R.id.food);
        verbs = findViewById(R.id.verbs);
        synonyms = findViewById(R.id.synonymsButton);
        back = findViewById(R.id.back);
    }

    public void setUpActions(){
        animals.setOnClickListener((view)->nextActivity("Animals"));
        food.setOnClickListener((view)->nextActivity("Food"));
        verbs.setOnClickListener((view)->nextActivity("Verbs"));
        synonyms.setOnClickListener((View)->nextActivity());
        back.setOnClickListener(v -> {
            startActivity(new Intent(this, LanguageSelection.class));
        });
    }

    public void nextActivity(){
        int r = (int)(Math.random() * 2);
        Intent intent = new Intent(this, SynonymsTask.class);
        intent.putExtra("language", language);
        Intent intent2 = new Intent(this, SelectDifficulty.class);
        intent2.putExtra("intent", intent);
        startActivity(intent2);
    }

    public void nextActivity(String type){
        int r = (int)(Math.random() * 2);
        Intent intent = new Intent(this,  r == 0 ? SelectPhotoTask.class : CompletePhraseTask.class);
        intent.putExtra("language", language);
        intent.putExtra("type",type);
        Intent intent2 = new Intent(this, SelectDifficulty.class);
        intent2.putExtra("intent", intent);
        startActivity(intent2);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LanguageSelection.class));
    }
}