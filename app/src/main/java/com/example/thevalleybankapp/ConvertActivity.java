package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

public class ConvertActivity extends AppCompatActivity {

    Spinner spi1, spi2;
    EditText txtEntry;

    TextView txtResult;
    Button Convert, goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_currency);

        txtEntry = findViewById(R.id.fromText);
        txtResult = findViewById(R.id.toText);
        spi1 = findViewById(R.id.spFrom);
        spi2 = findViewById(R.id.spTo);
        Convert = findViewById(R.id.equal);

        String[] from = {"USD", "MXN"};
        ArrayAdapter adp1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        spi1.setAdapter(adp1);

        String[] to = {"USD", "MXN"};
        ArrayAdapter adp2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        spi2.setAdapter(adp2);

        Convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double conv;

                Double fromAmt = Double.parseDouble(txtEntry.getText().toString());

                if ((spi1.getSelectedItem().toString() == "USD" && spi2.getSelectedItem().toString() == "USD") || (spi1.getSelectedItem().toString() == "MXN" && spi2.getSelectedItem().toString() == "MXN")){
                    conv = fromAmt;
                    txtResult.setText("$ "+conv);
                }

                else if (spi1.getSelectedItem().toString() == "MXN" && spi2.getSelectedItem().toString() == "USD"){
                    conv = fromAmt / 18.16;
                    txtResult.setText("$ " + String.format("%.2f", conv));
                }

                else if (spi1.getSelectedItem().toString() == "USD" && spi2.getSelectedItem().toString() == "MXN"){
                    conv = fromAmt * 18.16;
                    txtResult.setText("$ " + String.format("%.2f", conv));
                }

            }
        });

        Intent thisIntent = getIntent();

        String email = thisIntent.getStringExtra("com.example.thevalleybankapp.accountEmail");

        goBackButton = findViewById(R.id.convertGoBackButton);

        Intent goBackIntent = new Intent(this, AccountActivity.class);

        goBackButton.setOnClickListener(v -> {
            goBackIntent.putExtra("com.example.thevalleybankapp.accountEmail", email);
            startActivity(goBackIntent);
        });

    }

//    TextWatcher textWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if (txtEntry.getText().toString().equals("")) {
//                return;
//            }
//
//            double money = Double.parseDouble(txtEntry.getText().toString());
//        }
//
//        @Override
//        public void afterTextChanged (Editable s){
//
//        }
//
//    };

}