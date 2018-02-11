package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.databinding.adapters.TextViewBindingAdapter;
import android.databinding.adapters.ViewBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActivityAttributeSetterBinding;
import com.brotherd.databinddemo.model.User;

public class AttributeSetterActivity extends AppCompatActivity {

    private ActivityAttributeSetterBinding binding;


    private TextViewBindingAdapter.BeforeTextChanged beforeTextChanged = new TextViewBindingAdapter.BeforeTextChanged() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //do something
        }
    };

    private TextViewBindingAdapter.OnTextChanged onTextChanged = new TextViewBindingAdapter.OnTextChanged() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //do something
        }
    };

    private TextViewBindingAdapter.AfterTextChanged afterTextChanged = new TextViewBindingAdapter.AfterTextChanged() {
        @Override
        public void afterTextChanged(Editable s) {
            //do something
        }
    };

    private ObservableField<String> twoWayBind = new ObservableField<>("双向绑定");


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
        ViewBindingAdapter.setClickListener(binding.imgClick, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttributeSetterActivity.this, "测试ViewBindingAdapter", Toast.LENGTH_SHORT).show();
            }
        }, true);
        binding.setVariable(BR.user, user);

        binding.setBeforeTextChanged(beforeTextChanged);
        binding.setOnTextChanged(onTextChanged);
        binding.setAfterTextChanged(afterTextChanged);
        binding.setTwoWayBind(twoWayBind);
    }

    public void testTwoWayBind(View view) {
        Toast.makeText(this, twoWayBind.get(), Toast.LENGTH_SHORT).show();
    }
}
