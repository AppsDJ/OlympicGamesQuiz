package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class WinterOlympicsQ6 extends AppCompatActivity {

    private QuizDataManager quizDataManager;
    private String lastAnswerWinterGames;
    private String answerInEditText;
    private boolean gotRightAnswer;
    private final int CURRENT_QUESTION_NUMBER = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_olympics_q6);
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

        String lastQuestionWinterGames = quizDataManager.lastQuestionWinterGames;

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question6);

        TextView questionValue = (TextView) findViewById(R.id.question_value);
        questionValue.setText(lastQuestionWinterGames);

    }

    /**
     * set answer "1896" as the correct answer, as in quizDataManager.lastAnswerSummerGames
     */
    public void setCorrectAnswer() {
        lastAnswerWinterGames = quizDataManager.lastAnswerWinterGames;
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

                if (answerInEditText.equals(lastAnswerWinterGames)) {
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
        Intent intent = new Intent(this, WinterOlympicsQuizResults.class);
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
