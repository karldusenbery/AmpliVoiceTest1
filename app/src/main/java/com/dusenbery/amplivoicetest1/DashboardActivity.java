package com.dusenbery.amplivoicetest1;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dusenbery.amplivoicetest1.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeMessage;

    private FirebaseFirestore mFirestore;

    String userID, email, createdDate;

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


        tvWelcomeMessage = (TextView)findViewById(R.id.tvWelcomeMessage);
        tvWelcomeMessage.setText("Welcome " + firstName);

        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Initialize Firestore
        initFirestore();

        // Get a reference to the users Firestore collection
        CollectionReference users = mFirestore.collection("users");

        // Gets the current authenticated user from Firebase
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //Gets the current user's uid  from the Firestore database and stores it as a String
        userID = user.getUid();

        //Gets the current user's email address from the Firestore database and stores it as a String
        email = user.getEmail();

        //TODO: Gets the current user's created date from the Firestore database and stores it as a String
        //createdDate = user.

        // Creates a new User object
        User mUser = new User(firstName, lastName);

        // Sets user id field the current user object
        mUser.setUserID(userID);

        //user object data check
        //Log.d("USERDATA", "Your user's ID is: " + mUser.getUserID());



        // Add a new document to the users collection with the created User object
        users.document(userID).set(mUser);

    }

    private void initFirestore() {
        // Access a Cloud Firestore instance from your Activity
        mFirestore = FirebaseFirestore.getInstance();
    }
}