package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.janesoo.reankour.model.User;

/**
 * Created by JaneSoo on 14-Jun-17.
 */

public class DetatilActivity extends AppCompatActivity {

    TextView name, add, skill, education, position, email, number, topname, topskill, topadd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutor_detail_layout);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("Tutor");

        name = (TextView) findViewById(R.id.detailName);
        add = (TextView) findViewById(R.id.detailAdd);
        skill = (TextView) findViewById(R.id.detailSkill);
        education = (TextView) findViewById(R.id.detailEdu);
        position = (TextView) findViewById(R.id.detailPosition);
        email = (TextView) findViewById(R.id.detailEmail);
        number = (TextView) findViewById(R.id.detailNum);
        topname = (TextView) findViewById(R.id.topName);
        topskill = (TextView) findViewById(R.id.topSkill);
        topadd = (TextView) findViewById(R.id.topAdd);

        name.setText(user.getFullname().toString());
        add.setText(user.getAddress().toString());
        skill.setText(user.getSkill().toString());
        education.setText(user.getEducation().toString());
        position.setText(user.getPosition().toString());
        email.setText(user.getEmail().toString());
        number.setText(user.getPhone());
        topname.setText(user.getFullname().toString());
        topskill.setText(user.getSkill().toString());
        topadd.setText(user.getAddress().toString());

    }
}
