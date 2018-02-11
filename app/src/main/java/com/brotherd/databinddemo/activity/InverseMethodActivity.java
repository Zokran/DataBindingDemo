package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActivityInverseMethodBinding;

/**
 * 实现不了双向绑定啊
 */
public class InverseMethodActivity extends AppCompatActivity {


    public static void launch(Context context) {
        Intent intent = new Intent(context, InverseMethodActivity.class);
        context.startActivity(intent);
    }

    private String orderTypeCode;
    private ActivityInverseMethodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inverse_method);
        orderTypeCode = "1";
        binding.setOrderTypeCode(orderTypeCode);
    }

    public void click(View view) {
        Toast.makeText(this, orderTypeCode, Toast.LENGTH_SHORT).show();
    }
}
