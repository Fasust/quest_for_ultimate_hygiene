package com.questforultimatehygiene;

import android.app.AlertDialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class PopUpHelper {


    public void showQuestPopUp(final FragmentActivity context, int exp, int questIcon, int background, int questTitleId, final int questTitle, int questContentId, int questContent) {
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

        final Button startQuest = dialogView.findViewById(R.id.start_quest_button);
        final TextView timer_textView = (TextView) dialogView.findViewById(R.id.timer_textView);
        final ProgressBar progressBar = (ProgressBar) dialogView.findViewById(R.id.progressBar);

        final FragmentActivity fin_context = context;
        startQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO dismiss the popup
                // TODO start the actual Quest
                if (questTitle == R.string.quest_handwashing_title) {
                    startQuest.setVisibility(View.INVISIBLE);
                    timer_textView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    startCountdownTimer(timer_textView, context, progressBar);
                }
            }
        });



        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public void startCountdownTimer(final TextView timer, final Context context, final ProgressBar progressBar) {
        CountDownTimer handwashing_timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                if (l < 10000) {
                    timer.setText("00:0"+l / 1000);
                    progressBar.setProgress(100 - ((int)l / 1000) * 3);
                }
                else {
                    timer.setText("00:"+l / 1000);
                    progressBar.setProgress(100 - ((int)l / 1000) * 3);
                }

            }

            @Override
            public void onFinish() {

                CharSequence text = "Gut gemacht!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(1000);
                timer.setText("");
                progressBar.setVisibility(View.INVISIBLE);

            }
        }.start();
    }
}
