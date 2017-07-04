package com.example.janesoo.reankour.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.SubjectActivity;
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



    public SubjectAdapter(ArrayList<SubjectModel> newSubject, Context context) {
        this.arrayList=newSubject;
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
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myView=inflater.inflate(R.layout.subject_layout,null);


        ImageView imageView=(ImageView)myView.findViewById(R.id.image_subject);
        TextView textTitle=(TextView)myView.findViewById(R.id.name_subject);

        SubjectModel model = arrayList.get(position);

        imageView.setImageResource(model.getImage());
        textTitle.setText(model.getName());

        return myView;
    }
}
