package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.myapplication.Adapter.LessionsAdapter;
import com.example.myapplication.Domain.Workout;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityWorkoutBinding;

public class WorkoutActivity extends AppCompatActivity {

    // Binding
    ActivityWorkoutBinding activityWorkoutBinding;

    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityWorkoutBinding = ActivityWorkoutBinding.inflate(getLayoutInflater());
        setContentView(activityWorkoutBinding.getRoot());

        //...............................................................................................................//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //...............................................................................................................//
        
        getObject();
        setVariable();
    }

    private void getObject() {
        workout = (Workout) getIntent().getSerializableExtra("object");
    }

    private void setVariable() {
        int resId = getResources().getIdentifier(workout.getPicPath(),"drawable",getPackageName());

        Glide
                .with(this)
                .load(resId)
                .into(activityWorkoutBinding.workoutPic);


        activityWorkoutBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        activityWorkoutBinding.titleText.setText(workout.getTitle());
        activityWorkoutBinding.exerciseText.setText(workout.getLessions().size()+" Exercise");
        activityWorkoutBinding.caloriesText.setText(workout.getKcal()+" Kcal");
        activityWorkoutBinding.durationText.setText(workout.getDurationAll());
        activityWorkoutBinding.descriptionText.setText(workout.getDescription());

        activityWorkoutBinding.view1.setLayoutManager(new LinearLayoutManager(WorkoutActivity.this,LinearLayoutManager.VERTICAL,false));

        activityWorkoutBinding.view1.setAdapter(new LessionsAdapter(workout.getLessions()));



    }
}