package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.janesoo.reankour.adapter.SubjectAdapter;
import com.example.janesoo.reankour.model.SubjectModel;

import java.util.ArrayList;

/**
 * Created by user1 on 6/21/2017.
 */

public class SubjectActivity extends AppCompatActivity {
    ImageView imageSubject;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_item_layout);

        imageSubject=(ImageView)findViewById(R.id.image_subject);

        /*imageSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubjectActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });*/









    }
}
