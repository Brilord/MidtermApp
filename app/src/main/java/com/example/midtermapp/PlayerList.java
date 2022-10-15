package com.example.midtermapp;

import java.util.ArrayList;

public class PlayerList {
    public String name;
    public String score;

    public PlayerList(String name, String score) {
        this.name = name;
        this.score = score;
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

    public static int lastContactId = 0;

    public static ArrayList<PlayerList> createPlayerList(int numContacts) {
        ArrayList<PlayerList> contacts = new ArrayList<PlayerList>();

        for(int i = 0; i <= numContacts; i++) {
            contacts.add(new PlayerList("preson "+ ++lastContactId, i<= num))
        }
    }
}
