package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.janesoo.reankour.fragment.FragmentSubject;
import com.example.janesoo.reankour.fragment.FragmentTutor;
import com.example.janesoo.reankour.fragment.FragmentVideo;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class AllTabViewActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment[] fragments = new Fragment[3];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view_layout);

        tabLayout = (TabLayout) findViewById(R.id.tab_home);
        viewPager = (ViewPager) findViewById(R.id.viewpager_home);

        FragmentTutor fragmentTutor = new FragmentTutor();
        fragments[0] = fragmentTutor;

        FragmentSubject fragmentSubject = new FragmentSubject();
        fragments[1] = fragmentSubject;

        FragmentVideo fragmentVideo = new FragmentVideo();
        fragments[2] = fragmentVideo;

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new MyPagerAdapter());


    }
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(){
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title ="";
            switch (position){
                case 0:title="Tutors";
                    break;
                case 1:title="Subjects";
                    break;
                case 2:title="Videos";
            }
            return title;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.myprofile){

//            ActionBar actionBar = getSupportActionBar();
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayShowHomeEnabled(true);

        }

        if(item.getItemId() == R.id.setting){

//            ActionBar actionBar = getSupportActionBar();
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setDisplayShowHomeEnabled(true);

        }

        if(item.getItemId() == R.id.logout){
            Intent intent = new Intent(AllTabViewActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
