package com.brotherd.databinddemo.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.brotherd.databinddemo.databinding.ItemBloglistBinding;

/**
 * Created by dumingwei on 2017/5/18.
 */
public class BlogListItem extends FrameLayout {

    ItemBloglistBinding binding;

    public BlogListItem(@NonNull Context context) {
        this(context, null);
    }

    public BlogListItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initInflate(context);
        initInstances();
    }

    private void initInflate(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = ItemBloglistBinding.inflate(inflater, this, true);
    }

    private void initInstances() {
        binding.tvTitle.setText("hello binding group");
    }
}
