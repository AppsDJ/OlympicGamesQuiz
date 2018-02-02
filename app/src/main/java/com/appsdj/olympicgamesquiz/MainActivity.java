package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    QuizDataManager quizDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizDataManager = (QuizDataManager) getApplication();
        quizDataManager.clearScore();

        Log.v("INITIAL SCORE", "Score is: " + quizDataManager.quizScore);

        ImageButton summerImgBnt = (ImageButton) findViewById(R.id.summer_olympics_btn);
        summerImgBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //askQuestionOneSummer(v);
                Intent intent = new Intent(MainActivity.this, SummerOlympicsQ1.class);
                startActivity(intent);
            }
        });

        ImageButton winterImgBnt = (ImageButton) findViewById(R.id.winter_olympics_btn);
        winterImgBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //askQuestionOneWinter(v);
                Intent intent = new Intent(MainActivity.this, WinterOlympicsQ1.class);
                startActivity(intent);
            }
        });
    }

   /* public void askQuestionOneSummer(View v) {
        Intent intent = new Intent(this, SummerOlympicsQ1.class);
        startActivity(intent);
    }

    public void askQuestionOneWinter(View v) {
        Intent intent = new Intent(this, WinterOlympicsQ1.class);
        startActivity(intent);
    }*/
}
