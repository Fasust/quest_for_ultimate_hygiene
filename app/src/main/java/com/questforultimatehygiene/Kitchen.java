package com.questforultimatehygiene;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Kitchen.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Kitchen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Kitchen extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Kitchen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Kitchen.
     */
    public static Kitchen newInstance(String param1, String param2) {
        Kitchen fragment = new Kitchen();
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
        return inflateFragmentLayout(inflater, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }


    private View inflateFragmentLayout(LayoutInflater inflater, ViewGroup container) {
        View kitchenView = inflater.inflate(R.layout.fragment_kitchen, container, false);

        Button startButton = kitchenView.findViewById(R.id.button_quest_kitchen);
        setOnClickForStartQuestButton(startButton);
        return kitchenView;
    }

    private void setOnClickForStartQuestButton(Button startButton) {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopUpHelper().showQuestPopUp(
                        getActivity(), 51, R.drawable.sneezing,
                        R.drawable.popup_background_roundedcorners_yellow,
                        R.drawable.button_background_roundedcorners_darkblue,
//                        R.style.Colored_Button_Blue,
                        R.id.quest_name, R.string.quest_sneezing_title,
                        R.id.quest_description, R.string.quest_sneezing_content);
            }
        });
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
