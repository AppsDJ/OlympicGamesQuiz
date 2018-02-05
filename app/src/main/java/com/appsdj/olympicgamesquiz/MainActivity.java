package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * MainActivity sets up the start page for the quiz app
 */
public class MainActivity extends AppCompatActivity {

    QuizDataManager quizDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizDataManager = (QuizDataManager) getApplication();
        // ensure quiz is started with a score of 0
        quizDataManager.clearScore();

        Log.v("INITIAL SCORE", "Score is: " + quizDataManager.quizScore);

        // start quiz on click
        startQuizOnSummerOlympics();
        startQuizOnWinterOlympics();
    }

    /**
     * On click the quiz starts by opening the first question on Summer Olympics
     */
    public void startQuizOnSummerOlympics() {
        ImageButton summerImgBnt = (ImageButton) findViewById(R.id.summer_olympics_btn);
        summerImgBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SummerOlympicsQ1.class);
                startActivity(intent);
            }
        });
    }

    /**
     * On click the quiz starts by opening the first question on Winter Olympics
     */
    public void startQuizOnWinterOlympics() {
        ImageButton winterImgBnt = (ImageButton) findViewById(R.id.winter_olympics_btn);
        winterImgBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WinterOlympicsQ1.class);
                startActivity(intent);
            }
        });
    }

}
