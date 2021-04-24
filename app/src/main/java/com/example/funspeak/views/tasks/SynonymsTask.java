package com.example.funspeak.views.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.funspeak.R;
import com.example.funspeak.tasksbuilders.SelectPhotoTaskBuilder;
import com.example.funspeak.tasksbuilders.SynonymsTaskBuilder;
import com.example.funspeak.tasksmodels.SelectPhotoTaskModel;
import com.example.funspeak.tasksmodels.SynonymsTaskModel;
import com.example.funspeak.views.Correct;
import com.example.funspeak.views.FinalScore;
import com.example.funspeak.views.Incorrect;
import com.squareup.picasso.Picasso;

public class SynonymsTask extends AppCompatActivity {

    private Button option1, option2, option3, option4;
    private TextView synonym, nu1, nu2;
    private SynonymsTaskModel synonymsTaskModel;
    private int i, max, correct, incorrect, language, time;
    //private String type;
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonyms_task);
        bindComponents();
        setUpActions();
        setUpModel();
        setUpTimer();
        setUpModel();
    }

    public void setUpModel(){
        language = getIntent().getIntExtra("language", 0);
        //type = getIntent().getStringExtra("type");

        synonymsTaskModel = SynonymsTaskBuilder.generateSynonymsTaskModel(language);
        option1.setText(synonymsTaskModel.getSynonym1());
        option2.setText(synonymsTaskModel.getSynonym2());
        option3.setText(synonymsTaskModel.getSynonym3());
        option4.setText(synonymsTaskModel.getSynonym4());
        synonym.setText(synonymsTaskModel.getSynonym());

        max = getIntent().getIntExtra("max",10);
        incorrect = getIntent().getIntExtra("incorrect",0);
        correct = getIntent().getIntExtra("correct", 0);

        nu1.setText("" + (incorrect + correct + 1));
        nu2.setText("" + max);
    }

    public void setUpActions(){
        option1.setOnClickListener(v -> compareImagesId(synonymsTaskModel.getSynonym1()));
        option2.setOnClickListener(v -> compareImagesId(synonymsTaskModel.getSynonym2()));
        option3.setOnClickListener(v -> compareImagesId(synonymsTaskModel.getSynonym3()));
        option4.setOnClickListener(v ->compareImagesId(synonymsTaskModel.getSynonym4()));
    }

    public void compareImagesId(String synonym){
        next(synonym == synonymsTaskModel.getCorrectSynonym());
    }

    private void bindComponents(){
        option1 = findViewById(R.id.synonymOption1);
        option2 = findViewById(R.id.synonymOption2);
        option3 = findViewById(R.id.synonymOption3);
        option4 = findViewById(R.id.synonymOption4);

        synonym = findViewById(R.id.synonym);
        nu1 = findViewById(R.id.synonymNu1);
        nu2 = findViewById(R.id.synonymNu2);
    }

    public void next(boolean correct){
        mCountDownTimer.cancel();
        Intent intent;
        if((this.correct+incorrect + 1) == max){
            intent = new Intent(this, FinalScore.class);
        }else {
            intent = new Intent(this, SynonymsTask.class);
        }
        //intent.putExtra("type", type);
        intent.putExtra("language",language);
        intent.putExtra("max",max);
        intent.putExtra("time",time);
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

    public void setUpTimer(){
        time = getIntent().getIntExtra("time",5000);
        ProgressBar mProgressBar;
        mProgressBar=(ProgressBar)findViewById(R.id.synonymsTimer);
        mProgressBar.setProgress(i);
        mCountDownTimer=new CountDownTimer(time,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                mProgressBar.setProgress((int)i*100/(time/50));
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