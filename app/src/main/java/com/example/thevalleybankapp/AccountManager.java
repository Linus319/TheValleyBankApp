package com.example.thevalleybankapp;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountManager {
    private ArrayList<UserAccount> accountList = new ArrayList<UserAccount>();
    private HashMap<String, String> validationMap = new HashMap<String, String>(); // <email, password>

    public AccountManager() {
        // default constructor
    }

    public void addUser(UserAccount newUser) {
        String email = newUser.getEmail();
        String password = newUser.getPassword();

        validationMap.put(email, password);

        accountList.add(newUser);
    }

    public HashMap<String, String> getValidationMap() {
        return validationMap;
    }

    public String getPassword(String email) {
        return validationMap.get(email);
    }

    // FIX ME!!! -- bad worst case runtime, should replace with a HashMap of <email, ArrayList index>
    public String getFirstName(String email) {
        for (UserAccount user : accountList) {
            if (user.getEmail().equals(email)) {
                return user.getFirstName();
            }
        }
        return "";
    }

    // FIX ME!!! -- bad worst case runtime, should replace with a HashMap of <email, ArrayList index>
    public String getCheckingBalance(String email) {
        for (UserAccount user : accountList) {
            if (user.getEmail().equals(email)) {
                return user.getCheckingBalance();
            }
        }
        return "";
    }

    // FIX ME!!! -- bad worst case runtime, should replace with a HashMap of <email, ArrayList index>
    public String getSavingsBalance(String email) {
        for (UserAccount user : accountList) {
            if (user.getEmail().equals(email)) {
                return user.getSavingsBalance();
            }
        }
        return "";
    }
}
