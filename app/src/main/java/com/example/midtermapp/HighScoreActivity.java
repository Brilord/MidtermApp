package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

//import com.example.midtermapp.Adopter.CustomAdapter;
//import com.example.midtermapp.sqlDB.DBManager;
import com.example.midtermapp.Adopter.MyAdopter;

//import com.example.midtermapp.sqlDB.DatabaseHelper;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    MyAdopter adopter;
    RecyclerView recyclerView;
    //CustomAdapter customAdopter;

    ArrayList<String> highScoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        // data to populate the RecyclerView with
        highScoreList = new ArrayList<>();

        // set the RecyclerView
        setUserInfo();
        setAdopter();

    }

    private void setAdopter() {
        adopter = new MyAdopter(highScoreList);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(HighScoreActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adopter);
    }
    private void setUserInfo() {
        highScoreList.add("john");
        highScoreList.add("hello");

    }
}