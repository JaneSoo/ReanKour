package com.example.janesoo.reankour.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.janesoo.reankour.AllBottomNavigationViewActivity;
import com.example.janesoo.reankour.R;
import com.example.janesoo.reankour.adapter.BottomNavigationPagerAdapter;

/**
 * Created by JaneSoo on 18-Jun-17.
 */

public class BottomNavigationFragment extends Fragment{
    private BottomNavigationPagerAdapter adapter;
    private MenuItem prevMenuItem;
    private AllBottomNavigationViewActivity activity;
    private BottomNavigationView bottomNavigationView;
    private ViewPager pager;

    //communicate with activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (AllBottomNavigationViewActivity) context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_view_layout,container,false);
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.botton_navigation);
        pager = (ViewPager) view.findViewById(R.id.viewpager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new BottomNavigationPagerAdapter(getFragmentManager());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ActionBar actionBar = activity.getSupportActionBar();
                if(item.getItemId() == R.id.tutor){
                    pager.setCurrentItem(0);
                    actionBar.setTitle("Tutor");
                }
                else if(item.getItemId()==R.id.subject){
                    pager.setCurrentItem(1);
                    actionBar.setTitle("Subject");
                }
                else {
                    pager.setCurrentItem(2);
                    actionBar.setTitle("Content");
                }
                return false;
            }
        });



        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem != null){
                    prevMenuItem.setChecked(false);
                }else{
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }

                if(position== 0){
                    activity.setTitle("Tutor");
                }
                else if(position == 1){
                    activity.setTitle("Subject");
                }
                else {
                    activity.setTitle("Content");
                }

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
