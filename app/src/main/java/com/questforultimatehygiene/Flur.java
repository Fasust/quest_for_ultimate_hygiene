package com.questforultimatehygiene;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;


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
     * @return A new instance of fragment Flur.
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
        View view = inflateFragmentLayout(inflater, container);
        Button button_quest_flur = (Button)view.findViewById(R.id.button_quest_flur);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
        button_quest_flur.startAnimation(animation);
        Button button_quest_home = (Button)view.findViewById(R.id.button_quest_home);
        Animation animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.lefttoright);
        button_quest_home.startAnimation(animation2);
        return view;
    }

    private View inflateFragmentLayout(LayoutInflater inflater, ViewGroup container) {
        View flurView =  inflater.inflate(R.layout.fragment_flur, container, false);

        Button startButton = flurView.findViewById(R.id.button_quest_flur);
        setOnClickForStartQuestButton(startButton);

        Button welcomeHomeButton = flurView.findViewById(R.id.button_quest_home);
        setOnClickForWelcomeHomeButton(welcomeHomeButton);
        return flurView;
    }

    private void setOnClickForStartQuestButton(Button startButton) {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopUpHelper().showQuestPopUp(
                        getActivity(),29, R.drawable.shopping_bag,
                        R.drawable.popup_background_roundedcorners_green,
                        R.drawable.button_background_roundedcorners_orange,
//                        R.style.Colored_Button_Orange,
                        R.id.quest_name, R.string.quest_grocery_shopping_title,
                        R.id.quest_description, R.string.quest_grocery_shopping_content);
            }
        });
    }

    private void setOnClickForWelcomeHomeButton(Button welcomeHomeButton) {
        welcomeHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopUpHelper().showQuestPopUp(
                        getActivity(),29, R.drawable.doormat,
                        R.drawable.popup_background_roundedcorners_beige,
                        R.drawable.button_background_roundedcorners_brown,
//                        R.style.Colored_Button_Orange,
                        R.id.quest_name, R.string.quest_welcome_home_title,
                        R.id.quest_description, R.string.quest_welcome_home_content);
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
