package com.example.janesoo.reankour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.janesoo.reankour.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by JaneSoo on 07-Jul-17.
 */

public class EditStudentActivity extends AppCompatActivity {

    EditText name, school, education, email, tel, gender;
    TextView changepro;
    ImageView profile_image;
    private StorageReference storageReference;
    Button cancel, save;
    ProgressDialog progress;
    FirebaseAuth mAuth;
    public static final int Galary= 2;

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
        setContentView(R.layout.edit_profile_layout);

        progress = new ProgressDialog(this);

        name = (EditText) findViewById(R.id.edtName);
        school = (EditText) findViewById(R.id.edtSchool);
        education = (EditText) findViewById(R.id.edtEdu);
        email = (EditText) findViewById(R.id.edtEmail);
        tel = (EditText) findViewById(R.id.edtNum);
        gender = (EditText) findViewById(R.id.edtSex);
        profile_image= (ImageView) findViewById(R.id.profile_image);
        changepro = (TextView) findViewById(R.id.changePhoto);
        cancel = (Button) findViewById(R.id.btnCancel);
        save = (Button) findViewById(R.id.btnSave);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edit Profile");

        final Intent intent = getIntent();
        final User user = (User) intent.getSerializableExtra("user");

        mAuth = FirebaseAuth.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference().child("Profile").child(mAuth.getCurrentUser().getEmail());
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(profile_image);
            }
        });

        name.setText(user.getFullname());
        school.setText(user.getEducation());
        education.setText(user.getSkill());
        email.setText(mAuth.getCurrentUser().getEmail());
        tel.setText(user.getPhone());
        gender.setText(user.getSex());

        storageReference = FirebaseStorage.getInstance().getReference().child("Profile");
        mAuth = FirebaseAuth.getInstance();

        storageReference.child(mAuth.getCurrentUser().getEmail()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getBaseContext()).load(uri).into(profile_image);
            }
        });
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Galary);
            }
        });
        changepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Galary);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditStudentActivity.this, StudentProfileActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegister();
                Intent intent1 = new Intent(EditStudentActivity.this,StudentProfileActivity.class);
                intent1.putExtra("user",user);
                startActivity(intent1);
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
                    Uri downloadUri = taskSnapshot.getDownloadUrl();
                    Glide.with(EditStudentActivity.this).load(downloadUri).into(profile_image);
                    progress.dismiss();
                }
            });
        }
        else {
            progress.dismiss();
        }
    }
    private void startRegister(){

        final String mname = name.getText().toString();
        final String memail = email.getText().toString().trim();
        final String mschool = school.getText().toString();
        final String meducation = education.getText().toString();
        final String mtel = tel.getText().toString();
        final String mgender = gender.getText().toString();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
        databaseReference.child("fullname").setValue(mname);
        databaseReference.child("email").setValue(memail);
        databaseReference.child("education").setValue(mschool);
        databaseReference.child("skill").setValue(meducation);
        databaseReference.child("phone").setValue(mtel);
        databaseReference.child("sex").setValue(mgender);


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
