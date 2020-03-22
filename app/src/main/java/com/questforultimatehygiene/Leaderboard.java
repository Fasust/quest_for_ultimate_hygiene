package com.questforultimatehygiene;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Leaderboard extends Activity {
    private String[] users = { "Suresh Dasari", "Rohini Alavala", "Trishika Dasari", "Praveen Alavala", "Madav Sai", "Hamsika Yemineni"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        ListView friendList = findViewById(R.id.friend_list_view);
        ArrayAdapter friendAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        friendList.setAdapter(friendAdapter);
    }
}
