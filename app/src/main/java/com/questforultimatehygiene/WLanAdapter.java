package com.questforultimatehygiene;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WLanAdapter extends BaseAdapter {
    Context context;
    String wLanList[];
    LayoutInflater inflter;

    public WLanAdapter(Context applicationContext, String[] wLanList) {
        this.context = context;
        this.wLanList = wLanList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return wLanList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        country.setText(wLanList[i]);
        return view;
    }
}

