package com.questforultimatehygiene;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.questforultimatehygiene.model.OnLevelUp;
import com.questforultimatehygiene.model.Player;


public class QuestDetail extends AppCompatActivity {
    Player player = new Player(new OnLevelUp(){
        @Override
        public void onLevelUp(){
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_detail);

        //Load UI
        Button completeQuestButton = findViewById(R.id.complete_quest_button);
        final ProgressBar progressBar = findViewById(R.id.progressBar2);

        //Attach Listeners
        completeQuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.addExperience(10);
                progressBar.setMax(player.getExpNeededTillLevelUp());
                progressBar.setProgress(player.getExp());
            }
        });

    }

}
