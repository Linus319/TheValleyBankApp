package com.example.thevalleybankapp;

import java.util.ArrayList;

public class AccountManager {
    private ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();

    public AccountManager() {
        // default constructor
    }

    public void addUser(UserAccount newUser) {
        accountList.add(newUser);

    }
}
