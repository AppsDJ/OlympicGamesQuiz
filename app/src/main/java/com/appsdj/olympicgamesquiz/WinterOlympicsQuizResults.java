package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Class displays the quiz score and the number of the incorrectly answered questions
 * It also give the choice to go back to the start page to replay quiz
 */
public class WinterOlympicsQuizResults extends AppCompatActivity {

    public QuizDataManager quizDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_olympics_quiz_results);

        quizDataManager = (QuizDataManager) getApplication();
        Log.v("FINAL SCORE", "Sore in Q2 is: " + quizDataManager.quizScore);

        ImageButton restartQuizButton = (ImageButton) findViewById(R.id.restart_quiz);
        restartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartQuiz(v);
            }
        });

    }

    public void restartQuiz (View v) {
        quizDataManager.clearScore();
        startActivity(new Intent(this.getBaseContext(), MainActivity.class));
    }
}