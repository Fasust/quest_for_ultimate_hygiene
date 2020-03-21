package com.questforultimatehygiene;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.questforultimatehygiene.model.Quest;
import com.questforultimatehygiene.model.QuestList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Flur.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Flur#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Flur extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Quest obstWaschen;

    private OnFragmentInteractionListener mListener;

    public Flur() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frontdoor.
     */

    public static Flur newInstance(String param1, String param2) {
        Flur fragment = new Flur();
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
        // Save references to relevant quests within the Flur
        obstWaschen = QuestList.getInstance().GetObstWaschen();

        // Inflate the layout for this fragment
        View frontdoorView =  inflater.inflate(R.layout.fragment_frontdoor, container, false);

        Button startButton = frontdoorView.findViewById(R.id.button_quest_frontdoor);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestPopUp();
            }
        });
        return frontdoorView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
/*        Button completeQuestButton =  getView().findViewById(R.id.quest_button_on_Home);

        completeQuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TriggerObstWaschenQuest();
            }
        });*/
    }

    private void showQuestPopUp() {
        MainActivity.player.addExperience(51);

        //before inflating the custom alert dialog layout, we will get the current activity viewgroup
        ViewGroup viewGroup = getActivity().findViewById(android.R.id.content);

        //then we will inflate the custom alert dialog xml that we created
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_quest, viewGroup, false);
        TextView questName = dialogView.findViewById(R.id.quest_name);
        questName.setText(R.string.quest_handwashing_title);
        TextView questDescription = dialogView.findViewById(R.id.quest_description);
        questDescription.setText(R.string.quest_handwashing_content);

        Button acceptQuest = dialogView.findViewById(R.id.start_quest_button);
        acceptQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO start the actual Quest
            }
        });

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //setting the view of the builder to our custom view that we already inflated
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void TriggerObstWaschenQuest(){
        System.out.println("Sie haben die Quest " + obstWaschen.getName() + " erfüllt!");
        MainActivity.player.addExperience(obstWaschen.getExperience());
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
