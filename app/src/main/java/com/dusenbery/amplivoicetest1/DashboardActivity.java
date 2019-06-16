package com.dusenbery.amplivoicetest1;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.dusenbery.amplivoicetest1.model.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeMessage;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /**
         *
         * Using SharedPreferences to pull the user persistent data from a key-value pair
         */
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(DashboardActivity.this);
        String firstName = myPreferences.getString("FIRST_NAME", "unknown");
        String lastName = myPreferences.getString("LAST_NAME", "unknown");


        // get first and last name strings from SharedPreferences persistant data
        // and create a new User object with those Strings
        User mUser = new User(firstName, lastName);

        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Initialize Firestore
        initFirestore();

        /*
        // Get a reference to the users Firestore collection
        CollectionReference users = mFirestore.collection("users");

        // Add a new document to the users collection
        users.add(mUser);
        */


        tvWelcomeMessage = (TextView)findViewById(R.id.tvWelcomeMessage);
        tvWelcomeMessage.setText("Welcome " + firstName);
    }

    private void initFirestore() {
        // Access a Cloud Firestore instance from your Activity
        mFirestore = FirebaseFirestore.getInstance();
    }
}