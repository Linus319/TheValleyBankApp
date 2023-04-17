package com.example.thevalleybankapp;

import java.text.NumberFormat;

public class UserAccount {
    private double checkingBalance;
    private double savingsBalance;
    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String dob;
    private String zip;

    public UserAccount(String newEmail, String newPassword, String newPhone, String newFirstName, String newLastName, String newDOB, String newZip) {
        email = newEmail;
        password = newPassword;
        phone = newPhone;
        firstName = newFirstName;
        lastName = newLastName;
        dob = newDOB;
        zip = newZip;

        checkingBalance = 0;
        savingsBalance = 0;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCheckingBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(checkingBalance);
    }

    public String getSavingsBalance() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(savingsBalance);
    }
}
