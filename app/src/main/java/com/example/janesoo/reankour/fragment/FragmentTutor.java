package com.example.janesoo.reankour.fragment;

import android.app.ProgressDialog;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentTutor extends Fragment {
    Context context;
    ListView listView;
    TutorAdapter adapter;
    Button btndetail;
    DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.all_fragment_layout,container,false);
        listView = (ListView) myview.findViewById(R.id.tutor_listview);
        btndetail = (Button) myview.findViewById(R.id.btndetail);

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        final ArrayList<User> arrayList = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot tutorSnapshot: dataSnapshot.getChildren()){
                    User user = tutorSnapshot.getValue(User.class);
                    arrayList.add(user);
                    adapter = new TutorAdapter(getContext(),R.layout.all_fragment_layout,arrayList);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return myview;
    }
}
