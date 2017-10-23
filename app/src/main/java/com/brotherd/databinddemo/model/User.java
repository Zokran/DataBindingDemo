package com.brotherd.databinddemo.model;

/**
 * Created by dumingwei on 2017/5/18.
 */
public class User {

    private final String mFirstName;
    private final String mLastName;
    private int mAge;

    public User(String firstName, String lastName, int age) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getAge() {
        return mAge;
    }

    @Override
    public String toString() {
        return "firstName:" + mFirstName + ",lastName:" + mLastName;
    }
}
