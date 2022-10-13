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
    private ArrayList<String> usersList;
    public TextView textView;

    public MyAdopter(ArrayList<String> usersList) {
        this.usersList = usersList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;


        public MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.highscore_list);
        }
    }

    public TextView getTextView() {
        return textView;
    }

    @NonNull
    @Override
    public MyAdopter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.score_board_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdopter.MyViewHolder viewHolder, int position) {
        //String name = usersList.get(position).getUsername();
        viewHolder.textView.setText(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}


