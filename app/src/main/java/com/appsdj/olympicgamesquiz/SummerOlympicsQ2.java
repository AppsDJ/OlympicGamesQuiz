package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class SummerOlympicsQ2 extends AppCompatActivity {

    public QuizDataManager quizDataManager;
    public int numberOfCorrectAnswers = 555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_q2);

        ImageButton restartQuiz = (ImageButton) findViewById(R.id.restart_quiz);
        restartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartQuiz(v);
            }
        });

        quizDataManager = (QuizDataManager) getApplication();
        quizDataManager.updateScore(numberOfCorrectAnswers);
        Log.v("SCORE IN Q2 finish", "Sore in Q2 is: " + quizDataManager.quizScore);

    }

    public void restartQuiz (View v) {

        Log.v("SCORE IN Q2", "Sore in Q2 is: " + quizDataManager.quizScore);
        quizDataManager.clearScore();
        startActivity(new Intent(this.getBaseContext(), MainActivity.class));
    }
}
