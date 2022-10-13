package com.example.midtermapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

//import com.example.midtermapp.Adopter.CustomAdapter;
//import com.example.midtermapp.sqlDB.DBManager;
import com.example.midtermapp.Adopter.MyAdopter;
import com.example.midtermapp.Adopter.User;
import com.example.midtermapp.sqlDB.DBOpenHelper;
//import com.example.midtermapp.sqlDB.DatabaseHelper;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    MyAdopter adopter;
    RecyclerView recyclerView;
    //CustomAdapter customAdopter;

    ArrayList<User> highScoreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        // data to populate the RecyclerView with
        ArrayList<String> highScoreList = new ArrayList<>();

        // set the RecyclerView
        setUserInfo();
        setAdopter();

    }

    private void setAdopter() {
        MyAdopter adopter = new MyAdopter(highScoreList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adopter);
    }
    private void setUserInfo() {
        highScoreList.add(new User("john"));
        highScoreList.add(new User("hello"));

    }
}