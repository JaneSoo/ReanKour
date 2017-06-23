package com.example.janesoo.reankour;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.janesoo.reankour.adapter.SubjectAdapter;
import com.example.janesoo.reankour.model.SubjectModel;

import java.util.ArrayList;

/**
 * Created by user1 on 6/21/2017.
 */

public class SubjectActivity extends AppCompatActivity {
    private ArrayList<SubjectModel> arrayList=new ArrayList<>();
    GridView myGrid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_item_layout);


        arrayList.add(new SubjectModel("khmer",R.drawable.calculator));
        arrayList.add(new SubjectModel("english",R.drawable.calculator));
        arrayList.add(new SubjectModel("canada",R.drawable.calculator));




        myGrid=(GridView)findViewById(R.id.grid_home);
        SubjectAdapter adapter=new SubjectAdapter(arrayList,R.layout.subject_layout,SubjectActivity.this);
        myGrid.setAdapter(adapter);



    }
}
