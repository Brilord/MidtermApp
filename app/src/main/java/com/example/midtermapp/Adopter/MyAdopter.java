package com.example.midtermapp.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermapp.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyAdopter extends RecyclerView.Adapter<MyAdopter.MyViewHolder> {
    private ArrayList<User> usersList;

    public MyAdopter(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.highscore_list);
        }
    }
    @NonNull
    @Override
    public MyAdopter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_high_score, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdopter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}


