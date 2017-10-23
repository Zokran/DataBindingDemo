package com.brotherd.databinddemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class ObservableContact extends BaseObservable {

    private String name;
    private String phone;

    public ObservableContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }
}
