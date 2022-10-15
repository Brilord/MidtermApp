package com.example.midtermapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdopter extends RecyclerView.Adapter<MyAdopter.MyViewHolder> {
    private ArrayList<String> usersList;
    private String[] data1;
    public TextView textView;
    Context context;


    public MyAdopter(String data1[]) {
        this.data1 = data1;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView =
                inflater.inflate(R.layout.score_board_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdopter.MyViewHolder viewHolder, int position) {
        //String name = usersList.get(position).getUsername();
        viewHolder.textView.setText(data1[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }
}



//public class MyAdopter extends RecyclerView.Adapter<MyAdopter.ViewHolder> {
//
//    private String[] localDataSet;
//
//    /**
//     * Provide a reference to the type of views that you are using
//     * (custom ViewHolder).
//     */
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView textView;
//
//        public ViewHolder(View view) {
//            super(view);
//            // Define click listener for the ViewHolder's View
//
//            textView = (TextView) view.findViewById(R.id.highscore_list);
//        }
//
//        public TextView getTextView() {
//            return textView;
//        }
//    }
//
//    /**
//     * Initialize the dataset of the Adapter.
//     *
//     * @param dataSet String[] containing the data to populate views to be used
//     * by RecyclerView.
//     */
//    public MyAdopter(String[] dataSet) {
//        localDataSet = dataSet;
//    }
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        // Create a new view, which defines the UI of the list item
//        View view = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.score_board_view, viewGroup, false);
//
//        return new ViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
//
//        // Get element from your dataset at this position and replace the
//        // contents of the view with that element
//        viewHolder.getTextView().setText(localDataSet[position]);
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return localDataSet.length;
//    }
//}
