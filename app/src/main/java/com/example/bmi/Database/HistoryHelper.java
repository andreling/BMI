package com.example.bmi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bmi.Object.History;

public class HistoryHelper {
    private final String TABLE_NAME = "history";
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public HistoryHelper(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void insert(History history){
        db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserID",history.getUserID());
        contentValues.put("Result",history.getResult());
        contentValues.put("Health",history.getHealth());
        contentValues.put("Date",history.getDate());
        contentValues.put("Time",history.getTime());

        db.insert(TABLE_NAME,null,contentValues);
        db.close();

    }

    public Cursor readlast(Integer userID){
        db = dataBaseHelper.getReadableDatabase();
        Cursor cursor = null;
        if (db!=null){
            cursor = db.rawQuery("SELECT * FROM history WHERE UserID = ? ORDER BY id DESC LIMIT 1",new String[]{String.valueOf(userID)});
        }
        return cursor;

    }



    public Cursor readAllData(Integer userID){
        db = dataBaseHelper.getReadableDatabase();
        Cursor cursor = null;
        if (db!=null){
            cursor = db.rawQuery("SELECT * FROM history WHERE UserID = ?",new String[]{String.valueOf(userID)});
        }
        return cursor;
    }
}
