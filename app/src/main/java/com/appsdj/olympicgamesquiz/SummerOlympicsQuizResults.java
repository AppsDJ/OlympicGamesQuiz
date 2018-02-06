package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Class displays the quiz score and the number of the incorrectly answered questions
 * It also give the choice to go back to the start page to replay quiz
 */
public class SummerOlympicsQuizResults extends AppCompatActivity {

    public QuizDataManager quizDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_quiz_results);

        quizDataManager = (QuizDataManager) getApplication();
        Log.v("FINAL SCORE", "Score in Q2 is: " + quizDataManager.quizScore);

        // extract player's first name if full name was entered
        String playerName = quizDataManager.playerName;
        String [] playerWholeName = playerName.split(" ");
        String playerFirstName = playerWholeName[0];

        TextView scoreLabel = (TextView) findViewById(R.id.your_score_label);
        scoreLabel.setText(playerFirstName + ", " + "your score is: ");

        TextView scoreValue = (TextView) findViewById(R.id.your_score_value);
        scoreValue.setText(quizDataManager.quizScore + " out of 5");

        // retrieve the correct answers from set in Data Manager
        Set<String> correctAnswers = quizDataManager.correctAnswers;

        // sort Set - covert to ArrayList first (Set can't be sorted directly)
        List sortedAnswersList = new ArrayList(correctAnswers);
        Collections.sort(sortedAnswersList);
        String correctAnswersString = "";
        for (Object s : sortedAnswersList) {
            //build string to print on Results page
            correctAnswersString += " #" + s;
        }

        Log.v("SORTED", "sorted is: " + sortedAnswersList);

        TextView correctAnswersValue = (TextView) findViewById(R.id.correct_answers_value);
        correctAnswersValue.setText(correctAnswersString);

        // retrieve the incorrect answers from set in Data Manager
        Set<String> incorrectAnswers = quizDataManager.incorrectAnswers;
        // sort Set - covert to ArrayList first (Set can't be sorted directly)
        List sortedIncorrectAnswersList = new ArrayList(incorrectAnswers);
        Collections.sort(sortedIncorrectAnswersList);
        String incorrectAnswersString = "";
        for (Object s : sortedIncorrectAnswersList) {
            //build string to print on Results page
            incorrectAnswersString += " #" + s;
        }

        TextView incorrectAnswersValue = (TextView) findViewById(R.id.incorrect_answers_value);
        if (incorrectAnswersString.isEmpty()) {
            incorrectAnswersValue.setText("None. Well done!");
        } else {
            incorrectAnswersValue.setText(incorrectAnswersString);
        }


        Log.v("FINAL PLAYER", "player name is: " + playerName);

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
        quizDataManager.clearPlayerName();
        startActivity(new Intent(this.getBaseContext(), MainActivity.class));
    }
}
