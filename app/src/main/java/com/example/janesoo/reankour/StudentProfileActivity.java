package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.janesoo.reankour.model.User;
import com.google.firebase.storage.StorageReference;

/**
 * Created by JaneSoo on 28-Jun-17.
 */

public class StudentProfileActivity extends AppCompatActivity {

    ImageView profile_image;
    private StorageReference storageReference;
    TextView nametop, name, edu, school, email, phone, gender;
    Button edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_student_layout);

        nametop = (TextView) findViewById(R.id.proTopName);
        name = (TextView) findViewById(R.id.proName);
        edu = (TextView) findViewById(R.id.proEdu);
        school = (TextView) findViewById(R.id.proSchool);
        email = (TextView) findViewById(R.id.proEmail);
        phone = (TextView) findViewById(R.id.proPhone);
        gender= (TextView) findViewById(R.id.proSex);
        edit = (Button) findViewById(R.id.proEdit);
        profile_image = (ImageView) findViewById(R.id.profile_image);

        final Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");

        nametop.setText(user.getFullname());
        name.setText(user.getFullname());
        edu.setText(user.getSkill());
        school.setText(user.getEducation());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        gender.setText(user.getSex());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(),EditStudentActivity.class);
                //intent1.putExtra("user", user);
                startActivity(intent1);
            }
        });

    }
}


