package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class CreateAccountActivity extends AppCompatActivity {

    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.EMAIL, DatabaseHelper.PASSWORD,
                                        DatabaseHelper.PHONE, DatabaseHelper.FIRST_NAME, DatabaseHelper.LAST_NAME,
                                        DatabaseHelper.DOB, DatabaseHelper.ZIP };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);




    }
}