package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

//import com.example.midtermapp.Adopter.CustomAdapter;
//import com.example.midtermapp.sqlDB.DBManager;
import com.example.midtermapp.sqlDB.DBOpenHelper;
//import com.example.midtermapp.sqlDB.DatabaseHelper;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {
    //private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adopter;
    RecyclerView recyclerView;
    //CustomAdapter customAdopter;
    ArrayList<String> noteslist = new ArrayList<>();
    ArrayList<String> playerName = new ArrayList<>();
    ArrayList<String> playerScore = new ArrayList<>();
    ArrayList<Integer> id = new ArrayList<>();
    private DBOpenHelper tdb; // Import database's assets
    private SQLiteDatabase sdb; // Import database's assets

//    final String[] from = new String[] {
//            DatabaseHelper.ID, DatabaseHelper.NAME, DatabaseHelper.SCORE
//    };

//    final int[] to = new int[] {
//            R.id.id, R.id.name, R.id.score};

    public static String[] String_Array(ArrayList<String> arr)
    {
        String str[] = new String[arr.size()];
        for (int j = 0; j < arr.size(); j++)
            str[j] = arr.get(j);
        return str;
    } // Convert an array list to a string list for displaying the ListView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        tdb = new DBOpenHelper(this, "MIDTERM_APP.DB", null, 1);
        sdb = tdb.getWritableDatabase();
        recyclerView = findViewById(R.id.recyclerView);
//        dbManager = new DBManager(this);
//        dbManager.open();
//        Cursor cursor = dbManager.fetch();
//        listView = findViewById(R.id.);
//        recyclerView = findViewById(R.id.recyclerView);
//        adopter = new SimpleCursorAdapter(this, R.layout.score_board_view, cursor, 0)
//        adopter.notifyDataSetChanged();
//        recyclerView.setAdapter(adopter);

        // Convert the array list to a string list
//        String[] strlist = String_Array(noteslist);
//
//        // Display the list of notes (using ListView)
//        final ListView listofnotes = findViewById(R.id.recyclerView);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1, strlist);
//        listofnotes.setAdapter(adapter);

    }
}