package com.example.midtermapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.midtermapp.Adopter.CustomAdapter;
import com.example.midtermapp.constants.Constants;
import com.example.midtermapp.database.AppDatabase;
import com.example.midtermapp.database.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<String> data = new ArrayList<>();
    //FeedReaderDbHelper dbHelper;
    TextView highscore_list;
    private AppDatabase mDb;
    Intent intent;
    int mPersonId;
    EditText name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        recyclerView = findViewById(R.id.recyclerView);
        //highscore_list = findViewById(R.id.highscore_list);
        customAdapter = new CustomAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(customAdapter);
        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();
        if (intent != null && intent.hasExtra(Constants.UPDATE_Person_Id)) {


            mPersonId = intent.getIntExtra(Constants.UPDATE_Person_Id, -1);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    Person person = mDb.personDao().loadPersonById(mPersonId);
                    populateUI(person);
                }
            });
        }

    }
    private void populateUI(Person person) {

        if (person == null) {
            return;
        }

        name.setText(person.getName());
        email.setText(person.getEmail());
    }
    @Override
    protected void onResume() {
        super.onResume();
        retrieveTasks();
    }
    private void retrieveTasks() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Person> persons = mDb.personDao().loadAllPersons();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        customAdapter.setTasks(persons);
                    }
                });
            }
        });
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



