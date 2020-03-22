package com.questforultimatehygiene;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.questforultimatehygiene.model.QuestList;
import com.questforultimatehygiene.model.TimedQuest;


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
    // TODO fix this, Obstwaschen oder Handwaschen im Flur ??

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

        // Inflate the layout for this fragment
        return inflateFragmentLayout(inflater, container);
    }

    private View inflateFragmentLayout(LayoutInflater inflater, ViewGroup container) {
        View frontdoorView =  inflater.inflate(R.layout.fragment_frontdoor, container, false);

        Button startButton = frontdoorView.findViewById(R.id.button_quest_frontdoor);
        setOnClickForStartQuestButton(startButton);
        return frontdoorView;
    }

    private void setOnClickForStartQuestButton(Button startButton) {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopUpHelper().showQuestPopUp(
                        getActivity(),29, R.drawable.shopping_bag_nolines,
                        R.drawable.popup_background_roundedcorners_green,
                        R.id.quest_name, R.string.quest_grocery_shopping_title,
                        R.id.quest_description, R.string.quest_grocery_shopping_content);
            }
        });
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

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
