package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.janesoo.reankour.fragment.BottomNavigationFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class AllBottomNavigationViewActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mDatabase.keepSynced(true);
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    Intent intent = new Intent(AllBottomNavigationViewActivity.this,LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        };

        getSupportFragmentManager().beginTransaction().add(R.id.main,new BottomNavigationFragment()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.myprofile){
            Intent intent = new Intent(getBaseContext(),DetatilActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.setting){
            Intent intent = new Intent(getBaseContext(),DetatilActivity.class);
            startActivity(intent);

        }
        if(item.getItemId() == R.id.logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout(){
        mAuth.signOut();
    }
}
