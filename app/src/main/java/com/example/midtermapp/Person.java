package com.example.midtermapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;


    @Ignore
    public Person(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
