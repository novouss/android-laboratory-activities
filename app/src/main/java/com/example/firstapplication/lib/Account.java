package com.example.firstapplication.lib;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private String username = null;
    private String email = null;
    private String program = null;
    private String course1 = null;
    private String course2 = null;
    private String course3 = null;
    private String firstname = null;
    private String lastname = null;
    private String password = null;

    public Account() {}

    protected Account(Parcel in) {
        username = in.readString();
        email = in.readString();
        program = in.readString();
        course1 = in.readString();
        course2 = in.readString();
        course3 = in.readString();
        firstname = in.readString();
        lastname = in.readString();
        password = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(email);
        parcel.writeString(program);
        parcel.writeString(course1);
        parcel.writeString(course2);
        parcel.writeString(course3);
        parcel.writeString(firstname);
        parcel.writeString(lastname);
        parcel.writeString(password);

    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProgram() { return program; }

    public void setProgram(String program) { this.program = program; }

    public String getCourse1() { return course1; }

    public void setCourse1(String course1) { this.course1 = course1; }

    public String getCourse2() { return course2; }

    public void setCourse2(String course2) { this.course2 = course2; }

    public String getCourse3() { return course3; }

    public void setCourse3(String course3) { this.course3 = course3; }
}
