package com.example.funspeak.views.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.funspeak.R;
import com.example.funspeak.tasksbuilders.SelectPhotoTaskBuilder;
import com.example.funspeak.tasksmodels.SelectPhotoTaskModel;
import com.example.funspeak.views.Correct;
import com.example.funspeak.views.FinalScore;
import com.example.funspeak.views.Incorrect;
import com.squareup.picasso.Picasso;

public class SelectPhotoTask extends AppCompatActivity {

    private ImageView option1, option2, option3, option4;
    private TextView selectPhoto, nu1, nu2;
    private SelectPhotoTaskModel selectPhotoTaskModel;
    private int i, max, correct, incorrect, language;
    private String type;
    private CountDownTimer mCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_photo_task);
        bindComponents();
        setUpModel();
        setUpActions();
        setUpTimer();
    }

    public void setUpActions(){
        option1.setOnClickListener(v -> compareImagesId(selectPhotoTaskModel.getOption1ImageId()));
        option2.setOnClickListener(v -> compareImagesId(selectPhotoTaskModel.getOption2ImageId()));
        option3.setOnClickListener(v -> compareImagesId(selectPhotoTaskModel.getOption3ImageId()));
        option4.setOnClickListener(v ->compareImagesId(selectPhotoTaskModel.getOption4ImageId()));
    }

    public void compareImagesId(int imageId){
        next(imageId == selectPhotoTaskModel.getCorrectImageId());
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

        selectPhotoTaskModel = SelectPhotoTaskBuilder.generateSelectPhotoModel(type,language);
        Picasso.get().load(selectPhotoTaskModel.getOption1ImageId()).fit().centerCrop().into(option1);
        Picasso.get().load(selectPhotoTaskModel.getOption2ImageId()).fit().centerCrop().into(option2);
        Picasso.get().load(selectPhotoTaskModel.getOption3ImageId()).fit().centerCrop().into(option3);
        Picasso.get().load(selectPhotoTaskModel.getOption4ImageId()).fit().centerCrop().into(option4);
        selectPhoto.append(selectPhotoTaskModel.getCorrectOptionName());

        max = getIntent().getIntExtra("max",10);
        incorrect = getIntent().getIntExtra("incorrect",0);
        correct = getIntent().getIntExtra("correct", 0);

        nu1.setText("" + (incorrect + correct + 1));
        nu2.setText("" + max);
    }

    public void bindComponents(){
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        selectPhoto = findViewById(R.id.correctImageName);
        nu1 = findViewById(R.id.nu1);
        nu2 = findViewById(R.id.nu2);
    }

    public void setUpTimer(){
        ProgressBar mProgressBar;
        mProgressBar=(ProgressBar)findViewById(R.id.selectPhotoTimer);
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