package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.model.SubjectModel;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class SubjectAdapter extends BaseAdapter {
    private ArrayList<SubjectModel> arrayList;
    private int layout;
    private Context context;

    public SubjectAdapter(ArrayList<SubjectModel> arrayList, int layout, Context context) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.context = context;
    }

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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView=inflater.inflate(R.layout.subject_layout,null);
        ImageView imageView=(ImageView)myView.findViewById(R.id.image_subject);
        TextView textTitle=(TextView)myView.findViewById(R.id.name_subject);

        imageView.setImageResource(arrayList.get(position).getImage());
        textTitle.setText(arrayList.get(position).getName());

       return myView;
    }
}
