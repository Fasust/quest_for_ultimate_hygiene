package com.questforultimatehygiene;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.questforultimatehygiene.model.Quest;
import com.questforultimatehygiene.model.QuestList;
import com.questforultimatehygiene.model.TimedQuest;

import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Bathroom.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Bathroom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bathroom extends Fragment implements View.OnClickListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private boolean solvedGeheInsBadQuestOnce = false; // To fix a bug
    private TimedQuest haendeWaschen;
    private Quest geheInsBad;

    public ImageButton imageButton;

    private OnFragmentInteractionListener mListener;

    public Bathroom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bathroom.
     */

    public static Bathroom newInstance(String param1, String param2) {
        Bathroom fragment = new Bathroom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Save references to relevant quests within the Bathroom
        haendeWaschen = QuestList.getInstance().GetHaendeWaschen();
        geheInsBad = QuestList.getInstance().GetGeheInsBad();

        // A popup will be displayed that shows Quest 1 when the App is started
        TriggerGeheInsBadQuest();

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bathroom, container, false);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Wow! Schon 20 Klopapierrollen bei 'Quest for Ultimate Hygiene'");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

    }

    private void TriggerGeheInsBadQuest(){
        if(solvedGeheInsBadQuestOnce == true){
            return;
        }
        solvedGeheInsBadQuestOnce = true;
        System.out.println("Sie haben die Quest " + geheInsBad.getName() + " erfüllt!");
        MainActivity.player.addExperience(geheInsBad.getExperience());
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    /**
     * This is an example of how a timed quest would be called when a user clicks the button
     * The time between the two actions is determined and stored in the QuestList and TimedQuest classes
     */
    private void ExampleTimedQuestTrigger(){
        TimerTask greetUser = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello User");
            }
        };

        TimerTask sayGoodbyeToUser = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Goodbye User");
            }
        };

        /**
         * The first Task will be executed immediatley the second task after (now) 5 seconds
         */
        haendeWaschen.startActivity(greetUser, sayGoodbyeToUser);

    }



}
