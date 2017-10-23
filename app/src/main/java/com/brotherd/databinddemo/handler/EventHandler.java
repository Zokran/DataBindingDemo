package com.brotherd.databinddemo.handler;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dumingwei on 2017/5/18.
 */
public class EventHandler {

    private Context context;

    public EventHandler(Context context) {
        this.context = context;
    }

    public void onClickFriend(String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

}
