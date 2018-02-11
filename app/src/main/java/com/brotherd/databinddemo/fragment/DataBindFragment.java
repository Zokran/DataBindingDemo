package com.brotherd.databinddemo.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.FragmentDataBindBinding;
import com.brotherd.databinddemo.model.User;

import java.util.Date;

/**
 * Created by dumingwei on 2018/2/11 0011.
 * 在Fragment中使用 DataBinding ，Convert
 */

public class DataBindFragment extends Fragment {

    private final String TAG = getClass().getName();

    public static DataBindFragment newInstance() {
        Bundle args = new Bundle();

        DataBindFragment fragment = new DataBindFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDataBindBinding bindBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_bind, container, false);
        User user = new User("zhang", "san", 23);
        bindBinding.setData(user);
        bindBinding.setTime(new Date());
        return bindBinding.getRoot();
    }
}
