package com.example.bmi.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final String CREATE_TABLE_BMI = "CREATE TABLE history(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "UserID INTEGER NOT NULL," +
            "Result REAL NOT NULL," +
            "Health STRING NOT NULL," +
            "Date STRING NOT NULL," +
            "Time STRING NOT NULL)";

    private final String CREATE_TABLE_USER = "CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Name STRING NOT NULL," +
            "Email STRING NOT NULL," +
            "Password STRING NOT NULL," +
            "Age INTEGER NOT NULL," +
            "Gender STRING NOT NULL)";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "sqlite",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_BMI);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
        onCreate(sqLiteDatabase);
    }
}
