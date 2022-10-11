package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnStartGame, btnShowHighScore;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        btnStartGame = findViewById(R.id.btnPlayGame);
        btnShowHighScore = findViewById(R.id.btnViewHighScore);
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startGameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivity(startGameActivity);
            }
        });
        btnShowHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startHighScoreActivity = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(startHighScoreActivity);
            }
        });
    }

    protected void onRestart() {
        super.onRestart();
    }
    protected void onPause() {
        super.onPause();
    }
    protected void onStop() {
        super.onStop();
    }
    protected void onDestroy() {
        super.onDestroy();
    }
    protected void onResume() {
        super.onResume();
    }

}