package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.myapplication.Adapter.WorkoutAdapter;
import com.example.myapplication.Domain.Lessions;
import com.example.myapplication.Domain.Workout;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Binding
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //...............................................................................................................//
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //...............................................................................................................//

        // Recycler View
        activityMainBinding.view1.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
        activityMainBinding.view1.setAdapter(new WorkoutAdapter(getData()));
    }

    // get Data Function
    private ArrayList<Workout> getData(){
        ArrayList<Workout> list = new ArrayList<>();

        list.add(new Workout("Running","Running is the action or movement of propelling yourself forward rapidly on foot","pic_1",200,"20 mins",getLessions1()));
        list.add(new Workout("Stretching","Running is the action or movement of propelling yourself forward rapidly on foot","pic_2",200,"20 mins",getLessions2()));
        list.add(new Workout("Yoga","Running is the action or movement of propelling yourself forward rapidly on foot","pic_3",200,"20 mins",getLessions3()));
        return list;
    }

    // gel lessions 1
    private ArrayList<Lessions> getLessions1(){
        ArrayList<Lessions> list = new ArrayList<>();
        list.add(new Lessions("Lesson1","04:44","Hppkdkd","pic_1_1"));
        list.add(new Lessions("Lesson2","04:44","Hppkdkd","pic_1_2"));
        list.add(new Lessions("Lesson3","04:44","Hppkdkd","pic_1_3"));

        return list;
    }

    // gel lessions 2
    private ArrayList<Lessions> getLessions2(){
        ArrayList<Lessions> list = new ArrayList<>();
        list.add(new Lessions("Lesson1","04:44","Hppkdkd","pic_3_1"));
        list.add(new Lessions("Lesson2","04:44","Hppkdkd","pic_3_2"));
        list.add(new Lessions("Lesson3","04:44","Hppkdkd","pic_3_3"));
        list.add(new Lessions("Lesson4","04:44","Hppkdkd","pic_3_4"));

        return list;
    }

    // gel lessions 3
    private ArrayList<Lessions> getLessions3(){
        ArrayList<Lessions> list = new ArrayList<>();
        list.add(new Lessions("Lesson1","04:44","Hppkdkd","pic_3_1"));
        list.add(new Lessions("Lesson2","04:44","Hppkdkd","pic_3_2"));
        list.add(new Lessions("Lesson3","04:44","Hppkdkd","pic_3_3"));
        list.add(new Lessions("Lesson4","04:44","Hppkdkd","pic_3_4"));

        return list;
    }
}