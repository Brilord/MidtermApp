package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

//import com.example.midtermapp.Adopter.CustomAdapter;
//import com.example.midtermapp.sqlDB.DBManager;


//import com.example.midtermapp.sqlDB.DatabaseHelper;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    //NotesAdapter adopter;
    RecyclerView recyclerView;
    //CustomAdapter customAdopter;
    //MyAdopter adopter;
    String[] data1;
    ArrayList highScoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        // data to populate the RecyclerView with
        highScoreList = new ArrayList<>();

        // set the RecyclerView
        //setUserInfo();
        highScoreList.add("john");
        highScoreList.add("hello");

        //setAdopter();
        MyAdopter adopter = new MyAdopter(data1);
        //adopter = new MyAdopter(data1);
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adopter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HighScoreActivity.this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setAdapter(adopter);

    }

    private void setAdopter() {
        //adopter = new MyAdopter(highScoreList);
        MyAdopter adopter = new MyAdopter(data1);
       //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adopter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HighScoreActivity.this, LinearLayoutManager.VERTICAL, false));
        //recyclerView.setAdapter(adopter);
    }
    private void setUserInfo() {
        highScoreList.add("john");
        highScoreList.add("hello");

    }
}