package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Class defines the third question on Summer Olympics with the possible answers
 * It sets the correct answer and updates the score if this is selected
 */
public class SummerOlympicsQ3 extends AppCompatActivity {

    private QuizDataManager quizDataManager;
    private boolean gotRightAnswer;
    private final int CURRENT_QUESTION_NUMBER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer_olympics_q3);
        quizDataManager = (QuizDataManager) getApplication();
        gotRightAnswer = false;

        setUpInitialUI();
        setCorrectAnswer();
        setUpMoveToNextQuestion();
    }

    /**
     * set up the UI for the third question with its answers
     */
    public void setUpInitialUI() {

        String questionOne = quizDataManager.questionsSummerGames[2][0];
        String answerOne = quizDataManager.questionsSummerGames[2][1];
        String answerTwo = quizDataManager.questionsSummerGames[2][2];
        String answerThree = quizDataManager.questionsSummerGames[2][3];
        String answerFour = quizDataManager.questionsSummerGames[2][4];
        String answerFive = quizDataManager.questionsSummerGames[2][5];

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question3);

        TextView questionValue = (TextView) findViewById(R.id.question_value);
        questionValue.setText(questionOne);

        RadioButton answerOneValue = (RadioButton) findViewById(R.id.answer_1);
        answerOneValue.setText(answerOne);

        RadioButton answerTwoValue = (RadioButton) findViewById(R.id.answer_2);
        answerTwoValue.setText(answerTwo);

        RadioButton answerThreeValue = (RadioButton) findViewById(R.id.answer_3);
        answerThreeValue.setText(answerThree);

        RadioButton answerFourValue = (RadioButton) findViewById(R.id.answer_4);
        answerFourValue.setText(answerFour);

        RadioButton answerFiveValue = (RadioButton) findViewById(R.id.answer_5);
        answerFiveValue.setText(answerFive);
    }

    /**
     * set answer 4 as the correct answer: expect it to be checked
     */
    public void setCorrectAnswer() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.answer_4) {
                    gotRightAnswer = true;
                }
            }
        });
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
                updateScore();
                moveToNextQuestion(v);
            }
        });
    }

    /**
     * go to the next question
     */
    public void moveToNextQuestion(View v) {
        Intent intent = new Intent(this, SummerOlympicsQ4.class);
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
