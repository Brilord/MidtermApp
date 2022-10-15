package com.example.midtermapp.Adopter;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermapp.Person;
import com.example.midtermapp.R;
import com.example.midtermapp.database.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    static Context context;
    //private ArrayList<String> localDataSet;
    private List<Person> mPersonList;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView player_name, player_score;
        AppDatabase mDb;


        ViewHolder(@NonNull final View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            mDb = AppDatabase.getInstance(context);
            player_name = (TextView) view.findViewById(R.id.player_name);
            player_score = (TextView) view.findViewById(R.id.player_score);
        }


    }

    public void setTasks(List<Person> personList) {
        mPersonList = personList;
        notifyDataSetChanged();
    }
    public List<Person> getTasks() {

        return mPersonList;
    }

    public CustomAdapter(Context context) {
        this.context = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.score_board_card, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int position) {

        //viewHolder.textView.setText(localDataSet.get(position));
        viewHolder.player_name.setText(mPersonList.get(position).getName());
        viewHolder.player_score.setText(mPersonList.get(position).getEmail());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (mPersonList == null) {
            return 0;
        }
        return mPersonList.size();
    }
}

