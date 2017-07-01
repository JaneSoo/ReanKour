package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by Sor Phorn on 6/19/2017.
 */

public class Video implements Serializable {
    int video;
    String video_title;

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public Video(int video, String video_title) {
        this.video = video;
        this.video_title = video_title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "video=" + video +
                ", video_title='" + video_title + '\'' +
                '}';
    }
}
