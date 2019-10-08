package com.example.dishy_app.models;

import java.io.Serializable;
import java.util.List;

public class Dishy implements Serializable {
    private String name;
    private String image;
    private String time;
    private int star;
    private String level;
    private List<StepMake> makes;
    private List<Material> materials;

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

    public Dishy(String name, String image, String time, int star, String level) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.star = star;
        this.level = level;
    }

    public Dishy(String name, String image, String time, int star, String level, List<StepMake> makes, List<Material> materials) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.star = star;
        this.level = level;
        this.makes = makes;
        this.materials = materials;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<StepMake> getMakes() {
        return makes;
    }

    public void setMakes(List<StepMake> makes) {
        this.makes = makes;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }
}
