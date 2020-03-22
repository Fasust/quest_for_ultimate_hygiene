package com.questforultimatehygiene;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.questforultimatehygiene.model.Friends;

import java.util.ArrayList;

public class FriendListAdapter extends BaseAdapter {
    private ArrayList<Friends> listData;
    private LayoutInflater layoutInflater;

    public FriendListAdapter(Context aContext, ArrayList<Friends> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_tile, null);
            holder = new ViewHolder();
            holder.name =  v.findViewById(R.id.friend_name);
            holder.title = v.findViewById(R.id.friend_title);
            holder.level =  v.findViewById(R.id.friend_level_coutner);
            holder.avatar =  v.findViewById(R.id.friend_avatar);
            v.setTag(holder);

        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.name.setText(listData.get(position).getName());
        holder.title.setText(listData.get(position).getTitle());
        holder.level.setText(listData.get(position).getScore() + "");
        holder.avatar.setImageResource(listData.get(position).getAvatar());

        return v;
    }

    static class ViewHolder {
        TextView name;
        TextView title;
        TextView level;
        ImageView avatar;
    }
}