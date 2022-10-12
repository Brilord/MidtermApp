package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.midtermapp.sqlDB.DBManager;
import com.example.midtermapp.sqlDB.DatabaseHelper;

public class HighScoreActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adopter;

    final String[] from = new String[] {
            DatabaseHelper.ID, DatabaseHelper.NAME, DatabaseHelper.SCORE
    };

    final int[] to = new int[] {
            R.id.id, R.id.title, R.id.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
    }
}