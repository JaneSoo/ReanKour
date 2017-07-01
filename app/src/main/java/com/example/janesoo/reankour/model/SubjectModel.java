package com.example.janesoo.reankour.model;

/**
 * Created by user1 on 6/21/2017.
 */

public class SubjectModel {
    String name;
    int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public SubjectModel(String name, int image) {
        this.name = name;
        this.image = image;

    }
}
