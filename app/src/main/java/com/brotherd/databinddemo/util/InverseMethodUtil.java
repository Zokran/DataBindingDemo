package com.brotherd.databinddemo.util;

import android.databinding.InverseMethod;

/**
 * Created by dumingwei on 2018/2/11 0011.
 * 使用@InverseMethod定义转换方法
 */

public class InverseMethodUtil {


    public static String stringToOrderType(String value) {
        if (value == null) {
            return null;
        }
        switch (value) {
            case "立即单":
                return "1";
            case "预约单":
                return "2";
            case "接机单":
                return "3";
            case "送机单":
                return "4";
            case "半日租单":
                return "5";
            case "全日租单":
                return "6";
            default:
                return null;
        }
    }

    @InverseMethod("stringToOrderType")
    public static String orderTypeToString(String code) {
        if (code == null) {
            return null;
        }
        switch (code) {
            case "1":
                return "立即单";
            case "2":
                return "预约单";
            case "3":
                return "接机单";
            case "4":
                return "送机单";
            case "5":
                return "半日租单";
            case "6":
                return "全日租单";
            default:
                return null;
        }
    }
}
