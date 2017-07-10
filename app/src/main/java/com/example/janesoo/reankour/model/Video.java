package com.example.janesoo.reankour.model;

/**
 * Created by Sor Phorn on 7/8/2017.
 */

public class Video {
    private String videoUrl;
    private String title;
    private String date;

    public Video(String videoUrl, String title, String date) {
        this.videoUrl = videoUrl;
        this.title = title;
        this.date = date;
    }

    public String getVideoUrl() {
        return videoUrl;
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
