package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_user);

        Intent confirmIntent = getIntent();

        TextView confirmText = (TextView) findViewById(R.id.confirmUserText);

        String newEmail = confirmIntent.getStringExtra("com.example.thevalleybankapp.newEmail");
        String newPassword = confirmIntent.getStringExtra("com.example.thevalleybankapp.newPassword");
        String newPhone = confirmIntent.getStringExtra("com.example.thevalleybankapp.newPhone");
        String newFirstName = confirmIntent.getStringExtra("com.example.thevalleybankapp.newFirstName");
        String newLastName = confirmIntent.getStringExtra("com.example.thevalleybankapp.newLastName");
        String newDOB = confirmIntent.getStringExtra("com.example.thevalleybankapp.newDOB");
        String newZip = confirmIntent.getStringExtra("com.example.thevalleybankapp.newZip");



        confirmText.setText("" +
                "Welcome, " + newFirstName +
                "\nemail: " + newEmail +
                "\npassword: " + newPassword +
                "\nphone: " + newPhone +
                "\nfirst: " + newFirstName +
                "\nlast: " + newLastName +
                "\nDOB: " + newDOB +
                "\nzip: " + newZip);
    }
}