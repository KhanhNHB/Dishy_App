package com.example.dishy_app.models;

import android.graphics.Bitmap;

import java.io.Serializable;

public class StepMake implements Serializable {
    private String descrip;
    private boolean prepairStage;
    private Bitmap imageOne;
    private Bitmap imageTwo;

    public StepMake(String descrip, boolean prepairStage, Bitmap imageOne, Bitmap imageTwo) {
        this.descrip = descrip;
        this.prepairStage = prepairStage;
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public boolean isPrepairStage() {
        return prepairStage;
    }

    public void setPrepairStage(boolean prepairStage) {
        this.prepairStage = prepairStage;
    }

    public Bitmap getImageOne() {
        return imageOne;
    }

    public void setImageOne(Bitmap imageOne) {
        this.imageOne = imageOne;
    }

    public Bitmap getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(Bitmap imageTwo) {
        this.imageTwo = imageTwo;
    }
}
