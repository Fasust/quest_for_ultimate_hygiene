package com.questforultimatehygiene;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.questforultimatehygiene.model.Friends;

import java.util.ArrayList;

public class Leaderboard extends Activity {
    private ArrayList<Friends> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        friends.add(new Friends("Bernt Bauer", "Cleanliness Wizard", 256, R.drawable.boy));
        friends.add(new Friends("Lea Bascha", "Major Mopping", 100, R.drawable.woman_1));
        friends.add(new Friends("Hans Peter", "Mr. Propper", 23, R.drawable.boy_2));
        friends.add(new Friends("Marius Hausmann", "Putz Profi", 12, R.drawable.boy_3));
        friends.add(new Friends("Mariane Hausmann", "Sauberkeits Novize", 2, R.drawable.woman_2));

        ListView friendList = findViewById(R.id.friend_list_view);
        friendList.setAdapter(new FriendListAdapter(this, friends));



        TextView levelCounterView = findViewById(R.id.level_counter_on_friend_page);
        levelCounterView.setText(getIntent().getIntExtra(MainActivity.LEVEL_INTENT_ID, 0) + "");

        ProgressBar expBar = findViewById(R.id.friend_progress_bar);
        expBar.setProgress(getIntent().getIntExtra(MainActivity.EXP_INTENT_ID, 0));
        expBar.setMax(getIntent().getIntExtra(MainActivity.EXP_NEEDED_INTENT_ID, 100));
    }
}
