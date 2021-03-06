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
                return new Bathroom();
            case 2:
                return new Kitchen();
            case 3:
                return new Library();
            case 4:
                return new WLanSettingScreen();
            default:
                return new Flur();
        }

        //TODO: complete Bus fragment implementation
    }

    @Override
    public int getCount() {
        return 6;
    }
}
