package com.brotherd.databinddemo.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by dumingwei on 2017/10/23.
 */

@BindingMethods({@BindingMethod(type = android.widget.ImageView.class,
        attribute = "android:tint",
        method = "setImageTintList")})
public class MyImageView extends ImageView {

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void test() {

    }
}
