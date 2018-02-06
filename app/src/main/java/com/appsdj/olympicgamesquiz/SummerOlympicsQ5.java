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
 * Class defines the fifth question on Summer Olympics with the possible answers
 * It sets the correct answer and updates the score if this is selected
 */
public class SummerOlympicsQ5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_summer_olympics_q5);

        // make data available from the Data Manager
        quizDataManager = (QuizDataManager) getApplication();

        setUpInitialUI();
        setCorrectAnswers();
        setUpMoveToQuizResults();
    }

    /**
     * set up the UI for the fifth question with its answers
     */
    public void setUpInitialUI() {

        String questionTwo = quizDataManager.questionsSummerGames[4][0];
        String answerOne = quizDataManager.questionsSummerGames[4][1];
        String answerTwo = quizDataManager.questionsSummerGames[4][2];
        String answerThree = quizDataManager.questionsSummerGames[4][3];
        String answerFour = quizDataManager.questionsSummerGames[4][4];
        String answerFive = quizDataManager.questionsSummerGames[4][5];

        TextView questionLabel = (TextView) findViewById(R.id.question_label);
        questionLabel.setText(R.string.question5);

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
    }

    /**
     * set up button to move to quiz results
     */
    public void setUpMoveToQuizResults() {
        ImageButton goToQuizResultsBtn = (ImageButton) findViewById(R.id.go_to_quiz_results_btn);
        goToQuizResultsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
}

