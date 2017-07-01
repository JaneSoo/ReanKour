package com.example.janesoo.reankour;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by JaneSoo on 21-Jun-17.
 */

public class reankour extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
