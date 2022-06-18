package com.example.bmi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bmi.Object.User;

public class UserHelper {
    private final String TABLE_NAME = "user";
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public UserHelper(Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void insert(User user){
        db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",user.getName());
        contentValues.put("Email",user.getEmail());
        contentValues.put("Password",user.getPassword());
        contentValues.put("Age",user.getAge());
        contentValues.put("Gender",user.getGender());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public User auth(String email, String password){
        db = dataBaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE Email = ? and Password = ?",
                new String[]{email,password});

        User user = null;
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));
            user.setAge(cursor.getInt(4));
            user.setGender(cursor.getString(5));
            cursor.close();
        }
        db.close();
        return user;
    }

//    public void update(Users user){
//        db = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("username",user.getUserUsername());
//        db.update(TABLE_NAME, contentValues, "id = ?", new String[]{user.getId()+""});
//        db.close();
//    }

//    public boolean uniqueName(String name){
//        String nametxt;
//        db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM users",null);
//
//        cursor.moveToFirst();
//
//        while (cursor.isAfterLast()==false){
//            nametxt = cursor.getString(1);
//            if(name.equals(nametxt)){
//                cursor.close();
//                db.close();
//                return false;
//            }
//            cursor.moveToNext();
//        }
//        cursor.close();
//        db.close();
//        return true;
//    }
//
//    public boolean uniqueEmail(String email){
//        String emailtxt;
//        db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM users",null);
//
//        cursor.moveToFirst();
//
//        while (cursor.isAfterLast()==false){
//            emailtxt = cursor.getString(3);
//            if(email.equals(emailtxt)){
//                cursor.close();
//                db.close();
//                return false;
//            }
//            cursor.moveToNext();
//        }
//        cursor.close();
//        db.close();
//        return true;
//    }



}
