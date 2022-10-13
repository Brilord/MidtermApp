package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnStartGame, btnShowHighScore;
    TextView displayMainActivity;
    String playerScore= "";
    String playerName = "";
    String str1 = "Welcome to the Game";
    boolean didUserPlayGame = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMainActivity = findViewById(R.id.displayMainActivity);
        btnStartGame = findViewById(R.id.btnPlayGame);
        btnShowHighScore = findViewById(R.id.btnViewHighScore);
        //displayMainActivity.setText("Welcome to the Game");
        if(playerName.equals("") && playerScore.equals("")) {
            displayMainActivity.setText("Welcome to the Game");
        } else {
            displayMainActivity.setText("");
            displayMainActivity.setText("" + playerName + " score: " + playerScore + "Play Another Game? ");
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

        Intent extras = getIntent();
        if (extras != null) {
            Log.d("debug", "sucessfully implemented Intent");
            playerScore = extras.getStringExtra("score");
            playerName  = extras.getStringExtra("name");

//            if(didUserPlayGame = true) {
//                displayMainActivity.setText("");
//                displayMainActivity.setText("" + playerName + " score: " + playerScore + "Play Another Game? ");
//            }
            //The key argument here must match that used in the other activity
        }


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

}