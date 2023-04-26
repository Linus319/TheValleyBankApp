package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static AccountManager AM = new AccountManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.clickLogin);
        Button createAccountButton = findViewById(R.id.clickCreateAccount);

        Intent loginView = new Intent(this, LoginActivity.class);
        Intent createAccountView = new Intent(this, CreateAccountActivity.class);

        loginButton.setOnClickListener(v -> startActivity(loginView));

        createAccountButton.setOnClickListener(v -> startActivity(createAccountView));
    }


}