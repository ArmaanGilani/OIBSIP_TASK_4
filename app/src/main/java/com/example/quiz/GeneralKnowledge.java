package com.example.quiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class GeneralKnowledge extends AppCompatActivity {
    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;

    private int highscore;

    androidx.appcompat.widget.Toolbar toolbar;
    Button startquizbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knowledge);
        getWindow().setStatusBarColor(Color.BLACK);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        startquizbutton = findViewById(R.id.startquizbutton);
        textViewHighscore = findViewById(R.id.highscoretextview);
        loadHighscore();

        startquizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), GKQuiz.class),REQUEST_CODE_QUIZ);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_QUIZ){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(GKQuiz.EXTRA_SCORE, 0);
                if (score > highscore){
                    updateHighscore(score);
                }
            }
        }

    }

    @SuppressLint("SetTextI18n")
    private void loadHighscore(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = sharedPreferences.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("HighScore: " + highscore);
    }

    @SuppressLint("SetTextI18n")
    private void updateHighscore(int highscorenew){
        highscore = highscorenew;
        textViewHighscore.setText("Highscore: " + highscore);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }

}