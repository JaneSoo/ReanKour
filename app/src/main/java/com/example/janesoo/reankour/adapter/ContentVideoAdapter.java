package com.example.janesoo.reankour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.VideoTestActivity;
import com.example.janesoo.reankour.model.ContentVideoModel;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

/**
 * Created by Sor Phorn on 7/3/2017.
 */


public class ContentVideoAdapter extends RecyclerView.Adapter<ContentVideoAdapter.ViewHolder>  {
    ArrayList<ContentVideoModel> videos = new ArrayList<>();
    VideoTestActivity activity;
    public static String API_KEY = "AIzaSyBVqCY2fJzXZfcFqArt7MxAg3Rz7TpNhPU";


    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView tvName,tvArtise,tvDate;
        public YouTubePlayerView youTubePlayerView;


        public ViewHolder(View v) {
            super(v);
            tvName = (TextView)v.findViewById(R.id.tv_name);
            tvArtise = (TextView) v.findViewById(R.id.tv_artist);
            tvDate = (TextView) v.findViewById(R.id.tv_date);
            youTubePlayerView = (YouTubePlayerView) v.findViewById(R.id.youtube);

        }
    }

    //Provide a suitable constructor
    public ContentVideoAdapter(ArrayList<ContentVideoModel> videos, VideoTestActivity activity){
        this.videos = videos;
        this.activity = activity;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public ContentVideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item,parent,false);
        //set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(ContentVideoAdapter.ViewHolder holder, int position) {
        holder.youTubePlayerView.initialize(API_KEY, activity);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
