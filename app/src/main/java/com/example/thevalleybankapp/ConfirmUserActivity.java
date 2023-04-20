package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_user);

        Button loginButton = (Button) findViewById(R.id.goToLogin);
        Button homeButton = (Button) findViewById(R.id.goToHome);

        TextView confirmText = (TextView) findViewById(R.id.confirmUserText);

        Intent confirmIntent = getIntent();

        String newFirstName = confirmIntent.getStringExtra("com.example.thevalleybankapp.newFirstName");

        confirmText.setText("Welcome, " + newFirstName + "!");

        Intent loginIntent = new Intent(this, LoginActivity.class);
        Intent homeIntent = new Intent(this, MainActivity.class);

        loginButton.setOnClickListener(v -> {
            startActivity(loginIntent);
        });

        homeButton.setOnClickListener(v -> {
            startActivity(homeIntent);
        });
    }
}