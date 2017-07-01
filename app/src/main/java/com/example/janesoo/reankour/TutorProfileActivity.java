package com.example.janesoo.reankour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by JaneSoo on 28-Jun-17.
 */

public class TutorProfileActivity extends AppCompatActivity {

    TextView profile;
    ImageView profie_image;
    private StorageReference storageReference;
    private static final int Galary = 2;
    FirebaseAuth mAuth;
    ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_layout);
        progress = new ProgressDialog(this);

        profile = (TextView) findViewById(R.id.changePhoto);
        profie_image = (ImageView) findViewById(R.id.profile_image);
        storageReference = FirebaseStorage.getInstance().getReference().child("Profile");
        mAuth = FirebaseAuth.getInstance();

        storageReference.child(mAuth.getCurrentUser().getEmail()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getBaseContext()).load(uri).into(profie_image);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Galary);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        progress.setMessage("Loading...");
        progress.show();
        if(requestCode == Galary && resultCode == RESULT_OK){
            Uri uri = data.getData();
            StorageReference storepath = storageReference.child(mAuth.getCurrentUser().getEmail());

            storepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progress.dismiss();
                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    Glide.with(TutorProfileActivity.this).load(downloadUri).into(profie_image);
                }
            });
        }
    }
}
