package com.example.janesoo.reankour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.SubjectActivity;
import com.example.janesoo.reankour.adapter.SubjectAdapter;
import com.example.janesoo.reankour.adapter.TutorAdapter;
import com.example.janesoo.reankour.model.SubjectModel;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentSubject extends Fragment{
    GridView myGrid;
    SubjectAdapter adapter;
    SubjectActivity subjectActivity;

    public void setSubjectActivity(SubjectActivity subjectActivity) {
        this.subjectActivity = subjectActivity;
    }

    private ArrayList<SubjectModel> arrayList=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.subject_item_layout,container,false);
        myGrid=(GridView)myView.findViewById(R.id.grid_home);

        ArrayList<SubjectModel> newSubject=new ArrayList<>();

        newSubject.add(new SubjectModel("khmer",R.drawable.calculator));
        newSubject.add(new SubjectModel("english",R.drawable.calculator));
        newSubject.add(new SubjectModel("canada",R.drawable.calculator));
        newSubject.add(new SubjectModel("khmer",R.drawable.calculator));
        newSubject.add(new SubjectModel("english",R.drawable.calculator));
        newSubject.add(new SubjectModel("canada",R.drawable.calculator));
        newSubject.add(new SubjectModel("khmer",R.drawable.calculator));
        newSubject.add(new SubjectModel("english",R.drawable.calculator));
        newSubject.add(new SubjectModel("canada",R.drawable.calculator));


        adapter=new SubjectAdapter(newSubject,getContext());
        myGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return myView;

    }
}
