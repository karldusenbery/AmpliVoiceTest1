package com.dusenbery.amplivoicetest1;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(DashboardActivity.this);
        String firstName = myPreferences.getString("FIRST_NAME", "unknown");

        tvWelcomeMessage = (TextView)findViewById(R.id.tvWelcomeMessage);
        tvWelcomeMessage.setText("Welcome " + firstName);
    }
}