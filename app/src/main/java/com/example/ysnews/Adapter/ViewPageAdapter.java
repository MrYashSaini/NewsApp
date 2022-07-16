package com.example.ysnews.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList =new ArrayList<>();
    private ArrayList<String>fragmentTitle = new ArrayList<>();

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {super(fm, behavior);}

    @NonNull
    @Override
    public Fragment getItem(int position) {return arrayList.get(position);}

    @Override
    public int getCount() {return arrayList.size();}

    public void addFragment(Fragment fragment,String title){
        arrayList.add(fragment);
        fragmentTitle.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
