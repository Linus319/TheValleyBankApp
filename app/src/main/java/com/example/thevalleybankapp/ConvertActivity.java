package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

public class ConvertActivity extends AppCompatActivity {

    Button goBackButton;

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_currency);

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        goBackButton = findViewById(R.id.convertGoBackButton);

        Intent goBackIntent = new Intent(this, AccountActivity.class);

        goBackButton.setOnClickListener(v -> {
            goBackIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(goBackIntent);
        });
    }
}