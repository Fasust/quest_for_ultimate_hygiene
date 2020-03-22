package com.questforultimatehygiene;

import android.content.Intent;
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
 * {@link Library.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Library#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Library extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Library() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Library.
     */
    // TODO: Rename and change types and number of parameters
    public static Library newInstance(String param1, String param2) {
        Library fragment = new Library();
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
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        Button btnLib1 = (Button)view.findViewById(R.id.btnLib1);
        Button btnLib2 = (Button)view.findViewById(R.id.btnLib2);
        Button btnLib3 = (Button)view.findViewById(R.id.btnLib3);
        Button btnLib4 = (Button)view.findViewById(R.id.btnLib4);
        Button btnLib5 = (Button)view.findViewById(R.id.btnLib5);
        Button btnLib6 = (Button)view.findViewById(R.id.btnLib6);
        Button btnLib7 = (Button)view.findViewById(R.id.btnLib7);
        btnLib1.setOnClickListener(this);
        btnLib2.setOnClickListener(this);
        btnLib3.setOnClickListener(this);
        btnLib4.setOnClickListener(this);
        btnLib5.setOnClickListener(this);
        btnLib6.setOnClickListener(this);
        btnLib7.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLib1:
                String url = "https://grippeweb.rki.de/Images/Hygienetipps.png";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.btnLib2:
                String url2 = "https://grippeweb.rki.de/Info.aspx";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);
                break;
            case R.id.btnLib3:
                String url3 = "https://www.infektionsschutz.de/haendewaschen.html";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                break;
            case R.id.btnLib4:
                String url4 = "https://www.infektionsschutz.de/hygienetipps/hygiene-beim-husten-und-niesen.html";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                break;
            case R.id.btnLib5:
                String url5 = "https://www.infektionsschutz.de/mediathek/filme/filme-fuer-kinder.html";
                Intent i5 = new Intent(Intent.ACTION_VIEW);
                i5.setData(Uri.parse(url5));
                startActivity(i5);
                break;
            case R.id.btnLib6:
                String url6 = "https://www.infektionsschutz.de/coronavirus/";
                Intent i6 = new Intent(Intent.ACTION_VIEW);
                i6.setData(Uri.parse(url6));
                startActivity(i6);
                break;
            case R.id.btnLib7:
                String url7 = "https://www.youtube.com/playlist?list=PLRsi8mtTLFAyJaujkSHyH9NqZbgm3fcvy";
                Intent i7 = new Intent(Intent.ACTION_VIEW);
                i7.setData(Uri.parse(url7));
                startActivity(i7);
                break;
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
