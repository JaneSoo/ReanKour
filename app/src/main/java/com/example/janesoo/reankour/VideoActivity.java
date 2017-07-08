package com.example.janesoo.reankour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.janesoo.reankour.adapter.VideoAdapter;
import com.example.janesoo.reankour.model.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sor Phorn on 7/8/2017.
 */

public class VideoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Video> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //loading data
        list = new ArrayList<>();
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HO8UvN2DV4A\" frameborder=\"0\" allowfullscreen></iframe>","How to good at English speaking","12July17"));
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/21ioywVyjrY\" frameborder=\"0\" allowfullscreen></iframe>","How to good at Math","10July17"));
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M8xCj2VPHas\" frameborder=\"0\" allowfullscreen></iframe>","How to solve physic problem","10May17"));
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3zd-rCr8RgE\" frameborder=\"0\" allowfullscreen></iframe>","Chemistry Physics","1April17"));
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CX84l5ZZHVg\" frameborder=\"0\" allowfullscreen></iframe>","Batteries and How They Work ","9March17"));
        list.add(new Video("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cuCSELaQ_Go\" frameborder=\"0\" allowfullscreen></iframe>","Aseptic techniques in the biology lab","10January17"));

        VideoAdapter adapter = new VideoAdapter(list);
        recyclerView.setAdapter(adapter);

    }
}
