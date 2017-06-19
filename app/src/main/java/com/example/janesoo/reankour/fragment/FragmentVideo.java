package com.example.janesoo.reankour.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.janesoo.reankour.R;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class FragmentVideo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.all_fragment_layout,container,false);
        return myview;
    }
}
