package com.brotherd.databinddemo.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by dumingwei on 2017/5/19.
 */
public class Utils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter({"testImageUrl"})
    public static void testLoadImage(ImageView view, String url, String backUrl) {
        Glide.with(view.getContext())
                .load(url)
                .thumbnail(Glide.with(view.getContext()).load(backUrl))
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
}
