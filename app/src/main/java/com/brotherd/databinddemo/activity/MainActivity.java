package com.brotherd.databinddemo.activity;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.brotherd.databinddemo.BR;
import com.brotherd.databinddemo.ObservableContact;
import com.brotherd.databinddemo.ObservableFieldContact;
import com.brotherd.databinddemo.R;
import com.brotherd.databinddemo.databinding.ActMainBind;
import com.brotherd.databinddemo.handler.EventHandler;
import com.brotherd.databinddemo.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActMainBind binding;
    private User user;
    private EventHandler handler;
    private List<User> userList;
    private ObservableContact observableContact;
    private ObservableFieldContact fieldContact;
    private ObservableMap<String, String> stringMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User("du", "mingwei", 25);
        handler = new EventHandler(this);
        userList = new ArrayList<>();
        userList.add(new User("user1", "user1", 1));
        userList.add(new User("user2", "user2", 2));
        binding.setUser(user);
        binding.setContent("hello content");
        binding.setHandler(handler);
        binding.setUserList(userList);
        observableContact = new ObservableContact("police", "110");
        observableContact.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.name) {
                    Toast.makeText(MainActivity.this, "name changed",
                            Toast.LENGTH_SHORT).show();
                } else if (propertyId == BR.phone) {
                    Toast.makeText(MainActivity.this, "phone changed",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        fieldContact = new ObservableFieldContact("me", "15764225790");
        stringMap = new ObservableArrayMap<>();
        stringMap.put("string1", "第一string");
        stringMap.put("string2", "第2个string");
        binding.setContact(observableContact);
        //binding.setContactField(fieldContact);
        binding.setStringMap(stringMap);
    }

    public void changeContact(View view) {
        observableContact.setName("doctor");
        observableContact.setPhone("120");
    }

    public void changeContactField(View view) {
        fieldContact.name.set("her");
        fieldContact.phone.set("15764225744");
    }

    public void changeStringMap(View view) {
        stringMap.put("string1", "hello boy");
        stringMap.put("string2", "hello girl");
    }

    public void viewStubBinding(View view) {
        ViewStubActivity.launch(this);
    }

    public void recyclerViewBind(View view) {
        RecyclerViewActivity.launch(this);
    }

    public void attributeSetter(View view) {
        AttributeSetterActivity.launch(this);
    }

}
