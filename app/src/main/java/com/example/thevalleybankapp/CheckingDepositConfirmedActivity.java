package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CheckingDepositConfirmedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_deposit_confirmed);

        Button bAccountHome = (Button) findViewById(R.id.svConfirmGoBackButton);

        Intent goHomeActivity = new Intent(this, AccountActivity.class);

        bAccountHome.setOnClickListener(v -> {
            startActivity(goHomeActivity);
        });
    }
}