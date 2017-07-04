package com.example.janesoo.reankour;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.janesoo.reankour.adapter.ContentVideoAdapter;
import com.example.janesoo.reankour.model.ContentVideoModel;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;
/*import static com.example.janesoo.reankour.videoActivity.VIDEO_ID;*/

/**
 * Created by Sor Phorn on 7/3/2017.
 */

public class VideoTestActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

//    String[] names = {"How to develop your self", "Scholarship to singapore", "How to choose university", "How to improve your self"};
//
//    String[] artises = {"Mike Posner", "Lukas Graham", "Zayn", "Fifth Harmony"};
//    String[] dates = {"13 June 2017 ", "18 May 2017", "03 April 2017", "23 October 2017", };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_test_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ContentVideoAdapter adapter = new ContentVideoAdapter(getAllContents(), this);


    }

    public ArrayList<ContentVideoModel> getAllContents()
    {
        ArrayList<ContentVideoModel> videos = new ArrayList<>();
        videos.add(new ContentVideoModel("azxDhcKYku4", "How to develop your self", "Mike Posner","13 June 2017 "));
        videos.add(new ContentVideoModel("srH-2pQdKhg", "How to develop your self", "Mike Posner","13 June 2017 "));
        videos.add(new ContentVideoModel("3LiubyYpEUk", "How to develop your self", "Mike Posner","13 June 2017 "));

        return  videos;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        /** add listeners to YouTubePlayer instance **/
        player.setPlayerStateChangeListener(playerStateChangeListener);
        player.setPlaybackEventListener(playbackEventListener);
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failured to Initialize!", Toast.LENGTH_LONG).show();
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Toast.makeText(getApplicationContext(),"Portrait",Toast.LENGTH_SHORT).show();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(),"Landscape",Toast.LENGTH_SHORT).show();
        }
    }
}

