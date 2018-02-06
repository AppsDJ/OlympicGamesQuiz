package com.appsdj.olympicgamesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Class defines the second question on Winter Olympics with the possible answers
 * It sets the correct answer and updates the score if this is selected
 */
public class WinterOlympicsQ2 extends AppCompatActivity {

    private CheckBox answerOneValue;
    private CheckBox answerTwoValue;
    private CheckBox answerThreeValue;
    private CheckBox answerFourValue;
    private CheckBox answerFiveValue;
    private boolean answerOneIsChecked;
    private boolean answerThreeIsChecked;
    private QuizDataManager quizDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter_olympics_q2);

        quizDataManager = (QuizDataManager) getApplication();

        setUpInitialUI();
        setCorrectAnswers();
        setUpMoveToNextQuestion();
    }

    /**
     * set up the UI for the second question with its answers
     */
    public void setUpInitialUI() {

        String questionTwo = quizDataManager.questionsWinterGames[1][0];
        String answerOne = quizDataManager.questionsWinterGames[1][1];
        String answerTwo = quizDataManager.questionsWinterGames[1][2];
        String answerThree = quizDataManager.questionsWinterGames[1][3];
        String answerFour = quizDataManager.questionsWinterGames[1][4];
        String answerFive = quizDataManager.questionsWinterGames[1][5];

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question2);

        TextView questionValue = (TextView) findViewById(R.id.question_value);
        questionValue.setText(questionTwo);

        answerOneValue = (CheckBox) findViewById(R.id.answer_1);
        answerOneValue.setText(answerOne);

        answerTwoValue = (CheckBox) findViewById(R.id.answer_2);
        answerTwoValue.setText(answerTwo);

        answerThreeValue = (CheckBox) findViewById(R.id.answer_3);
        answerThreeValue.setText(answerThree);

        answerFourValue = (CheckBox) findViewById(R.id.answer_4);
        answerFourValue.setText(answerFour);

        answerFiveValue = (CheckBox) findViewById(R.id.answer_5);
        answerFiveValue.setText(answerFive);
    }

    /**
     * set answers 1 and 3 as the correct collective answer: expect them to be checked
     */
    public void setCorrectAnswers() {
        // check answer 1 on list
        answerOneValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked){
                    answerOneIsChecked = true;
                }
            }
        });
        // check answer 3 on list
        answerThreeValue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked){
                    answerThreeIsChecked = true;
                }
            }
        });
    }

    /**
     * check for correct answers; if 1 and 3 were selected increment score
     */
    public void updateScore() {
        if (answerOneIsChecked && answerThreeIsChecked) {
            quizDataManager.incrementScore();
        }
        Log.v("SCORE AFTER 2", "Sore in Q2 is: " + quizDataManager.quizScore);
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
                Log.v("ARE CHECKED", "are checked-: " + answerOneIsChecked + " " + answerThreeIsChecked);
                moveToNextQuestion(v);
            }
        });
    }

    /**
     * go to the next question
     */
    public void moveToNextQuestion(View v) {
        Intent intent = new Intent(this, WinterOlympicsQ3.class);
        startActivity(intent);
    }
}

