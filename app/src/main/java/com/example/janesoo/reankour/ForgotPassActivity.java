package com.example.janesoo.reankour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by JaneSoo on 29-Jun-17.
 */

public class ForgotPassActivity extends AppCompatActivity{

    EditText emailReset;
    Button submitreset;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password_layout);

        emailReset = (EditText) findViewById(R.id.forgetemail);
        submitreset = (Button) findViewById(R.id.btnSubmit);

        submitreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                mAuth.sendPasswordResetEmail(emailReset.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getBaseContext(),"Please check your email!",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
                            startActivity(intent);
                        }
                    }
                });

            }

        });

    }
}
