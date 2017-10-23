package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.adapter.RvAdapter;
import com.brotherd.databinddemo.databinding.ActivityRecyclerViewBinding;
import com.brotherd.databinddemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private ActivityRecyclerViewBinding binding;
    private RvAdapter adapter;
    private List<User> userList;

    public static void launch(Context context) {
        Intent starter = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setHasFixedSize(true);
        userList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User("firstName" + i, "lastName" + i, i);
            userList.add(user);
        }
        adapter = new RvAdapter(userList, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }
}
