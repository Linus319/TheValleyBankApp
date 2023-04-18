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

        Button bAccountHome = (Button) findViewById(R.id.svConfirmGoBackButton);

        Intent goHomeActivity = new Intent(this, AccountActivity.class);

        bAccountHome.setOnClickListener(v -> {
            startActivity(goHomeActivity);
        });
    }
}