package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button loginButton;

    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (MainActivity.AM.getValidationMap().containsKey(email) && password.equals(MainActivity.AM.getPassword(email))) {
                loginButton.setEnabled(true);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.enterUsername);
        etPassword = (EditText) findViewById(R.id.enterPassword);

        Button returnHome = (Button) findViewById(R.id.homeButton);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setEnabled(false);

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        Intent returnHomeIntent = new Intent(this, MainActivity.class);
        Intent loginIntent = new Intent(this, AccountActivity.class);

        returnHome.setOnClickListener(v -> startActivity(returnHomeIntent));

        loginButton.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            loginIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(loginIntent);
        });

    }
}