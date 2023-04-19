package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class CheckingDepositActivity extends AppCompatActivity {
    EditText depositText;
    Button chDeposit, chGoBack;

    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (depositText.getText().toString().equals("")) {
                return;
            }

            double amount = Double.parseDouble(depositText.getText().toString());

            if (amount > 0) {
                chDeposit.setEnabled(true);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_deposit);

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        chDeposit = findViewById(R.id.chDepositButton);
        chDeposit.setEnabled(false);

        chGoBack = findViewById(R.id.chGoBackButton);

        Intent checkingDepositIntent = new Intent(this, CheckingDepositConfirmedActivity.class);
        Intent checkingGoBackIntent = new Intent(this, AccountActivity.class);

        depositText = findViewById(R.id.chEnterDeposit);
        depositText.addTextChangedListener(textWatcher);

        chDeposit.setOnClickListener(v -> {
            if (!depositText.getText().toString().equals("")) { // if amount isn't empty
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