package com.example.thevalleybankapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SavingsDepositConfirmedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_deposit_confirmed);

        Button bAccountHome = findViewById(R.id.svConfirmGoBackButton);

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        Intent goHomeActivity = new Intent(this, AccountActivity.class);

        bAccountHome.setOnClickListener(v -> {
            goHomeActivity.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(goHomeActivity);
        });
    }
}