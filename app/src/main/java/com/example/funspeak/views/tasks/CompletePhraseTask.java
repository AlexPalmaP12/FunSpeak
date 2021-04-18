package com.example.funspeak.views.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.funspeak.R;
import com.example.funspeak.tasksbuilders.CompletePhraseTaskBuilder;
import com.example.funspeak.tasksmodels.CompletePhraseTaskModel;
import com.example.funspeak.views.Correct;
import com.example.funspeak.views.FinalScore;
import com.example.funspeak.views.Incorrect;

public class CompletePhraseTask extends AppCompatActivity {

    private TextView phrase, nu1, nu2;
    private Button option1, option2, option3, option4;
    private ProgressBar progressBar;
    private int i, max, correct, incorrect, language;
    private CountDownTimer mCountDownTimer;
    private String type;
    private CompletePhraseTaskModel completePhraseTaskModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_phrase_task);
        bindComponents();
        setUpModel();
        setUpActions();
        setUpTimer();
    }

    public void setUpActions(){
        option1.setOnClickListener(v -> compareAnswers(completePhraseTaskModel.getOption1()));
        option2.setOnClickListener(v -> compareAnswers(completePhraseTaskModel.getOption2()));
        option3.setOnClickListener(v -> compareAnswers(completePhraseTaskModel.getOption3()));
        option4.setOnClickListener(v -> compareAnswers(completePhraseTaskModel.getOption4()));
    }

    public void compareAnswers(String answer){
        next(answer == completePhraseTaskModel.getCorrectOption());
    }

    public void next(boolean correct){
        mCountDownTimer.cancel();
        Intent intent;
        if((this.correct+incorrect + 1) == max){
            intent = new Intent(this, FinalScore.class);
        }else {
            int r = (int)(Math.random() * 2);
            intent = new Intent(this, r == 0 ? SelectPhotoTask.class : CompletePhraseTask.class);
        }
        intent.putExtra("type", type);
        intent.putExtra("language",language);
        intent.putExtra("max",max);
        Intent middleIntent;
        if(correct) {
            intent.putExtra("correct", this.correct + 1);
            intent.putExtra("incorrect", incorrect);
            middleIntent = new Intent(this, Correct.class);
        }else{
            intent.putExtra("correct", this.correct);
            intent.putExtra("incorrect", incorrect+1);
            middleIntent = new Intent(this, Incorrect.class);
        }
        middleIntent.putExtra("intent",intent);
        startActivity(middleIntent);

    }

    public void setUpModel(){
        language = getIntent().getIntExtra("language", 0);
        type = getIntent().getStringExtra("type");

        completePhraseTaskModel = CompletePhraseTaskBuilder.generateCompletePhraseTask(type,language);
        phrase.setText(completePhraseTaskModel.getPhrase());
        option1.setText(completePhraseTaskModel.getOption1());
        option2.setText(completePhraseTaskModel.getOption2());
        option3.setText(completePhraseTaskModel.getOption3());
        option4.setText(completePhraseTaskModel.getOption4());

        max = getIntent().getIntExtra("max",10);
        incorrect = getIntent().getIntExtra("incorrect",0);
        correct = getIntent().getIntExtra("correct", 0);

        nu1.setText("" + (incorrect + correct + 1));
        nu2.setText("" + max);
    }

    public void bindComponents(){
        phrase = findViewById(R.id.phrase);
        nu1 = findViewById(R.id.phraseNu1);
        nu2 = findViewById(R.id.phraseNu2);
        option1 = findViewById(R.id.phraseOption1);
        option2 = findViewById(R.id.phraseOption2);
        option3 = findViewById(R.id.phraseOption3);
        option4 = findViewById(R.id.phraseOption4);
        progressBar = findViewById(R.id.phraseTimer);
    }

    public void setUpTimer(){
        ProgressBar mProgressBar = progressBar;
        mProgressBar.setProgress(i);
        mCountDownTimer=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                mProgressBar.setProgress((int)i*100/(5000/1000));
            }
            @Override
            public void onFinish() {
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                i++;
                mProgressBar.setProgress(100);
                next(false);
            }
        };
        mCountDownTimer.start();
    }

    @Override
    public void onBackPressed() {
    }
}