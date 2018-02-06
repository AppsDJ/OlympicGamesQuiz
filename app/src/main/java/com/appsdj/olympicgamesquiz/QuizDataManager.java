package com.appsdj.olympicgamesquiz;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Class manages all data for the app: questions, answers and score
 * It uses SharedPreferences to save and share the data between various activities
 */
public class QuizDataManager extends Application {
    public int quizScore;
    public String playerName;
    public Set<String> correctAnswers;
    public Set<String> incorrectAnswers;
    public SharedPreferences sp;

    public String[][] questionsSummerGames = new String[5][6];
    public String[][] questionsWinterGames = new String[5][6];

    public void onCreate() {
        super.onCreate();

        //set up SharedPreferences with an initial value for score
        sp = getSharedPreferences(getResources().getString(R.string.app_name),
                MODE_PRIVATE);
        quizScore = sp.getInt("score",0);
        playerName = sp.getString("player", "");

        correctAnswers = new HashSet<String>();
        sp.edit().putStringSet("correct_answers_set", correctAnswers);

        incorrectAnswers = new HashSet<String>();
        sp.edit().putStringSet("incorrect_answers_set", incorrectAnswers);

        // assign questions on Summer Olympics to array elements
        questionsSummerGames[0][0] = "What year were the first modern Summer Olympic Games held?";
        questionsSummerGames[0][1] = "1900";
        questionsSummerGames[0][2] = "1894";
        questionsSummerGames[0][3] = "1896";
        questionsSummerGames[0][4] = "1904";
        questionsSummerGames[0][5] = "1910";

        questionsSummerGames[1][0] = "Which two countries hosted the summer Olympics twice in total?";
        questionsSummerGames[1][1] = "Greece";
        questionsSummerGames[1][2] = "United States";
        questionsSummerGames[1][3] = "France";
        questionsSummerGames[1][4] = "United Kingdom";
        questionsSummerGames[1][5] = "China";

        questionsSummerGames[2][0] = "Where were the first ever Olympic Games hosted?";
        questionsSummerGames[2][1] = "Rio De Janiero, Brazil";
        questionsSummerGames[2][2] = "Rome, Italy";
        questionsSummerGames[2][3] = "Cluj Napoca, Romania";
        questionsSummerGames[2][4] = "Athens, Greece";
        questionsSummerGames[2][5] = "Liverpool, United Kingdom";

        questionsSummerGames[3][0] = "What is the largest city to have ever hosted the Summer Olympics?";
        questionsSummerGames[3][1] = "Paris, France";
        questionsSummerGames[3][2] = "Tokyo, Japan";
        questionsSummerGames[3][3] = "London, United Kingdom";
        questionsSummerGames[3][4] = "Seoul, South Korea";
        questionsSummerGames[3][5] = "Los Angeles, United States";

        questionsSummerGames[4][0] = "Which two of the following sports have always been a part of the summer Olympics?";
        questionsSummerGames[4][1] = "Swimming";
        questionsSummerGames[4][2] = "Shooting";
        questionsSummerGames[4][3] = "Fencing";
        questionsSummerGames[4][4] = "Wrestling";
        questionsSummerGames[4][5] = "Diving";

        // assign questions on Winter Olympics to array elements
        questionsWinterGames[0][0] = "Select the year in which the first Winter Olympic games were held?";
        questionsWinterGames[0][1] = "1902";
        questionsWinterGames[0][2] = "1918";
        questionsWinterGames[0][3] = "1924";
        questionsWinterGames[0][4] = "1920";
        questionsWinterGames[0][5] = "1908";

        questionsWinterGames[1][0] = "Which two years did Canada host the Winter Olympics?";
        questionsWinterGames[1][1] = "1988";
        questionsWinterGames[1][2] = "1968";
        questionsWinterGames[1][3] = "2010";
        questionsWinterGames[1][4] = "1942";
        questionsWinterGames[1][5] = "2006";

        questionsWinterGames[2][0] = "Where were the first modern Olympic Winter Games held?";
        questionsWinterGames[2][1] = "Stockholm, Sweden";
        questionsWinterGames[2][2] = "Moscow, Russia";
        questionsWinterGames[2][3] = "Salt Lake City, UT";
        questionsWinterGames[2][4] = "Chamonix, France";
        questionsWinterGames[2][5] = "Vancouver, Canada";

        questionsWinterGames[3][0] = "How far did Eddie 'The Eagle' Edwards jump in the large hill competition?";
        questionsWinterGames[3][1] = "91m";
        questionsWinterGames[3][2] = "71m";
        questionsWinterGames[3][3] = "84m";
        questionsWinterGames[3][4] = "62m";
        questionsWinterGames[3][5] = "53m";

        questionsWinterGames[4][0] = "Which two countries are in the top 3 for total medal wins?";
        questionsWinterGames[4][1] = "Norway";
        questionsWinterGames[4][2] = "Canada";
        questionsWinterGames[4][3] = "United States";
        questionsWinterGames[4][4] = "Germany";
        questionsWinterGames[4][5] = "Soviet Union";

    }

    public void savePlayerName(String playerName) {
        this.playerName = playerName;
        sp.edit().putString("player", this.playerName).commit();
        Log.v("player name", "Player " + playerName);
    }
    /**
     * method increments score when a question is answered correctly
     */
    public void incrementScore() {
        quizScore++;
        sp.edit().putInt("score", quizScore).commit();
        Log.v("UPDATED SCORE", "Score is: " + quizScore);
    }

    /**
     * method saves the correct answer details when a question is answered correctly
     */
    public void recordCorrectAnswers(int questionNumber) {
        sp.edit().putInt("number_of_correct_answers", quizScore).commit();
        correctAnswers.add(Integer.toString(questionNumber));
        sp.edit().putStringSet("correct_answers_set", correctAnswers);
    }

    /**
     * method saves the incorrect answer details when a question is answered correctly
     */
    public void recordIncorrectAnswers(int questionNumber) {
        incorrectAnswers.add(Integer.toString(questionNumber));
        sp.edit().putStringSet("incorrect_answers_set", incorrectAnswers);
    }

    /**
     * method clears score when quiz is restarted from results activity
     */
    public void clearScore() {
        quizScore = 0;
    }

    /**
     * method clears player name when quiz is restarted from results activity
     */
    public void clearPlayerName() { playerName = "";}

    /**
     * method clears all correct anwswers stored in Set when quiz is restarted from results activity
     */
    public void clearCorrectAnswersList () {
        correctAnswers = null;
        correctAnswers = new HashSet<String>();
        sp.edit().putStringSet("correct_answers_set", correctAnswers);
    }

    /**
     * method clears all incorrect anwswers stored in Set when quiz is restarted from results activity
     */
    public void clearIncorrectAnswersList () {
        incorrectAnswers = null;
        incorrectAnswers = new HashSet<String>();
        sp.edit().putStringSet("incorrect_answers_set", incorrectAnswers);
    }

}
