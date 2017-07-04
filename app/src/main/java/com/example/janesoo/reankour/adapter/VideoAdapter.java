package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.janesoo.reankour.model.Video;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class VideoAdapter extends BaseAdapter {
    private ArrayList<Video> arrayList;
    private int layout;
    private Context context;
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return null;
    }
}
