package com.example.bmi.Object;

public class History{

    Integer id;
    Integer UserID;
    Double Result;
    String Health;
    String Date;
    String Time;

    public History(Integer userID, Double result, String health, String date, String time) {
        UserID = userID;
        Result = result;
        Health = health;
        Date = date;
        Time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Double getResult() {
        return Result;
    }

    public void setResult(Double result) {
        Result = result;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}

