package com.example.janesoo.reankour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.adapter.TutorAdapter;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentTutor extends Fragment {
    ListView listView;
    TutorAdapter adapter;

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View myView = inflater.inflate(R.layout.tutors_fragment_layout,container,false);
//        listView = (ListView) myView.findViewById(R.id.tutor_listview);
//        return myView;
//    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.tutors_fragment_layout,container,false);
        return myview;
    }
}
