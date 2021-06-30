package com.example.funspeak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.funspeak.R;
import com.example.funspeak.views.MainActivity;

public class LanguageSelection extends AppCompatActivity {

    private Spinner spinner;
    private Button start;
    private Button exit;
    private ImageView img;
    private TextView txt;
    private TextView txt2;
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
        img = (ImageView) findViewById(R.id.imageView3);
        txt = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
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
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                language = position;
                String selection = spinner.getSelectedItem().toString();
                if(selection.equals("English")){
                    img.setImageResource(R.drawable.usflag);
                    txt.setText("Welcome");
                    txt2.setText("Select a language to learn:");
                    start.setText("Start");
                    exit.setText("Exit");
                } else if(selection.equals("Spanish")){
                    img.setImageResource(R.drawable.espflag);
                    txt.setText("Bienvenido");
                    txt2.setText("Seleccione un idioma a aprender:");
                    start.setText("Iniciar");
                    exit.setText("Salir");
                }
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