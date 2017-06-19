package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.janesoo.reankour.fragment.BottomNavigationFragment;

/**
 * Created by JaneSoo on 17-Jun-17.
 */

public class AllBottomNavigationViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);
        getSupportFragmentManager().beginTransaction().add(R.id.main,new BottomNavigationFragment()).commit();
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        adapter = new AppPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);
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

        }

        if(item.getItemId() == R.id.setting){


        }

        if(item.getItemId() == R.id.logout){
            Intent intent = new Intent(AllBottomNavigationViewActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
