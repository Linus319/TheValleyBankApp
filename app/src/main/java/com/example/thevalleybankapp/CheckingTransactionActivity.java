package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class CheckingTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking_transactions);


        Intent thisIntent = getIntent();
        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        Button goBack = findViewById(R.id.chTransGoBackButton);

        Intent goBackIntent = new Intent(this, AccountActivity.class);

        goBack.setOnClickListener(v -> {
            goBackIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(goBackIntent);
        });
    }
}