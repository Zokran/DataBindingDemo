package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.databinding.adapters.ViewBindingAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        ViewBindingAdapter.setClickListener(binding.imgClick, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttributeSetterActivity.this, "测试ViewBindingAdapter", Toast.LENGTH_SHORT).show();
            }
        }, true);

    }

    /**
     * 对TextView设置不同状态时其文字颜色。
     */
    private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }
}
