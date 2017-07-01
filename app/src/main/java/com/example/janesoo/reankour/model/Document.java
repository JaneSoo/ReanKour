package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by Sor Phorn on 6/20/2017.
 */

public class Document implements Serializable {
    int doc_img;
    String doc_title;
    String doc_content;
    String date;


    public int getDoc_img() {
        return doc_img;
    }

    public void setDoc_img(int doc_img) {
        this.doc_img = doc_img;
    }

    public String getDoc_title() {
        return doc_title;
    }

    public void setDoc_title(String doc_title) {
        this.doc_title = doc_title;
    }

    public String getDoc_content() {
        return doc_content;
    }

    public void setDoc_content(String doc_content) {
        this.doc_content = doc_content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Document(int doc_img, String doc_title, String doc_content, String date) {
        this.doc_img = doc_img;
        this.doc_title = doc_title;
        this.doc_content = doc_content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Document{" +
                "doc_img=" + doc_img +
                ", doc_title='" + doc_title + '\'' +
                ", doc_content='" + doc_content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
