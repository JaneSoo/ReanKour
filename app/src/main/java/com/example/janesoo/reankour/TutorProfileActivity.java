package com.example.janesoo.reankour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import static com.example.janesoo.reankour.R.id.profile_image;

/**
 * Created by JaneSoo on 28-Jun-17.
 */

public class TutorProfileActivity extends AppCompatActivity {

    ImageView profile_image;
    private StorageReference storageReference;
    TextView nametop, name, address, skill, edu, position, email, phone, gender;
    Button edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_teacher_layout);

        Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");

        nametop = (TextView) findViewById(R.id.proTopName);
        name = (TextView) findViewById(R.id.proName);
        address = (TextView) findViewById(R.id.proAddr);
        skill = (TextView) findViewById(R.id.proSkill);
        edu = (TextView) findViewById(R.id.proEdu);
        position = (TextView) findViewById(R.id.proPosi);
        email = (TextView) findViewById(R.id.proEmail);
        phone = (TextView) findViewById(R.id.proNum);
        gender = (TextView) findViewById(R.id.proSex);

        profile_image = (ImageView) findViewById(R.id.profile_image);

        edit = (Button) findViewById(R.id.proEdit);


        storageReference = FirebaseStorage.getInstance().getReference().child("Profile").child(user.getEmail());
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(profile_image);
            }
        });

        nametop.setText(user.getFullname().toString());
        name.setText(user.getFullname().toString());
        address.setText(user.getAddress().toString());
        skill.setText(user.getSkill().toString());
        edu.setText(user.getEducation().toString());
        position.setText(user.getPosition().toString());
        email.setText(user.getEmail().toString());
        phone.setText(user.getPhone().toString());
        gender.setText(user.getSex().toString());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(TutorProfileActivity.this,EditTutorActivity.class);
                intent1.putExtra("user", user);
                startActivity(intent1);
            }
        });
    }
}




//        profie_image = (ImageView) findViewById(profile_image);
//        storageReference = FirebaseStorage.getInstance().getReference().child("Profile");
//        mAuth = FirebaseAuth.getInstance();
//
//        storageReference.child(mAuth.getCurrentUser().getEmail()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Glide.with(getBaseContext()).load(uri).into(profie_image);
//            }
//        });
//        profie_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, Galary);
//            }
//        });

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        progress.setMessage("Loading...");
//        progress.show();
//        if(requestCode == Galary && resultCode == RESULT_OK){
//            Uri uri = data.getData();
//            StorageReference storepath = storageReference.child(mAuth.getCurrentUser().getEmail());
//
//            storepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    progress.dismiss();
//                    Uri downloadUri = taskSnapshot.getDownloadUrl();
//                    Glide.with(TutorProfileActivity.this).load(downloadUri).into(profie_image);
//                }
//            });
//        }
//    }
