package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class SavingsDepositActivity extends AppCompatActivity {

    EditText svDepositText;
    Button svDeposit, svGoBack;

    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (svDepositText.getText().toString().equals("")) {
                return;
            }

            double amount = Double.parseDouble(svDepositText.getText().toString());

            if (amount > 0) {
                svDeposit.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_deposit);

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        svDeposit = findViewById(R.id.svDepositButton);
        svDeposit.setEnabled(false);

        svGoBack = findViewById(R.id.svGoBackButton);

        Intent savingsDepositIntent = new Intent(this, CheckingDepositConfirmedActivity.class);
        Intent savingsGoBackIntent = new Intent(this, AccountActivity.class);

        svDepositText = findViewById(R.id.svEnterDeposit);
        svDepositText.addTextChangedListener(textWatcher);

        svDeposit.setOnClickListener(v -> {
            if (!svDepositText.getText().toString().equals("")) { // if amount isn't empty
                double deposit = Double.parseDouble(svDepositText.getText().toString());
                MainActivity.AM.depositSavings(email, deposit);
            }

            savingsDepositIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(savingsDepositIntent);
        });

        svGoBack.setOnClickListener(v -> {
            savingsGoBackIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(savingsGoBackIntent);
        });}
}