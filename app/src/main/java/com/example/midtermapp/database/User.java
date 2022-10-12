package com.example.midtermapp.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    // variable for id
    @PrimaryKey
    public int uid;

    // name for the player
    @ColumnInfo(name = "name")
    public String name;

    // the score for the player
    @ColumnInfo(name = "score")
    public String score;

    // below line we are creating constructor class
    // our id is incrementing automatically
    public User(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
