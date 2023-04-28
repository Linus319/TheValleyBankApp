package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class CheckingTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_transactions);

        Intent thisIntent = getIntent();
        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        TextView chBalanceTitle = findViewById(R.id.chBalanceTitle);
        chBalanceTitle.setText("Checking Balance: " + MainActivity.AM.getCheckingBalance(email));






    }
}