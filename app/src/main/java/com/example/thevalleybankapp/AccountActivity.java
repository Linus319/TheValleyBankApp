package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Button signOutButton = (Button) findViewById(R.id.signOutButton);
        Button bCheckingDeposit = (Button) findViewById(R.id.checkingDeposit);
        Button bSavingsDeposit = (Button) findViewById(R.id.savingsDeposit);
;
        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        TextView welcomeText = (TextView) findViewById(R.id.accountWelcome);
        TextView checkingBalance = (TextView) findViewById(R.id.checkingBalance);
        TextView savingsBalance = (TextView) findViewById(R.id.savingsBalance);

        welcomeText.setText("Welcome, " + MainActivity.AM.getFirstName(email)+ "!");
        checkingBalance.setText(MainActivity.AM.getCheckingBalance(email));
        savingsBalance.setText(MainActivity.AM.getSavingsBalance(email));

        Intent logOutIntent = new Intent(this, MainActivity.class);
        Intent depositCheckingIntent = new Intent(this, CheckingDepositActivity.class);
        Intent depositSavingsIntent = new Intent(this, SavingsDepositActivity.class);

        signOutButton.setOnClickListener(v -> {
            startActivity(logOutIntent);
        });

        bCheckingDeposit.setOnClickListener(v -> {
            depositCheckingIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(depositCheckingIntent);
        });

        bSavingsDeposit.setOnClickListener(v -> {
            startActivity(depositSavingsIntent);
        });
    }
}