package com.example.janesoo.reankour;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.janesoo.reankour.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by JaneSoo on 10-Jul-17.
 */

public class
SettingActivity extends AppCompatActivity {

    LinearLayout help, account, notification, security, location, logout;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    StorageReference storageReference;
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
        setContentView(R.layout.setting_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Setting");

        help = (LinearLayout) findViewById(R.id.help);
        account = (LinearLayout) findViewById(R.id.account);
        notification = (LinearLayout) findViewById(R.id.notification);
        security = (LinearLayout) findViewById(R.id.security);
        location = (LinearLayout) findViewById(R.id.location);
        logout = (LinearLayout) findViewById(R.id.logout);

        storageReference = FirebaseStorage.getInstance().getReference().child("Profile");
        mAuth = FirebaseAuth.getInstance();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user.getAccountType().equals("Tutor")){
                    account.setVisibility(1);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            String publish;
            Switch switchaccount;
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(SettingActivity.this);
                dialog.setContentView(R.layout.account_dailog_layout);
                switchaccount = (Switch) dialog.findViewById(R.id.switch_account);
                Button saveaccount = (Button) dialog.findViewById(R.id.btnSubmit);
                Button cancel = (Button) dialog.findViewById(R.id.btnCancel);

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        publish = user.getIsPublish().toString();
                        if(publish.equals("false")){
                            switchaccount.setChecked(true);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                saveaccount.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                    if(switchaccount.isChecked()){
                        if(publish.equals("true")){
                            databaseReference.child("isPublish").setValue("false");
                            Toast.makeText(getApplicationContext(), "Your account have been disabled!", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                    }
                    if(publish.equals("false")){
                        databaseReference.child("isPublish").setValue("true");
                        Toast.makeText(getApplicationContext(), "Your account have been enabled!", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
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
