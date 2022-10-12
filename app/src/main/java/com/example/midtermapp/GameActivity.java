package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.midtermapp.database.AppDatabase;
import com.example.midtermapp.database.User;

import java.io.FileInputStream;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    ImageButton btnAdd, btnSubtract;
    EditText numberInput;
    TextView numberOfAttemptDisplay;
    Button btnSubmit;
    Random rand = new Random();
    int keyNumber = 0;
    String stringUserInputNumber = "";
    int userInputNumber = 0;
    int countUserAttempt = 0;
    String stringCountUserNumber = "";
    StringBuilder sb = new StringBuilder();
    boolean isRandomNumberCreated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        btnAdd = findViewById(R.id.addValue);
        btnSubtract = findViewById(R.id.subtractValue);
        numberInput = findViewById(R.id.numberInput);
        btnSubmit = findViewById(R.id.guessSubmitButton);
        numberOfAttemptDisplay = findViewById(R.id.numberOfAttemptDisplay);
        stringUserInputNumber = numberInput.getText().toString();
        //userInputNumber = Integer.parseInt(stringCountUserNumber);
        MediaPlayer mediaPlayer = MediaPlayer.create(GameActivity.this, R.raw.buzzer_alarm);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInputNumber++;
                stringUserInputNumber = String.valueOf(countUserAttempt);
                numberInput.setText(stringUserInputNumber);
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInputNumber--;
                stringUserInputNumber = String.valueOf(userInputNumber);
                numberInput.setText(stringUserInputNumber);

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRandomNumberCreated == false) {
                    keyNumber = rand.nextInt(100);
                    isRandomNumberCreated = true;
                }
                stringUserInputNumber = numberInput.getText().toString();
                userInputNumber = Integer.valueOf(stringUserInputNumber);
                if(userInputNumber == keyNumber) {
                    countUserAttempt++;
                    Intent sendToMainActivity = new Intent(GameActivity.this, MainActivity.class);
                    stringCountUserNumber = String.valueOf(countUserAttempt);
                    sendToMainActivity.putExtra("score", stringCountUserNumber);
                    // startActivity(sendToMainActivity);
                    finish();
                }
                if(userInputNumber < keyNumber) {
                    Toast.makeText(GameActivity.this, "The answer is higher!!", Toast.LENGTH_LONG).show();
                    countUserAttempt++;
                    //stringCountUserNumber = String.valueOf(countUserAttempt);
                    numberOfAttemptDisplay.setText(sb.append("Number of attempts: ").append(countUserAttempt));
                    mediaPlayer.start();
                }
                if(userInputNumber > keyNumber) {
                    Toast.makeText(GameActivity.this, "The answer is lower!!", Toast.LENGTH_LONG).show();
                    countUserAttempt++;
                    //stringCountUserNumber = String.valueOf(countUserAttempt);
                    numberOfAttemptDisplay.setText(sb.append("Number of attempts: ").append(countUserAttempt));
                    mediaPlayer.start();
                }
            }
        });
    }

//    private void savePlayerScore(String name, String score) {
//        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
//        User user = new User();
//        user.name = name;
//        user.score = score;
//        db.userDao().insertAll(user);
//
//
//
//    }
}