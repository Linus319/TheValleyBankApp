package com.example.thevalleybankapp;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

public class Transaction {
    private String transDate;
    private String transMessage;
    private String transType;
    private double transAmount;
    private double userBalance;

    public Transaction(String message, String transactionType, double amount, double svBalance) {
        transDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        transMessage = message;
        transType = transactionType;
        transAmount = amount;
        userBalance = svBalance;
    }

    public String toTransactionString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String result = (transDate + " " + transMessage + " " + transType + " " + formatter.format(transAmount) + " " + formatter.format(userBalance));
        return result;
    }



}
