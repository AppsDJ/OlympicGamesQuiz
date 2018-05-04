package com.appsdj.olympicgamesquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * MainActivity sets up the start page for the quiz app
 */
public class MainActivity extends AppCompatActivity {

    public QuizDataManager quizDataManager;
    public EditText editText;
    public String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizDataManager = (QuizDataManager) getApplication();
        // ensure quiz is started with a score of 0
        quizDataManager.clearScore();

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

                editText = (EditText) findViewById(R.id.player_name_edit_text);
                playerName = editText.getText().toString();

                // check for empty field in player name edit_text
                if (playerName.isEmpty()) {
                    preventEmptyNameField();
                } else {
                    savePlayerName(playerName);
                    Intent intent = new Intent(MainActivity.this, SummerOlympicsQ1.class);
                    startActivity(intent);
                }
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

                editText = (EditText) findViewById(R.id.player_name_edit_text);
                playerName = editText.getText().toString();

                // check for empty field in player name edit_text
                if (playerName.isEmpty()) {
                    preventEmptyNameField();
                } else {
                    savePlayerName(playerName);
                    Intent intent = new Intent(MainActivity.this, WinterOlympicsQ1.class);
                    startActivity(intent);
                }

            }
        });
    }

    public void preventEmptyNameField() {
        Context context = getApplicationContext();
        CharSequence text = "Please enter you name to play the quiz";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        return;
    }

    public void savePlayerName(String playerName) {
        quizDataManager.savePlayerName(playerName);
    }

}
