package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TransferFunds extends AppCompatActivity {
    private TextView checkings_amount;
    private TextView savings_amount;
    private EditText transferAmountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_funds);

        Intent thisIntent = getIntent();
        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        checkings_amount = findViewById(R.id.checkings_amount);
        checkings_amount.setText(MainActivity.AM.getCheckingBalance(email));

        savings_amount = findViewById(R.id.savings_amount);
        savings_amount.setText(MainActivity.AM.getSavingsBalance(email));

        transferAmountEditText = findViewById(R.id.transfer_amount);

        Button transfer_button = findViewById(R.id.transfer_button);
        transfer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performTransfer();
            }
        });
    }

    public void setCheckingVal(double checkingBalance) {
        this.checkings_amount = checkings_amount;
    }

    public void setSavingsVal(double savingsBalance) {
        this.savings_amount = savings_amount;
    }


    private void performTransfer() {
        double transferAmount = Double.parseDouble(transferAmountEditText.getText().toString());
        double savingsAmount = Double.parseDouble(savings_amount.getText().toString());
        double checkingsAmount = Double.parseDouble(checkings_amount.getText().toString());

      checkingsAmount -= transferAmount;

        checkings_amount.setText(String.valueOf(checkingsAmount));

        savingsAmount += transferAmount;
        savings_amount.setText(String.valueOf(savingsAmount));

        transferAmountEditText.setText("");
    }

}