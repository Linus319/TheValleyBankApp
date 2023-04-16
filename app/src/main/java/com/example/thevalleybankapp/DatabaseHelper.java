package com.example.thevalleybankapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table name
    public static final String TABLE_NAME = "USER_INFO";

    // Table columns
    public static final String _ID = "_id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String DOB = "dob";
    public static final String ZIP = "zip";

    // Database Information
    static final String DB_NAME = "USER_INFO.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
                                                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                EMAIL + " TEXT NOT NULL UNIQUE," +
                                                PASSWORD + "TEXT NOT NULL UNIQUE," +
                                                PHONE + " INTEGER NOT NULL UNIQUE," +
                                                FIRST_NAME + "TEXT NOT NULL," +
                                                LAST_NAME + "TEXT NOT NULL," +
                                                DOB + "TEXT NOT NULL," +
                                                ZIP + " INTEGER);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
