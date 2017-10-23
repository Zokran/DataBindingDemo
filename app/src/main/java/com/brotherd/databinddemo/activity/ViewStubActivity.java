package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActivityViewStubBinding;
import com.brotherd.databinddemo.databinding.IncludeStubBinding;
import com.brotherd.databinddemo.model.User;

public class ViewStubActivity extends AppCompatActivity {

    private ActivityViewStubBinding binding;
    private User user;

    public static void launch(Context context) {
        Intent starter = new Intent(context, ViewStubActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                IncludeStubBinding binding = DataBindingUtil.bind(inflated);
                binding.setUser(user);
            }
        });
        user=new User("MingWei","Du",32);
    }

    public void inflate(View view) {
        if (!binding.viewStub.isInflated()) {
            binding.viewStub.getViewStub().inflate();
        }
    }

}
