package com.example.janesoo.reankour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.janesoo.reankour.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by JaneSoo on 14-Jun-17.
 */

public class LoginActivity extends AppCompatActivity {

    Button login;
    TextView signup, forgot;
    EditText email, password;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    DatabaseReference databaseReference;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null)
                {
                    Intent intent = new Intent(getBaseContext(), AllBottomNavigationViewActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        };
        progressDialog= new ProgressDialog(this);

        login = (Button) findViewById(R.id.loginbtn);
        signup = (TextView) findViewById(R.id.textSignup);
        email = (EditText) findViewById(R.id.loginemail);
        password = (EditText) findViewById(R.id.loginpass);
        forgot = (TextView) findViewById(R.id.textForgotPass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean test = true;

                if(email.getText().toString().equals("")){
                    email.setError("Required!");
                    test = false;
                }
                if(password.getText().toString().equals("")){
                    password.setError("Required");
                    test = false;
                }
                if(test){
                    checkLogin();
                }

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),ForgotPassActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void checkLogin(){
        String memail = email.getText().toString().trim();
        String mpassword = password.getText().toString().trim();
        progressDialog.setMessage("Waiting...");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(memail,mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.getCurrentUser().getUid());
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            User user = dataSnapshot.getValue(User.class);
                            if(user.getIsPublish().equals("false")){
                                Toast.makeText(getApplicationContext(), "You have disabled your account!", Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                            }
                            else {
                                progressDialog.dismiss();
                                Intent intent = new Intent(getBaseContext(), AllBottomNavigationViewActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    progressDialog.dismiss();
                    Toast.makeText(getBaseContext(),"Error login!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
