package com.appsdj.olympicgamesquiz;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

public class QuizDataManager extends Application {
    public int quizScore;
    private SharedPreferences sp;

    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences(getResources().getString(R.string.app_name),
                MODE_PRIVATE);
        quizScore = sp.getInt("score",0);
    }

    public void updateScore(int increment)
    {
        quizScore = quizScore + increment;
        sp.edit().putInt("score", quizScore).commit();
        Log.v("UPDATED SCORE", "Score is: " + quizScore);
    }

    public void clearScore() {
        quizScore = 0;
    }
}
