package com.example.janesoo.reankour.model;

/**
 * Created by Sor Phorn on 7/8/2017.
 */

public class Video {
    private String videoUrl;
    private String title;
    private String date;
    private String category;

    public Video() {
    }

    public Video(String videoUrl, String title, String date, String category) {
        this.videoUrl = videoUrl;
        this.title = title;
        this.date = date;
        this.category = category;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
