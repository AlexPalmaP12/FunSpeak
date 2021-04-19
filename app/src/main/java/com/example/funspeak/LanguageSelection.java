package com.example.funspeak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.funspeak.views.MainActivity;

public class LanguageSelection extends AppCompatActivity {

    private Spinner spinner;
    private Button start, exit;
    int language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);
        bindComponents();
        setUpSpinner();
        setUpActions();
    }

    public void bindComponents(){
        spinner = (Spinner) findViewById(R.id.languagesSpinner);
        start = findViewById(R.id.start);
        exit = findViewById(R.id.exit);
    }

    public void setUpActions(){
        start.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("language",language);
            startActivity(intent);
        });
        exit.setOnClickListener(v -> this.finishAffinity());
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void setUpSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
    }
}