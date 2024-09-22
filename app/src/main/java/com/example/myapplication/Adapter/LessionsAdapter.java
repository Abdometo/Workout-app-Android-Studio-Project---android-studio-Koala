package com.example.myapplication.Adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Domain.Lessions;
import com.example.myapplication.databinding.ViewholderExercisesBinding;

import java.util.ArrayList;

public class LessionsAdapter extends RecyclerView.Adapter<LessionsAdapter.LessionsViewHolder> {

    // Class Parameters
    private final ArrayList<Lessions> list;
    private Context context;

    // Constructor
    public LessionsAdapter(ArrayList<Lessions> list) {
        this.list = list;
    }

    // View Holder
    public class LessionsViewHolder extends RecyclerView.ViewHolder{
        // Binding
        ViewholderExercisesBinding viewholderExercisesBinding;

        public LessionsViewHolder(ViewholderExercisesBinding viewholderExercisesBinding) {
            super(viewholderExercisesBinding.getRoot());

            this.viewholderExercisesBinding=viewholderExercisesBinding;
        }
    }

    // Implement Methods

    @NonNull
    @Override
    public LessionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderExercisesBinding viewholderExercisesBinding = ViewholderExercisesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LessionsViewHolder(viewholderExercisesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LessionsViewHolder holder, int position) {
        holder.viewholderExercisesBinding.titleText.setText(list.get(position).getTitle());
        holder.viewholderExercisesBinding.durationText.setText(list.get(position).getDuration());


        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",context.getPackageName());

        Glide
                .with(context)
                .load(resId)
                .into(holder.viewholderExercisesBinding.pic);

        holder.viewholderExercisesBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+list.get(position).getLink()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v="+list.get(position).getLink()));

                try{
                    context.startActivity(appIntent);

                }catch (ActivityNotFoundException exception){
                    context.startActivity(webIntent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
