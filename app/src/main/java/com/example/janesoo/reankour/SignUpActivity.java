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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by JaneSoo on 14-Jun-17.
 */

public class SignUpActivity extends AppCompatActivity {

    TextView login;
    EditText fullname, email, password, conpassword;
    Button signup;
    Spinner accounttype;

    ProgressDialog progressDialog;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        progressDialog= new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        login = (TextView) findViewById(R.id.loginnow);
        fullname = (EditText) findViewById(R.id.signupFullname);
        email = (EditText) findViewById(R.id.singupEmail);
        password = (EditText) findViewById(R.id.singupPassword);
        conpassword = (EditText) findViewById(R.id.confirmPassword);
        signup = (Button) findViewById(R.id.signupBtn);
        accounttype = (Spinner) findViewById(R.id.signupAccountType);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean canRegister = true;
                if(fullname.getText().toString().equals("")){
                    fullname.setError("Required!");
                    canRegister = false;
                }
                if(email.getText().toString().equals("")){
                    email.setError("Required!");
                    canRegister = false;
                }
                if(password.getText().toString().length()<6){
                    password.setError("Password must be more than 6 characters!");
                    canRegister = false;
                }
                if(password.getText().toString().equals("")){
                    password.setError("Required");
                    canRegister = false;
                }
                if(conpassword.getText().toString().equals("")){
                    conpassword.setError("Required!");
                    canRegister = false;
                }
                if(!password.getText().toString().equals(conpassword.getText().toString())){
                    conpassword.setError("Confirm password is not matched!");
                    canRegister = false;
                }

                if(canRegister){
                    startRegister();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startRegister(){

        progressDialog.setMessage("Signing up...");
        progressDialog.show();

        final String mname = fullname.getText().toString();
        final String memail = email.getText().toString().trim();
        final String mpassword = password.getText().toString();
        final String maccountType = accounttype.getSelectedItem().toString();

        mAuth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_id = mDatabase.child(user_id);
                    current_user_id.child("fullname").setValue(mname);
                    current_user_id.child("email").setValue(memail);
                    current_user_id.child("accountType").setValue(maccountType);
                    current_user_id.child("experience").setValue("N/A");
                    current_user_id.child("address").setValue("N/A");
                    current_user_id.child("phone").setValue("N/A");
                    current_user_id.child("dob").setValue("N/A");
                    current_user_id.child("sex").setValue("N/A");
                    current_user_id.child("skill").setValue("N/A");
                    current_user_id.child("education").setValue("N/A");
                    current_user_id.child("position").setValue("N/A");
                    current_user_id.child("isPublish").setValue("true");
                    progressDialog.dismiss();
                    Intent intent = new Intent(SignUpActivity.this, AllBottomNavigationViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),task.getException().toString(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }


            }
        });


    }


}
