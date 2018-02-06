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
 * Class defines the first question on Winter Olympics with the possible answers
 * It sets the correct answer and updates the score if this is selected
 */
public class WinterOlympicsQ1 extends AppCompatActivity {

    private QuizDataManager quizDataManager;
    private boolean gotRightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_olympics_q1);
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

        String questionOne = quizDataManager.questionsWinterGames[0][0];
        String answerOne = quizDataManager.questionsWinterGames[0][1];
        String answerTwo = quizDataManager.questionsWinterGames[0][2];
        String answerThree = quizDataManager.questionsWinterGames[0][3];
        String answerFour = quizDataManager.questionsWinterGames[0][4];
        String answerFive = quizDataManager.questionsWinterGames[0][5];

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question1);

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
     * set answer 3 as the correct answer: expect it to be checked
     */
    public void setCorrectAnswer() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.answer_3) {
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
        Intent intent = new Intent(this, WinterOlympicsQ2.class);
        startActivity(intent);
    }
}
