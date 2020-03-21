package com.questforultimatehygiene;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Flur();
            case 1:
                return new Kitchen();
            case 2:
                return new Bathroom();
            case 3:
                return new Library();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
