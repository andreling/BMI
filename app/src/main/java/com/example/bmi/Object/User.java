package com.example.bmi.Object;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int id;
    String Name;
    String Email;
    String Password;
    Integer Age;
    String Gender;

    public User(){

    }

    public User(String name, String email, String password, Integer age, String gender) {
        Name = name;
        Email = email;
        Password = password;
        Age = age;
        Gender = gender;
    }

    protected User(Parcel in) {
        id = in.readInt();
        Name = in.readString();
        Email = in.readString();
        Password = in.readString();
        if (in.readByte() == 0) {
            Age = null;
        } else {
            Age = in.readInt();
        }
        Gender = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(Name);
        parcel.writeString(Email);
        parcel.writeString(Password);
        if (Age == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(Age);
        }
        parcel.writeString(Gender);
    }
}
