package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by Sor Phorn on 6/20/2017.
 */

public class Document implements Serializable {
    private String title;
    private String content;
    private String date;
    private String image;
    private String fullContent;

    public Document(String title, String content, String date, String image, String fullContent) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
        this.fullContent = fullContent;
    }

    public Document() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullContent() {
        return fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
