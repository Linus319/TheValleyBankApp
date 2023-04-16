package com.example.thevalleybankapp;

public class UserAccount {
    private int id;
    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String dob;
    private String zip;


    private static int next_id = 1;

    public UserAccount(String newEmail, String newPassword, String newPhone, String newFirstName, String newLastName, String newDOB, String newZip) {
        id = next_id;
        next_id += 1;

        email = newEmail;
        password = newPassword;
        phone = newPhone;
        firstName = newFirstName;
        lastName = newLastName;
        dob = newDOB;
        zip = newZip;
    }
}
