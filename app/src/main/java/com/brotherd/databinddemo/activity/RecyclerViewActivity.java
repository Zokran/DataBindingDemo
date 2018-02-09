package com.brotherd.databinddemo.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.adapter.RvAdapter;
import com.brotherd.databinddemo.databinding.ActivityRecyclerViewBinding;
import com.brotherd.databinddemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();

    private ActivityRecyclerViewBinding binding;
    private RvAdapter adapter;
    private ObservableArrayList<User> userList;

    public static void launch(Context context) {
        Intent starter = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        binding.recyclerView.setHasFixedSize(true);
        userList = new ObservableArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User("firstName" + i, "lastName" + i, i);
            userList.add(user);
        }
        adapter = new RvAdapter(userList, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    public void addData(View view) {
        Log.e(TAG, "addData: ");
        for (int i = 2; i < 4; i++) {
            User user = new User("firstName" + i, "lastName" + i, i);
            userList.add(user);
        }
        adapter.notifyDataSetChanged();
    }
}
