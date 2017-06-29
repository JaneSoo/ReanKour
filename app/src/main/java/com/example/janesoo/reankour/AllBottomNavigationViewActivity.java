package com.example.janesoo.reankour;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.janesoo.reankour.adapter.TutorAdapter;
import com.example.janesoo.reankour.fragment.BottomNavigationFragment;
import com.example.janesoo.reankour.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class AllBottomNavigationViewActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    Intent intent = new Intent(getBaseContext(),LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        };
        getSupportFragmentManager().beginTransaction().replace(R.id.main,new BottomNavigationFragment()).commit();
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
            DatabaseReference mRef = databaseReference.child(mAuth.getCurrentUser().getUid());
            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        if (user.getAccountType().equals("Tutor"))
                        {
                            Intent intent = new Intent(getBaseContext(),TutorProfileActivity.class);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(getBaseContext(),StudentProfileActivity.class);
                            intent.putExtra("user",user);
                            startActivity(intent);
                        }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        if(item.getItemId() == R.id.setting){
            Intent intent = new Intent(AllBottomNavigationViewActivity.this,TutorProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
        if(item.getItemId() == R.id.logout){
            mAuth.signOut();
        }
        return super.onOptionsItemSelected(item);
    }
}
