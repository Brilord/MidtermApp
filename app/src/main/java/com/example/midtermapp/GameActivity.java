package com.example.midtermapp;

//import static com.example.midtermapp.FeedReaderContract.FeedEntry.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.midtermapp.database.AppDatabase;
//import com.example.midtermapp.database.User;

import com.example.midtermapp.constants.Constants;
import com.example.midtermapp.database.AppDatabase;
import com.example.midtermapp.database.AppExecutors;

import java.io.FileInputStream;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    ImageButton btnAdd, btnSubtract;
    EditText numberInput;
    EditText playerNameInput;
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
    String stringPlayerNameInput = "";
    int mPersonId;
    private AppDatabase mDb;
    Intent intent;

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
        playerNameInput = findViewById(R.id.playerNameInput);
        MediaPlayer mediaPlayer = MediaPlayer.create(GameActivity.this, R.raw.buzzer_alarm);
        numberOfAttemptDisplay.setText("Number of attempts: 0");
        mDb = AppDatabase.getInstance(getApplicationContext());









        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringUserInputNumber = numberInput.getText().toString();
                userInputNumber = Integer.parseInt(stringUserInputNumber);
                userInputNumber++;
                stringUserInputNumber = String.valueOf(userInputNumber);
                numberInput.setText(stringUserInputNumber);
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringUserInputNumber = numberInput.getText().toString();
                userInputNumber = Integer.parseInt(stringUserInputNumber);
                userInputNumber--;
                stringUserInputNumber = String.valueOf(userInputNumber);
                numberInput.setText(stringUserInputNumber);

            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRandomNumberCreated == false) {
                    //keyNumber = rand.nextInt(100);
                    keyNumber = 22;
                    isRandomNumberCreated = true;
                }
                stringUserInputNumber = numberInput.getText().toString();
                userInputNumber = Integer.parseInt(stringUserInputNumber);
                if (userInputNumber == keyNumber) {
                    countUserAttempt++;
                    Intent sendToMainActivity = new Intent(GameActivity.this, MainActivity.class);
                    stringCountUserNumber = String.valueOf(countUserAttempt);
                    stringPlayerNameInput = playerNameInput.getText().toString();
                    stringUserInputNumber = numberInput.getText().toString();
                    sendToMainActivity.putExtra("score", stringCountUserNumber);
                    sendToMainActivity.putExtra("name", stringPlayerNameInput);
                    final Person person = new Person(stringPlayerNameInput,
                            stringCountUserNumber);
                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                                mDb.personDao().insertPerson(person);
                            finish();
                            //startActivity(sendToMainActivity);
                        }
                    });

                    //startActivity(sendToMainActivity);

                }
                if (userInputNumber < keyNumber) {
                    Toast.makeText(GameActivity.this, "The answer is higher!!", Toast.LENGTH_LONG).show();
                    countUserAttempt++;
                    //stringCountUserNumber = String.valueOf(countUserAttempt);
                    numberOfAttemptDisplay.setText("");
                    //numberOfAttemptDisplay.setText(sb.append("Number of attempts: ").append(countUserAttempt));
                    numberOfAttemptDisplay.setText("Number of attempts: " + countUserAttempt);
                    mediaPlayer.start();
                }
                if (userInputNumber > keyNumber) {
                    Toast.makeText(GameActivity.this, "The answer is lower!!", Toast.LENGTH_LONG).show();
                    countUserAttempt++;
                    //stringCountUserNumber = String.valueOf(countUserAttempt);
                    numberOfAttemptDisplay.setText("");
                    //numberOfAttemptDisplay.setText(sb.append("Number of attempts: ").append(countUserAttempt));
                    numberOfAttemptDisplay.setText("Number of attempts: " + countUserAttempt);
                    mediaPlayer.start();
                }
            }
        });
    }


}