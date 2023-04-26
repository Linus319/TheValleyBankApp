package com.example.thevalleybankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;

    private final Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String email, String password, String phone, String firstName, String lastName, String dob, String zip) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.EMAIL, email);
        contentValue.put(DatabaseHelper.PASSWORD, password);
        contentValue.put(DatabaseHelper.PHONE, phone);
        contentValue.put(DatabaseHelper.FIRST_NAME, firstName);
        contentValue.put(DatabaseHelper.LAST_NAME, lastName);
        contentValue.put(DatabaseHelper.DOB, dob);
        contentValue.put(DatabaseHelper.ZIP, zip);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.EMAIL, DatabaseHelper.PASSWORD, DatabaseHelper.PHONE, DatabaseHelper.FIRST_NAME, DatabaseHelper.LAST_NAME, DatabaseHelper.DOB, DatabaseHelper.ZIP };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String email, String password, String phone, String firstName, String lastName, String dob, String zip) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.PASSWORD, password);
        contentValues.put(DatabaseHelper.PHONE, phone);
        contentValues.put(DatabaseHelper.FIRST_NAME, firstName);
        contentValues.put(DatabaseHelper.LAST_NAME, lastName);
        contentValues.put(DatabaseHelper.DOB, dob);
        contentValues.put(DatabaseHelper.ZIP, zip);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }
}
