package com.appsdj.olympicgamesquiz;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Class manages all data for the app: questions, answers and score
 * It uses SharedPreferences to save and share the data between various activities
 */
public class QuizDataManager extends Application {
    public int quizScore;
    public SharedPreferences sp;

    public String[][] questionsSummerGames = new String[5][6];
    public String[][] questionsWinterGames = new String[5][6];

    public void onCreate() {
        super.onCreate();

        //set up SharedPreferences with an initial value for score
        sp = getSharedPreferences(getResources().getString(R.string.app_name),
                MODE_PRIVATE);
        quizScore = sp.getInt("score",0);

        // assign questions on Summer Olympics to array elements
        questionsSummerGames[0][0] = "Q1s: ";
        questionsSummerGames[0][1] = "Q1s-a1: ";
        questionsSummerGames[0][2] = "Q1s-a2: ";
        questionsSummerGames[0][3] = "Q1s-a3: ";
        questionsSummerGames[0][4] = "Q1-a4: ";
        questionsSummerGames[0][5] = "Q1-a5: ";

        questionsSummerGames[1][0] = "Q2s: ";
        questionsSummerGames[1][1] = "Q2s-a1: ";
        questionsSummerGames[1][2] = "Q2s-a2: ";
        questionsSummerGames[1][3] = "Q2s-a3: ";
        questionsSummerGames[1][4] = "Q2s-a4: ";
        questionsSummerGames[1][5] = "Q2s-a5: ";

        questionsSummerGames[2][0] = "Q4s: ";
        questionsSummerGames[2][1] = "Q4s-a1: ";
        questionsSummerGames[2][2] = "Q4s-a2: ";
        questionsSummerGames[2][3] = "Q4s-a3: ";
        questionsSummerGames[2][4] = "Q4s-a4: ";
        questionsSummerGames[2][5] = "Q4s-a5: ";

        questionsSummerGames[3][0] = "Q4s: ";
        questionsSummerGames[3][1] = "Q4s-a1: ";
        questionsSummerGames[3][2] = "Q4s-a2: ";
        questionsSummerGames[3][3] = "Q4s-a3: ";
        questionsSummerGames[3][4] = "Q4s-a4: ";
        questionsSummerGames[3][5] = "Q4s-a5: ";

        questionsSummerGames[4][0] = "Q5s: ";
        questionsSummerGames[4][1] = "Q5s-a1: ";
        questionsSummerGames[4][2] = "Q5s-a2: ";
        questionsSummerGames[4][3] = "Q5s-a3: ";
        questionsSummerGames[4][4] = "Q5s-a4: ";
        questionsSummerGames[4][5] = "Q5s-a5: ";

        // assign questions on Winter Olympics to array elements
        questionsWinterGames[0][0] = "Q1w: ";
        questionsWinterGames[0][1] = "Q1w-a1: ";
        questionsWinterGames[0][2] = "Q1w-a2: ";
        questionsWinterGames[0][3] = "Q1w-a3: ";
        questionsWinterGames[0][4] = "Q1w-a4: ";
        questionsWinterGames[0][5] = "Q1w-a5: ";

        questionsWinterGames[1][0] = "Q2w: ";
        questionsWinterGames[1][1] = "Q2w-a1: ";
        questionsWinterGames[1][2] = "Q2w-a2: ";
        questionsWinterGames[1][3] = "Q2w-a3: ";
        questionsWinterGames[1][4] = "Q2w-a4: ";
        questionsWinterGames[1][5] = "Q2w-a5: ";

        questionsWinterGames[0][0] = "Q4w: ";
        questionsWinterGames[0][1] = "Q4w-a1: ";
        questionsWinterGames[0][2] = "Q4w-a2: ";
        questionsWinterGames[0][3] = "Q4w-a3: ";
        questionsWinterGames[0][4] = "Q4w-a4: ";
        questionsWinterGames[0][5] = "Q4w-a5: ";

        questionsWinterGames[0][0] = "Q4w: ";
        questionsWinterGames[0][1] = "Q4w-a1: ";
        questionsWinterGames[0][2] = "Q4w-a2: ";
        questionsWinterGames[0][3] = "Q4w-a3: ";
        questionsWinterGames[0][4] = "Q4w-a4: ";
        questionsWinterGames[0][5] = "Q4w-a5: ";

        questionsWinterGames[0][0] = "Q5w: ";
        questionsWinterGames[0][1] = "Q5w-a1: ";
        questionsWinterGames[0][2] = "Q5w-a2: ";
        questionsWinterGames[0][3] = "Q5w-a3: ";
        questionsWinterGames[0][4] = "Q5w-a4: ";
        questionsWinterGames[0][5] = "Q5w-a5: ";

    }

    /**
     * method increments score when a question is answered correctly
     */
    public void incrementScore()
    {
        quizScore++;
        sp.edit().putInt("score", quizScore).commit();
        Log.v("UPDATED SCORE", "Score is: " + quizScore);
    }

    /**
     * method clears score when quiz is restarted from results activity
     */
    public void clearScore() {
        quizScore = 0;
    }
}
