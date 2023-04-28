package com.example.thevalleybankapp;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountManager {
    private ArrayList<UserAccount> accountList = new ArrayList<>();
    private HashMap<String, String> validationMap = new HashMap<>(); // <email, password>
    private HashMap<String, Integer> indexMap = new HashMap<>(); // <email, accountList[index]>

    public AccountManager() {
        // default constructor
    }

    public void addUser(UserAccount newUser) {
        String email = newUser.getEmail();
        String password = newUser.getPassword();

        validationMap.put(email, password); // store association: (key, value) = (email, password)

        indexMap.put(email, accountList.size()); // store association (key, value) = (email, index (of accountList))

        accountList.add(newUser);
    }

    public HashMap<String, String> getValidationMap() {
        return validationMap;
    }

    public String getPassword(String email) {
        return validationMap.get(email);
    }

    public String getFirstName(String email) {
        if (indexMap.get(email) != null) {
            UserAccount u = accountList.get(indexMap.get(email));
            return u.getFirstName();
        }
        return null;
    }

    public UserAccount getUser(String email) {
        return accountList.get(indexMap.get(email));
    }

    public String getCheckingBalance(String email) {
        if (indexMap.get(email) != null) {
            UserAccount u = accountList.get(indexMap.get(email));
            return u.getCheckingBalance();
        }
        return null;
    }

    public String getSavingsBalance(String email) {
        if (indexMap.get(email) != null) {
            UserAccount u = accountList.get(indexMap.get(email));
            return u.getSavingsBalance();
        }
        return null;
    }

    public double getCheckingVal(String email) {
        UserAccount u = accountList.get(indexMap.get(email));
        return u.getCheckingVal();
    }

    public double getSavingsVal(String email) {
        UserAccount u = accountList.get(indexMap.get(email));
        return u.getSavingsVal();
    }

    public void depositChecking(String email, double amount) {
        if (indexMap.get(email) != null) {
            UserAccount u = accountList.get(indexMap.get(email));
            u.depositChecking(amount);
        }
    }

    public void depositSavings(String email, double amount) {
        if (indexMap.get(email) != null) {
            UserAccount u = accountList.get(indexMap.get(email));
            u.depositSavings(amount);
        }
    }

    public boolean emailExists(String email) {
        return indexMap.get(email) != null;
    }

    public void updateUserChecking(String email, double amount) {
        int index = indexMap.get(email);
        UserAccount user = accountList.get(index);
        user.newCheckingTransaction("PLACEHOLDER", "PLACEHOLDER", amount);
    }

    public void updateUserSavings(String email, double amount) {
        int index = indexMap.get(email);
        UserAccount user = accountList.get(index);
        user.newSavingsTransaction("PLACEHOLDER", "PLACEHOLDER", amount);
    }



}
