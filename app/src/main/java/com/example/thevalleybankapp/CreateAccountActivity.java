package com.example.thevalleybankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountActivity extends AppCompatActivity {

    EditText etEmail, etPassword, etPhone, etFirst, etLast, etDOB, etZip;
    EditText firstEmail, firstPass;

    Button submitButton, backButton;

    private boolean isEmailValid(String email)
    {
        final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        final Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // submitButton.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            boolean allFieldsFull, passwordIsValid = false, passwordsMatch = false, emailsMatch = false,
                    emailUnique = false, emailIsValid;

            String newEmail = etEmail.getText().toString();
            String newPassword = etPassword.getText().toString();
            String newPhone = etPhone.getText().toString();
            String newFirstName = etFirst.getText().toString();
            String newLastName = etLast.getText().toString();
            String newDOB = etDOB.getText().toString();
            String newZip = etZip.getText().toString();
            String newFirstEmail = firstEmail.getText().toString();
            String newFirstPass = firstPass.getText().toString();

            // check that all fields are full
            allFieldsFull = !newEmail.isEmpty() && !newPassword.isEmpty() && !newPhone.isEmpty() &&
                                    !newFirstName.isEmpty() && !newLastName.isEmpty() && !newDOB.isEmpty() &&
                                    !newZip.isEmpty() && !newFirstEmail.isEmpty() && !newFirstPass.isEmpty();

            // check that both passwords match
            if (firstPass.getText().toString().equals(etPassword.getText().toString())) {
                passwordsMatch = true;
            }

            // check that the first password is 12 characters
            if (etPassword.getText().toString().length() >= 12) {
                passwordIsValid = true;
            }

            // check that both emails match
            if (firstEmail.getText().toString().equals(etEmail.getText().toString())) {
                emailsMatch = true;
            }

            // check that email and phone number are unique
            if (!MainActivity.AM.emailExists(newEmail)) {
                emailUnique = true;
            }

            // check if email is valid
            emailIsValid = isEmailValid(newEmail);


            submitButton.setEnabled(allFieldsFull && passwordsMatch && passwordIsValid
                    && emailsMatch && emailUnique && emailIsValid);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        submitButton = (Button) findViewById(R.id.createAccountButton);
        submitButton.setEnabled(false);

        backButton = (Button) findViewById(R.id.superHomeButton);

        etEmail = (EditText) findViewById(R.id.confirmEmail);
        etPassword = (EditText) findViewById(R.id.confirmPass);
        etPhone = (EditText) findViewById(R.id.editTextPhone);
        etFirst = (EditText) findViewById(R.id.enterFirstName);
        etLast = (EditText) findViewById(R.id.enterLastName);
        etDOB = (EditText) findViewById(R.id.enterDOB);
        etZip = (EditText) findViewById(R.id.enterZip);
        firstEmail = (EditText) findViewById(R.id.enterEmail);
        firstPass = (EditText) findViewById(R.id.enterPass);

        etEmail.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);
        etPhone.addTextChangedListener(textWatcher);
        etFirst.addTextChangedListener(textWatcher);
        etLast.addTextChangedListener(textWatcher);
        etDOB.addTextChangedListener(textWatcher);
        etZip.addTextChangedListener(textWatcher);
        firstEmail.addTextChangedListener(textWatcher);
        firstPass.addTextChangedListener(textWatcher);

        // make intent to pass to button listener
        Intent confirmUserIntent = new Intent(this, ConfirmUserActivity.class);
        Intent goBack = new Intent(this, MainActivity.class);

        submitButton.setOnClickListener(v -> {
            String newEmail = etEmail.getText().toString();
            String newPassword = etPassword.getText().toString();
            String newPhone = etPhone.getText().toString();
            String newFirstName = etFirst.getText().toString();
            String newLastName = etLast.getText().toString();
            String newDOB = etDOB.getText().toString();
            String newZip = etZip.getText().toString();

            // call constructor for new user
            UserAccount newUser = new UserAccount(newEmail, newPassword, newPhone, newFirstName, newLastName, newDOB, newZip);

            // add user to account manager
            MainActivity.AM.addUser(newUser);

            confirmUserIntent.putExtra("com.example.thevalleybankapp.newFirstName", newFirstName);

            startActivity(confirmUserIntent);
        });

        backButton.setOnClickListener(v -> {
            startActivity(goBack);
        });
    }
}