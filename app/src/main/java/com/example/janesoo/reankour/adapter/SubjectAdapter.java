package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.SubjectActivity;
import com.example.janesoo.reankour.VideoActivity;
import com.example.janesoo.reankour.model.SubjectModel;
import com.example.janesoo.reankour.model.User;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class SubjectAdapter extends BaseAdapter {

    SubjectActivity subjectActivity;
    private int layout;
    private Context context;
    private ArrayList<SubjectModel> arrayList=new ArrayList<>();



    public SubjectAdapter(ArrayList<SubjectModel> arrayList, Context context) {
        this.arrayList=arrayList;
        this.context=context;

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
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView=inflater.inflate(R.layout.subject_layout,null);


        ImageView imageViewSubj=(ImageView)myView.findViewById(R.id.image_subject);
        TextView textTitle=(TextView)myView.findViewById(R.id.name_subject);



        imageViewSubj.setImageResource(arrayList.get(position).getImage());
        textTitle.setText(arrayList.get(position).getName());

       /* imageViewSubj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,VideoActivity.class);
                intent.putExtra("Subject",arrayList.get(position));
                context.startActivity(intent);
            }
        });*/


        return myView;
    }

}
