package com.example.janesoo.reankour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.janesoo.reankour.DocumentActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.adapter.DocumentAdapter;
import com.example.janesoo.reankour.model.Document;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentContent extends Fragment {
    ListView listView;
    DocumentAdapter documentAdapter;
    DocumentActivity documentActivity;

    public void setDocumentActivity(DocumentActivity documentActivity){
        this.documentActivity= documentActivity;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.content_document,container,false);
        listView= (ListView)myView.findViewById(R.id.list_document);
        Button buttonReadMore=(Button)myView.findViewById(R.id.btn_readMore);




        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference("Contents");
        final  ArrayList<Document> newDocument =new ArrayList<>();

        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newDocument.clear();
                for(DataSnapshot contentSnapshot : dataSnapshot.getChildren()){
                     Document document = contentSnapshot.getValue(Document.class);
                     newDocument.add(document);
                }
                documentAdapter = new DocumentAdapter(newDocument,getContext());
                listView.setAdapter(documentAdapter);
                documentAdapter.notifyDataSetChanged();

            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return myView;
    }
}
