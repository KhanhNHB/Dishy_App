package com.example.dishy_app.models;

import java.io.Serializable;

public class Dishy implements Serializable {
    private String name;
    private String image;
    private String time;
    private int star;

    public Dishy(String name, String image, String time) {
        this.name = name;
        this.image = image;
        this.time = time;
    }

    public Dishy(String name, String image, String time, int liker) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.star = liker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int liker) {
        this.star = liker;
    }
}
