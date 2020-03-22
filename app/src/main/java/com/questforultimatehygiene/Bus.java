package com.questforultimatehygiene;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bus#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bus extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Bus() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bus.
     */
    // TODO: Rename and change types and number of parameters
    public static Bus newInstance(String param1, String param2) {
        Bus fragment = new Bus();
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
        // Inflate the layout for this fragment
        View view = inflateFragmentLayout(inflater, container);
        return view;
    }
    private View inflateFragmentLayout(LayoutInflater inflater, ViewGroup container) {
        View busView =  inflater.inflate(R.layout.fragment_bus, container, false);

        Button startButton = (Button)busView.findViewById(R.id.button_quest_bus);
        setOnClickForStartQuestButton(startButton);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.bounce);
        startButton.startAnimation(animation);
        return busView;
    }

    private void setOnClickForStartQuestButton(Button startButton) {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopUpHelper().showQuestPopUp(
                        getActivity(),51, R.drawable.hand_wash_with_bottle,
                        R.drawable.popup_background_roundedcorners_blue,
                        R.drawable.button_background_roundedcorners_lightblue,
//                        R.style.Colored_Button_LightBlue,
                        R.id.quest_name, R.string.quest_handwashing_title,
                        R.id.quest_description, R.string.quest_handwashing_content);
            }
        });
    }
}
