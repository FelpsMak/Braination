package com.example.brainationproject;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class PageAdapter extends FragmentPagerAdapter{
    private int num0fTabs;

    PageAdapter(FragmentManager fm, int num0fTabs){
        super(fm);
        this.num0fTabs = num0fTabs;
    }

    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                return new AtividadesFragment();
            case 1:
                return new AvisosFragment();
            case 2:
                return new ProvasFragment();
            default:
                return null;
        }
    }
    @Override
    public int getCount(){ return num0fTabs; }
}
