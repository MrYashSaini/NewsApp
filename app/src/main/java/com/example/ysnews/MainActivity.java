package com.example.ysnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ysnews.Adapter.ViewPageAdapter;
import com.example.ysnews.Fragment.EntertainmentFragment;
import com.example.ysnews.Fragment.HealthFragment;
import com.example.ysnews.Fragment.HomeFragment;
import com.example.ysnews.Fragment.ScienceFragment;
import com.example.ysnews.Fragment.SportsFragment;
import com.example.ysnews.Fragment.TechFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);


        //set Tab layout on view pager
        tabLayout.setupWithViewPager(viewPager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragment(new HomeFragment(),"Home");
        viewPageAdapter.addFragment(new SportsFragment(),"Sports");
        viewPageAdapter.addFragment(new HealthFragment(),"Health");
        viewPageAdapter.addFragment(new ScienceFragment(),"Science");
        viewPageAdapter.addFragment(new TechFragment(),"Technology");
        viewPageAdapter.addFragment(new EntertainmentFragment(),"Entertainment");
        viewPager.setAdapter(viewPageAdapter);



    }

}