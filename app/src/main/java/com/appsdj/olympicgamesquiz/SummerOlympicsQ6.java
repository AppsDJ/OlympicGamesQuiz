package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SummerOlympicsQ6 extends AppCompatActivity {

    private QuizDataManager quizDataManager;
    private String lastAnswerSummerGames;
    private String answerInEditText;
    private boolean gotRightAnswer;
    private final int CURRENT_QUESTION_NUMBER = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_q6);
        quizDataManager = (QuizDataManager) getApplication();
        gotRightAnswer = false;

        setUpInitialUI();
        setCorrectAnswer();
        setUpMoveToNextQuestion();
    }

    /**
     * set up the UI for the first question with its answers
     */
    public void setUpInitialUI() {

        String lastQuestionSummerGames = quizDataManager.lastQuestionSummerGames;
//        String lastQuestionWinterGames = quizDataManager.lastQuestionWinterGames;
//        String lastAnswerWinterGames = quizDataManager.lastAnswerWinterGames;

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question6);

        TextView questionValue = (TextView) findViewById(R.id.question_value);
        questionValue.setText(lastQuestionSummerGames);

    }

    /**
     * set answer "1896" as the correct answer, as in quizDataManager.lastAnswerSummerGames
     */
    public void setCorrectAnswer() {
        lastAnswerSummerGames = quizDataManager.lastAnswerSummerGames;
    }

    /**
     * check for correct answer; if that was selected increment score
     */
    public void updateScore() {
        if (gotRightAnswer) {
            quizDataManager.incrementScore();
            quizDataManager.recordCorrectAnswers(CURRENT_QUESTION_NUMBER);
        } else {
            quizDataManager.recordIncorrectAnswers(CURRENT_QUESTION_NUMBER);
        }
    }

    /**
     * set up button to move to the next question
     */
    public void setUpMoveToNextQuestion() {
        ImageButton askNextQuestionBtn = (ImageButton) findViewById(R.id.ask_next_question_btn);
        askNextQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.answer_edit_text);
                answerInEditText = editText.getText().toString();

                if (answerInEditText.equals(lastAnswerSummerGames)) {
                    gotRightAnswer = true;
                }

                updateScore();
                showQuizResults(v);
            }
        });
    }

    /**
     * go to the quiz results
     */
    public void showQuizResults(View v) {
        Intent intent = new Intent(this, SummerOlympicsQuizResults.class);
        startActivity(intent);
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
