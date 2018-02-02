package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SummerOlympicsQ1 extends AppCompatActivity {

    public QuizDataManager quizDataManager;
    public int numberOfCorrectAnswers = 113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_q1);


        ImageButton askQuestionTwoSummerBtn = (ImageButton) findViewById(R.id.ask_question_two_summer_btn);
        askQuestionTwoSummerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askQuestionTwoSummer(v);
                //Intent intent = new Intent(SummerOlympicsQ1.this, SummerOlympicsQ2.class);
                //startActivity(intent);
            }
        });

        quizDataManager = (QuizDataManager) getApplication();
        quizDataManager.updateScore(numberOfCorrectAnswers);


    }

    public void askQuestionTwoSummer(View v) {
        Intent intent = new Intent(this, SummerOlympicsQ2.class);
        startActivity(intent);
    }
}
