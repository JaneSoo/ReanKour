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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.subject_item_layout,container,false);
        myGrid=(GridView)myView.findViewById(R.id.grid_home);
        final ArrayList<SubjectModel> newSubject=new ArrayList<>();

       newSubject.add(new SubjectModel("Physic",R.drawable.physic));
       newSubject.add(new SubjectModel("English",R.drawable.english));
       newSubject.add(new SubjectModel("Math",R.drawable.math));
       newSubject.add(new SubjectModel("Chemistry",R.drawable.chemistry));
       newSubject.add(new SubjectModel("Biology",R.drawable.biology));
       newSubject.add(new SubjectModel("Physic",R.drawable.physic));
       newSubject.add(new SubjectModel("English",R.drawable.english));
       newSubject.add(new SubjectModel("Math",R.drawable.math));
       newSubject.add(new SubjectModel("Chemistry",R.drawable.chemistry));
       newSubject.add(new SubjectModel("Biology",R.drawable.biology));
        adapter=new SubjectAdapter(newSubject,getContext());
        myGrid.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return myView;

    }
}
