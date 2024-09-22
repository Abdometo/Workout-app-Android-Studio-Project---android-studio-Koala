package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activity.WorkoutActivity;
import com.example.myapplication.Domain.Workout;
import com.example.myapplication.databinding.ViewholderWorkoutBinding;

import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    // Class parameters
    private final ArrayList<Workout> list;
    private Context context;

    // Constructor
    public WorkoutAdapter(ArrayList<Workout> list) {
        this.list = list;
    }

    // WorkoutViewHolder
    public class WorkoutViewHolder extends RecyclerView.ViewHolder {

        ViewholderWorkoutBinding viewholderWorkoutBinding;
        public WorkoutViewHolder(ViewholderWorkoutBinding viewholderWorkoutBinding) {
            super(viewholderWorkoutBinding.getRoot());
            this.viewholderWorkoutBinding=viewholderWorkoutBinding;
        }
    }

    // Implement Methods

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderWorkoutBinding viewholderWorkoutBinding  = ViewholderWorkoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new WorkoutViewHolder(viewholderWorkoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        holder.viewholderWorkoutBinding.titleText.setText(list.get(position).getTitle());
        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",context.getPackageName());


        Glide
                .with(holder.itemView.getContext())
                .load(resId)
                .into(holder.viewholderWorkoutBinding.pic);

        holder.viewholderWorkoutBinding.exerciseText.setText(list.get(position).getLessions().size()+" Exercise");
        holder.viewholderWorkoutBinding.caloriesText.setText(list.get(position).getKcal()+" Kcal");
        holder.viewholderWorkoutBinding.durationText.setText(list.get(position).getDurationAll());


        holder.viewholderWorkoutBinding.getRoot().setOnClickListener(v -> {

            Intent intent  = new Intent(context, WorkoutActivity.class);
            intent.putExtra("object",list.get(position));
            context.startActivity(intent);


        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
