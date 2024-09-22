package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.myapplication.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    // Binding
    ActivityIntroBinding activityIntroBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIntroBinding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(activityIntroBinding.getRoot());

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // start Button
        activityIntroBinding.startButton.setOnClickListener(v -> {
            Intent intent = new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);
        });
        //.........................................................................................//
    }
}