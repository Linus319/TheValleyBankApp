package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SavingsDepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_deposit);

        Button svDeposit = (Button) findViewById(R.id.svDepositButton);
        Button svGoBack = (Button) findViewById(R.id.svGoBackButton);

        Intent savingsDepositIntent = new Intent(this, SavingsDepositConfirmedActivity.class);
        Intent savingsGoBackIntent = new Intent(this, AccountActivity.class);

        svDeposit.setOnClickListener(v -> {
            startActivity(savingsDepositIntent);
        });

        svGoBack.setOnClickListener(v -> {
            startActivity(savingsGoBackIntent);
        });
    }
}