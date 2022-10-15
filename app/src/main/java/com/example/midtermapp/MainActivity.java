package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    Button btnStartGame, btnShowHighScore;
    TextView displayMainActivity;
    String playerScore= "";
    String playerName = "";
    String str1 = "Welcome to the Game";
    boolean didUserPlayGame = false;
    StringBuilder sb = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMainActivity = findViewById(R.id.displayMainActivity);
        btnStartGame = findViewById(R.id.btnPlayGame);
        btnShowHighScore = findViewById(R.id.btnViewHighScore);
        //displayMainActivity.setText("Welcome to the Game");
        Intent extras = getIntent();
        if (extras != null) {
            Log.d("debug", "successfully implemented Intent");
            playerScore = extras.getStringExtra("score");
            playerName = extras.getStringExtra("name");
            displayMainActivity.setText("");
            //displayMainActivity.setText(sb.append(playerName).append(" score: ").append(playerScore).append("Play Another Game? "));
            displayMainActivity.setText("" + playerName + " score: " + playerScore + "Play Another Game? ");
        }

        if (didUserPlayGame == false) {
            displayMainActivity.setText("Welcome to the Game");
        }
        if (didUserPlayGame) {

        }

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startGameActivity = new Intent(MainActivity.this, GameActivity.class);
                displayMainActivity.setText("");
                didUserPlayGame = true;

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

//    protected void onRestart() {
//        super.onRestart();
//    }
//    protected void onPause() {
//        super.onPause();
//    }
//    protected void onStop() {
//        super.onStop();
//    }
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//    protected void onResume() {
//        super.onResume();
//    }

    protected void onSavedInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("player_name",playerName);
        outState.putString("player_score", playerScore);
        outState.putBoolean("did_player_play", didUserPlayGame);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        playerName = savedInstanceState.getString("player_name", "");
        playerScore = savedInstanceState.getString("player_score", "");
        didUserPlayGame = savedInstanceState.getBoolean("did_player_play");


    }
}