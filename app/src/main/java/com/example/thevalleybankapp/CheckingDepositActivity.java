package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CheckingDepositActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_deposit);

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybank.accountEmail");

        Button chDeposit = (Button) findViewById(R.id.chDepositButton);
        Button chGoBack = (Button) findViewById(R.id.chGoBackButton);

        Intent checkingDepositIntent = new Intent(this, CheckingDepositConfirmedActivity.class);
        Intent checkingGoBackIntent = new Intent(this, AccountActivity.class);

        EditText depositText = (EditText) findViewById(R.id.chEnterDeposit);

        chDeposit.setOnClickListener(v -> {
            if (depositText.getText().toString().equals("")) {
                // do nothing
            }
            else {
                double deposit = Double.parseDouble(depositText.getText().toString());
                MainActivity.AM.depositChecking(email, deposit);
            }

            checkingDepositIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(checkingDepositIntent);
        });

        chGoBack.setOnClickListener(v -> {
            startActivity(checkingGoBackIntent);
        });
    }
}