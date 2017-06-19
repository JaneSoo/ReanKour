package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janesoo.reankour.DetatilActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.model.User;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class TutorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> listofTutor;
    private int layout;

    public TutorAdapter(Context context, int layout, ArrayList<User> listofTutor){
        this.context = context;
        this.layout=layout;
        this.listofTutor =listofTutor;
    }

    @Override
    public int getCount() {
        return listofTutor.size();
    }

    @Override
    public Object getItem(int position) {
        return listofTutor.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.tutors_item_layout,null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView tutorName = (TextView) view.findViewById(R.id.tutorName);
        TextView tutorSkill = (TextView) view.findViewById(R.id.tutorSkill);
        TextView tutorExperience = (TextView) view.findViewById(R.id.tutorExperience);
        TextView tutorLocation = (TextView) view.findViewById(R.id.tutorLocation);
        Button btnCall = (Button) view.findViewById(R.id.btnCall);
        Button btnDetail = (Button) view.findViewById(R.id.btndetail);

        User model = listofTutor.get(position);


        imageView.setImageResource(model.getPicture());
        tutorName.setText(model.getName());
        tutorSkill.setText(model.getSkill());
        tutorExperience.setText(model.getExperience());
        tutorLocation.setText(model.getAddress());

        return view;
    }
}
