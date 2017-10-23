package com.brotherd.databinddemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.model.User;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class Card extends LinearLayout {

    private TextView textFirstName;
    private TextView textLastName;
    private TextView textAge;

    public Card(Context context) {
        this(context, null);
    }

    public Card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.card, this);
        setOrientation(VERTICAL);
        textFirstName = (TextView) findViewById(R.id.firstname);
        textLastName = (TextView) findViewById(R.id.lastname);
        textAge = (TextView) findViewById(R.id.age);
    }

    public void setObject(User user) {
        textFirstName.setText(user.getFirstName());
        textLastName.setText(user.getLastName());
        textAge.setText(String.valueOf(user.getAge()));

    }
}
