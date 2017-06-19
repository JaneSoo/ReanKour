package com.example.janesoo.reankour.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.janesoo.reankour.DetatilActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.adapter.TutorAdapter;
import com.example.janesoo.reankour.model.User;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentTutor extends Fragment {
    Context context;
    ListView listView;
    TutorAdapter adapter;
    Button btndetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.all_fragment_layout,container,false);
        listView = (ListView) myview.findViewById(R.id.tutor_listview);

        ArrayList<User> arrayList = new ArrayList<>();

        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.pic));
        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.tutor1));
        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.pic));
        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.pic));
        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.pic));
        arrayList.add(new User("Kanitha","Phnom Penh","Android", "5 Years",R.drawable.pic));

        adapter = new TutorAdapter(getContext(),R.layout.all_fragment_layout,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return myview;
    }

}
