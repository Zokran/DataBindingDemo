package com.brotherd.databinddemo.util;

import android.content.Context;

import com.brotherd.databinddemo.R;

public class MyStringUtils {

    public static String capitalize(String word) {
        if (word.length() > 1) {
            return word.toUpperCase();
        }
        return word;
    }

    public static String loadString(Context context) {
        return context.getString(R.string.app_name);
    }
}