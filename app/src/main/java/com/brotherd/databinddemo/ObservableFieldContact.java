package com.brotherd.databinddemo;

import android.databinding.ObservableField;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class ObservableFieldContact {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> phone = new ObservableField<>();

    public ObservableFieldContact(String name, String phone) {
        this.name.set(name);
        this.phone.set(phone);
    }

}
