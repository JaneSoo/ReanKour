package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.janesoo.reankour.adapter.VideoAdapter;
import com.example.janesoo.reankour.model.SubjectModel;
import com.example.janesoo.reankour.model.Video;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

       Intent intent = getIntent();
        final SubjectModel subjectModel = (SubjectModel) intent.getSerializableExtra("Subject");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_home);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //get video from firebase:

        DatabaseReference mDataRef = FirebaseDatabase.getInstance().getReference("Videos");
        final  ArrayList<Video> newVideo =new ArrayList<>();

        mDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newVideo.clear();
                for(DataSnapshot videoSnapshot : dataSnapshot.getChildren()){
                    Video video = videoSnapshot.getValue(Video.class);
                    if(video.getCategory().equals(subjectModel.getCategory()))
                    {
                        newVideo.add(video);

                    }
                    VideoAdapter adapter = new VideoAdapter(newVideo);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
