package com.example.thevalleybankapp;

import java.text.NumberFormat;
import java.util.ArrayList;

public class UserAccount {

    private ArrayList<Transaction> checkingHistory = new ArrayList<>();
    private ArrayList<Transaction> savingsHistory = new ArrayList<>();
    private double checkingBalance;
    private double savingsBalance;
    private final String email;
    private final String password;
    private final String phone;
    private final String firstName;
    private final String lastName;
    private final String dob;
    private final String zip;

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

    public double getCheckingVal() {
        return checkingBalance;
    }

    public double getSavingsVal() {
        return savingsBalance;
    }

    public void setCheckingVal(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsVal(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }


    public void depositChecking(double deposit) {
        checkingBalance += deposit;
        Transaction t = new Transaction("", "Deposit", deposit, checkingBalance);
        checkingHistory.add(t);
    }

    public void depositSavings(double deposit) {
        savingsBalance += deposit;
        Transaction t = new Transaction("", "Deposit", deposit, savingsBalance);
        savingsHistory.add(t);
    }

    public void newCheckingTransaction(String message, String transType, double amount) {
        checkingBalance += amount;
        Transaction t = new Transaction(message, transType, amount, savingsBalance);
        checkingHistory.add(t);
    }

    public void newSavingsTransaction(String message, String transType, double amount) {
        savingsBalance += amount;
        Transaction t = new Transaction(message, transType, amount, savingsBalance);
        savingsHistory.add(t);
    }

    public ArrayList<Transaction> getCheckingHistory() {
        return checkingHistory;
    }

    public ArrayList<Transaction> getSavingsHistory() {
        return savingsHistory;
    }

}
