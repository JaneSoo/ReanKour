package com.example.janesoo.reankour;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.example.janesoo.reankour.R.id.imageView;
import static com.example.janesoo.reankour.R.id.profile_image;
import static com.example.janesoo.reankour.R.layout.activity;

/**
 * Created by JaneSoo on 14-Jun-17.
 */

public class DetatilActivity extends AppCompatActivity {

    private StorageReference storageReference;
    Context context;
    ProgressDialog progress;
    ImageView profile_image;

    TextView name, add, skill, education, position, email, number, topname, topskill, topadd, rate;

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        setContentView(R.layout.tutor_detail_layout);

        progress = new ProgressDialog(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail Info");

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
        rate = (TextView) findViewById(R.id.ratenow);

        profile_image = (ImageView) findViewById(R.id.profile_image);

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



        storageReference = FirebaseStorage.getInstance().getReference().child("Profile").child(user.getEmail());
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(profile_image);
            }
        });


        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(DetatilActivity.this);
                dialog.setContentView(R.layout.rate_dialog_layout);


                RatingBar ratestar = (RatingBar) dialog.findViewById(R.id.ratestar);
                Button saverate = (Button) dialog.findViewById(R.id.ratesubmit);
                Button cancelrate = (Button) dialog.findViewById(R.id.ratecancel);

                cancelrate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

