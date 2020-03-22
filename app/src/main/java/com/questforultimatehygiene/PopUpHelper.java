package com.questforultimatehygiene;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

public class PopUpHelper {


    public void showQuestPopUp(FragmentActivity context, int exp, int questIcon, int background, int buttonBackground, int questTitleId, int questTitle, int questContentId, int questContent) {
        MainActivity.player.addExperience(exp);

        // get the current activity viewgroup
        ViewGroup viewGroup = context.findViewById(android.R.id.content);

        // Inflate the custom alert dialog xml
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.popup_quest, viewGroup, false);

        // Add custom content for the current Quest
        LinearLayout rootLayout = (LinearLayout) dialogView.findViewById(R.id.popup_quest_layout);
        rootLayout.setBackgroundDrawable(context.getResources().getDrawable(background));

        TextView questName = dialogView.findViewById(questTitleId);
        questName.setText(questTitle);
        TextView questDescription = dialogView.findViewById(questContentId);
        questDescription.setText(questContent);

        ImageView questImage = dialogView.findViewById(R.id.quest_image);
        questImage.setImageDrawable(context.getResources().getDrawable(questIcon));

        Button startQuest = dialogView.findViewById(R.id.start_quest_button);
        startQuest.setBackgroundResource(buttonBackground);
        startQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO dismiss the popup
                // TODO start the actual Quest
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
