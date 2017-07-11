package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by user1 on 6/21/2017.
 */

public class SubjectModel implements Serializable{
    private String name;
    private int image;
    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public SubjectModel(String name, int image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }
}
