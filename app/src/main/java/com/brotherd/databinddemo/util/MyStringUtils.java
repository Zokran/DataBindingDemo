package com.brotherd.databinddemo.util;

public class MyStringUtils {

    public static String capitalize(String word) {
        if (word.length() > 1) {
            return word.toUpperCase();
        }
        return word;
    }
}