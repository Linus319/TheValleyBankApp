package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class CheckingTransactionActivity extends AppCompatActivity {

//    ListView listView;
//    ArrayList chTransList; //hasp map;
//    ArrayAdapter adapter;

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

        // listView = (ListView) findViewById(R.id.chTransList);

//        List chList = MainActivity.AM.getUser(email).getCheckingHistory();
//
//        for (int i = 0; i < chTransList.size(); i++) {
//            chList.add(chTransList.get(i));
//        }


//        public Transaction userCheckingHist =

//        for (int i = 0; i <)
//        chList.add();
//        list.add("Trans 2");
//        list.add("Trans 3");
//        list.add("Trans 4");
//        list.add("Trans 5");
//        list.add("Trans 6");

//        adapter = new ArrayAdapter(CheckingTransactionActivity.this, android.R.layout.simple_list_item_1,chTransList);
//        listView.setAdapter(adapter);
    }
}