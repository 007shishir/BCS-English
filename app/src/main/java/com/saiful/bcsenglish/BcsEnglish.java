package com.saiful.bcsenglish;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class BcsEnglish extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
