package com.example.midtermapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.midtermapp.Adopter.CustomAdapter;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<String> data = new ArrayList<>();
    //FeedReaderDbHelper dbHelper;
    TextView highscore_list;
    //int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_high_score);
        recyclerView = findViewById(R.id.recyclerView);
        //highscore_list = findViewById(R.id.highscore_list);
        for(int i = 0; i < 5; i++ ) {
            data.add("people " + i);
        }
        customAdapter = new CustomAdapter(data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(customAdapter);

    }
}



//    SharedPreferences sharedPreferences = getSharedPreferences("My Shared Pref", MODE_PRIVATE);
//        x = sharedPreferences.getInt("KEYFORX", 0);
//
//
//                dbHelper = new FeedReaderDbHelper(this);
//
//
//                SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//                Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//
//                while(cursor.moveToNext()) {
//                String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_TITLE));
//                String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME_SUBTITLE));
//
//                Log.d("DATAINSIDE", title + "," + description);
//                }



