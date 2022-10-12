package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.midtermapp.Adopter.CustomAdapter;
import com.example.midtermapp.sqlDB.DBManager;

public class HighScoreActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adopter;
    RecyclerView recyclerView;
    CustomAdapter customAdopter;

//    final String[] from = new String[] {
//            DatabaseHelper.ID, DatabaseHelper.NAME, DatabaseHelper.SCORE
//    };

//    final int[] to = new int[] {
//            R.id.id, R.id.name, R.id.score};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        //recyclerView = findViewById(R.id.recyclerView);
//        dbManager = new DBManager(this);
//        dbManager.open();
//        Cursor cursor = dbManager.fetch();
        //listView = findViewById(R.id.);
        recyclerView = findViewById(R.id.recyclerView);
        //adopter = new SimpleCursorAdapter(this, R.layout., cursor, from, to, 0)
        //customAdopter = new CustomAdapter(data)

    }
}