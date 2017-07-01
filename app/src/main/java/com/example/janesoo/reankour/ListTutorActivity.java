package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by JaneSoo on 14-Jun-17.
 */

public class ListTutorActivity extends AppCompatActivity {

    Button detail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutors_item_layout);

        detail = (Button) findViewById(R.id.btndetail);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTutorActivity.this,DetatilActivity.class);
                startActivity(intent);
            }
        });
    }
}
