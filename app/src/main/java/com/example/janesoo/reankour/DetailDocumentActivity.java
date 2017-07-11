package com.example.janesoo.reankour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.model.Document;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Sor Phorn on 6/19/2017.
 */

public class DetailDocumentActivity extends AppCompatActivity {
    TextView textTitle,textDate,textFullContent;
    private StorageReference storageReference;
    ImageView img;

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
        setContentView(R.layout.document_detail_layout);

        Intent intent = getIntent();
        Document document = (Document) intent.getSerializableExtra("Content");


            textTitle=(TextView)findViewById(R.id.con_title);
            textDate = (TextView) findViewById(R.id.con_date);
            textFullContent=(TextView)findViewById(R.id.con_content);
            img =(ImageView)findViewById(R.id.pic);

            textTitle.setText(document.getTitle());
            textDate.setText(document.getDate());
            textFullContent.setText(document.getFullContent());


            Glide.with(getBaseContext()).load(document.getImage()).into(img);


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
