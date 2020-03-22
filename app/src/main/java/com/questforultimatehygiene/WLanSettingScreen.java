package com.questforultimatehygiene;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class WLanSettingScreen extends Fragment {

    public WLanSettingScreen(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wlan,container,false);
        ListView simpleList;
        final String wLanList[] = {"Pretty fly for a Wifi", "Home-WLAN", "FBI van", "Click Here for Wifi", "Get off my LAN", "Password is 1234"};

        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        WLanAdapter customAdapter = new WLanAdapter(getActivity(), wLanList);
        simpleList.setAdapter(customAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WLanSettingScreen.this.getContext(),"WLAN gesetzt: " + wLanList[position],Toast.LENGTH_LONG).show();
                Intent explicitIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(explicitIntent);
            }
        });

        return view;
    }
}
