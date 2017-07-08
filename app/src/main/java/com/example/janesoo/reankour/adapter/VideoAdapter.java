package com.example.janesoo.reankour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.model.Video;

import java.util.List;

/**
 * Created by Sor Phorn on 7/8/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<Video> list;

    public VideoAdapter(List<Video> list) {
        this.list = list;
    }

    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_layout,parent,false);
        return new VideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.VideoViewHolder holder, int position) {
        holder.webView.loadData(list.get(position).getVideoUrl(),"text/html","utf-8");
        holder.textTitle.setText(list.get(position).getTitle());
        holder.textDate.setText(list.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        public TextView textTitle;
        public  TextView textDate;

        public VideoViewHolder(View itemView) {
            super(itemView);

            webView = (WebView) itemView.findViewById(R.id.webVideoView);
            textTitle=(TextView)itemView.findViewById(R.id.title);
            textDate=(TextView)itemView.findViewById(R.id.date);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient(){

            });

        }
    }
}
