package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActivityAttributeSetterBinding;
import com.brotherd.databinddemo.model.User;

public class AttributeSetterActivity extends AppCompatActivity {

    private ActivityAttributeSetterBinding binding;

    public static void launch(Context context) {
        Intent starter = new Intent(context, AttributeSetterActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_attribute_setter);
        User user = new User("mingwei", "du", 26);
        binding.setUser(user);
        binding.setUrl("http://connorlin.github.io/images/avatar.jpg");
    }
}
