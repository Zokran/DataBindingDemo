package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActivityFragBinding;
import com.brotherd.databinddemo.fragment.DataBindFragment;

public class FragActivity extends AppCompatActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, FragActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFragBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_frag);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, DataBindFragment.newInstance()).commit();
    }
}
