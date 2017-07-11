package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by user1 on 6/21/2017.
 */

public class SubjectModel implements Serializable{
    private String name;
    private String image;
    private String category;

    public SubjectModel() {
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SubjectModel(String name, String image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }
}
