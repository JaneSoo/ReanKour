package com.example.janesoo.reankour.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.janesoo.reankour.fragment.FragmentSubject;
import com.example.janesoo.reankour.fragment.FragmentTutor;
import com.example.janesoo.reankour.fragment.FragmentVideo;

/**
 * Created by JaneSoo on 18-Jun-17.
 */

public class BottomNavigationPagerAdapter extends FragmentStatePagerAdapter {
    public BottomNavigationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new FragmentTutor();
        }
        else if(position == 1){
            return new FragmentSubject();
        }
        else
        {
            return new FragmentVideo();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
