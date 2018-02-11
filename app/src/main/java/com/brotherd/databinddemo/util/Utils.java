package com.brotherd.databinddemo.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class Utils {

    private static final String TAG = "Utils";

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter(value = {"url", "error", "placeholder"}, requireAll = false)
    public static void testLoadImage(ImageView view, String url, Drawable error, Drawable placeHolder) {
        Log.e(TAG, "testLoadImage: ");
        Glide.with(view.getContext())
                .load(url)
                .apply(new RequestOptions().error(error).placeholder(placeHolder))
                .into(view);
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int paddingLeft) {
        view.setPadding(paddingLeft, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    @BindingAdapter("android:tint")
    public static void setTint(ImageView view, int paddingLeft) {
        //view.setImageTintList(new ColorStateList());
    }

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        return format.format(date);
    }

}
