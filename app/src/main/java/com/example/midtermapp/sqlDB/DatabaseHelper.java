package com.example.midtermapp.sqlDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //table name
    public static final String TABLE_NAME = "PLAYER_LIST";

    // table column
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String SCORE = "score";

    // database information
    static final String DB_NAME = "MIDTERM_APP.DB";

    // database version
    static final int DB_VERSION = 1;

    // create table query
    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " TEXT NOT NULL, " + SCORE + " TEXT);";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        // execute the query
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
