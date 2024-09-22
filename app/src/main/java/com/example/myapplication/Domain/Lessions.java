package com.example.myapplication.Domain;

import java.io.Serializable;

public class Lessions implements Serializable {
    // Class Parameters
    private String title;
    private String duration;
    private String link;
    private String picPath;
    //..........................................//

    // Constructor

    public Lessions(String title, String duration, String link, String picPath) {
        this.title = title;
        this.duration = duration;
        this.link = link;
        this.picPath = picPath;
    }

    // Getters

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getLink() {
        return link;
    }

    public String getPicPath() {
        return picPath;
    }
    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
