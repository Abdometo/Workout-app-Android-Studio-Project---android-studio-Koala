package com.example.myapplication.Domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    // Class Parameters
    private String title;
    private String description;
    private String picPath;
    private int kcal;
    private String durationAll;
    private ArrayList<Lessions> lessions;

    // Constructor
    public Workout(String title, String description, String picPath, int kcal, String durationAll, ArrayList<Lessions> lessions) {
        this.title = title;
        this.description = description;
        this.picPath = picPath;
        this.kcal = kcal;
        this.durationAll = durationAll;
        this.lessions = lessions;
    }
    // Getters

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicPath() {
        return picPath;
    }

    public int getKcal() {
        return kcal;
    }

    public String getDurationAll() {
        return durationAll;
    }

    public ArrayList<Lessions> getLessions() {
        return lessions;
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setDurationAll(String durationAll) {
        this.durationAll = durationAll;
    }

    public void setLessions(ArrayList<Lessions> lessions) {
        this.lessions = lessions;
    }
}
