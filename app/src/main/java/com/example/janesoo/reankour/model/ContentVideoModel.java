package com.example.janesoo.reankour.model;

/**
 * Created by Sor Phorn on 7/3/2017.
 */

public class ContentVideoModel {

    private String video_id,name,artise,date;

    public ContentVideoModel(String video_id, String name, String artise, String date) {
        this.video_id = video_id;
        this.name = name;
        this.artise = artise;
        this.date = date;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtise() {
        return artise;
    }

    public void setArtise(String artise) {
        this.artise = artise;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
