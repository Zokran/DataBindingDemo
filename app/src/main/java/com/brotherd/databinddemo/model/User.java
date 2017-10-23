package com.brotherd.databinddemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableFloat;

/**
 * Created by dumingwei on 2017/5/18.
 */
public class User extends BaseObservable {

    private final String mFirstName;
    private final String mLastName;
    private int mAge;

    private ObservableFloat height = new ObservableFloat(1.0F);

    public User(String firstName, String lastName, int age) {
        mFirstName = firstName;
        mLastName = lastName;
        mAge = age;
    }

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    @Bindable
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
