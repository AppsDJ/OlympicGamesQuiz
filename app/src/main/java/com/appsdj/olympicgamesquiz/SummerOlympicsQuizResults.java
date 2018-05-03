package com.appsdj.olympicgamesquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Class displays the quiz score and the number of the correctly/incorrectly answered questions
 * It also give the choice to go back to the start page to replay quiz
 */
public class SummerOlympicsQuizResults extends AppCompatActivity {

    public QuizDataManager quizDataManager;
    String playerFirstName;

    String correctAnswersString;
    String incorrectAnswersString;

    String summaryOnToast;
    String resultsOnToast;
    String correctAnswersOnToast;
    String incorrectAnswersOnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_quiz_results);

        //make data available
        quizDataManager = (QuizDataManager) getApplication();

        correctAnswersString = "";
        incorrectAnswersString = "";

        getPlayerFirstName();
        setUpInitialUI();

        ImageButton restartQuizButton = (ImageButton) findViewById(R.id.restart_quiz);
        restartQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartQuiz(v);
            }
        });

    }

    public void getPlayerFirstName() {
        // extract player's first name if full name was entered
        String playerName = quizDataManager.playerName;
        String [] playerWholeName = playerName.split(" ");
        playerFirstName = playerWholeName[0];
    }

    public void displayResultsToast(String correctAnswersString, String incorrectAnswersString) {

        Context context = getApplicationContext();

        summaryOnToast = "<< QUIZ RESULTS >>";
        resultsOnToast = "\n\n" + playerFirstName + ", your score is:\n" + quizDataManager.quizScore + " out of 6";
        correctAnswersOnToast = "\n\n" + "Questions answered correctly:\n";
        incorrectAnswersOnToast = "\n\n" + "Questions answered incorrectly:\n";
        //retrieveCorrectAnswers();

        if (correctAnswersString.isEmpty()) {
            correctAnswersOnToast += "None. Oh dear! Try again";
        } else {
            correctAnswersOnToast += correctAnswersString;
        }

        if (incorrectAnswersString.isEmpty()) {
            incorrectAnswersOnToast += "None. Well done!";
        } else {
            incorrectAnswersOnToast += incorrectAnswersString;
        }

        summaryOnToast += "\n" + resultsOnToast + correctAnswersOnToast + incorrectAnswersOnToast;

        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, summaryOnToast, duration);
        toast.show();
    }

    public void setUpInitialUI() {

        retrieveCorrectAnswers();
        retrieveIncorrectAnswers();

        displayResultsToast(correctAnswersString, incorrectAnswersString);

        TextView scoreLabel = (TextView) findViewById(R.id.your_score_label);
        scoreLabel.setText("Overall score: ");

        TextView scoreValue = (TextView) findViewById(R.id.your_score_value);
        scoreValue.setText(quizDataManager.quizScore + " out of 6");

        // display the values
        TextView correctAnswersValue = (TextView) findViewById(R.id.correct_answers_value);
        if (correctAnswersString.isEmpty()) {
            correctAnswersValue.setText("None");
        } else {
            correctAnswersValue.setText(correctAnswersString);
        }

        // display the values
        TextView incorrectAnswersValue = (TextView) findViewById(R.id.incorrect_answers_value);
        if (incorrectAnswersString.isEmpty()) {
            incorrectAnswersValue.setText("None");
        } else {
            incorrectAnswersValue.setText(incorrectAnswersString);
        }

    }

    public void retrieveCorrectAnswers() {

        // retrieve the correct answers from set in Data Manager
        Set<String> correctAnswers = quizDataManager.correctAnswers;

        // sort Set - covert to ArrayList first (Set can't be sorted directly)
        List sortedAnswersList = new ArrayList(correctAnswers);
        Collections.sort(sortedAnswersList);
        for (Object s : sortedAnswersList) {
            //build string to print on Results page
            correctAnswersString += " #" + s;
        }
    }

    public void retrieveIncorrectAnswers() {

        // retrieve the incorrect answers from set in Data Manager
        Set<String> incorrectAnswers = quizDataManager.incorrectAnswers;

        // sort Set - covert to ArrayList first (Set can't be sorted directly)
        List sortedIncorrectAnswersList = new ArrayList(incorrectAnswers);
        Collections.sort(sortedIncorrectAnswersList);
        for (Object s : sortedIncorrectAnswersList) {
            //build string to print on Results page
            incorrectAnswersString += " #" + s;
        }
    }

    public void restartQuiz (View v) {

        // clear all data
        quizDataManager.clearScore();
        quizDataManager.clearPlayerName();
        quizDataManager.clearCorrectAnswersList();
        quizDataManager.clearIncorrectAnswersList();

        // say "Thank you"
        Context context = getApplicationContext();
        CharSequence text = "Thank you for choosing to play again!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // and go
        startActivity(new Intent(this.getBaseContext(), MainActivity.class));
    }

    /*
    prevent return to the previous page as that would erroneously increase
    score if correct answer were selected on previous page
    */
    @Override
    public void onBackPressed() {
        // do nothing!
        return;
    }
}
