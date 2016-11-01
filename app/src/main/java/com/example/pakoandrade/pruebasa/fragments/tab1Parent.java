package com.example.pakoandrade.pruebasa.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pakoandrade.pruebasa.MainActivity;
import com.example.pakoandrade.pruebasa.R;

/**
 * Created by pakoAndrade on 01/11/16.
 */

public class tab1Parent extends android.support.v4.app.Fragment {
    TabLayout tabs;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_layout_1, container, false);

        tabs = (TabLayout) view.findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("Bares"));
        tabs.addTab(tabs.newTab().setText("BeachClub"));
        tabs.addTab(tabs.newTab().setIcon(R.mipmap.ic_launcher));

        viewPager = (ViewPager) view.findViewById(R.id.containerF);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        Pager2 adapterF = new Pager2(getFragmentManager(),tabs.getTabCount());

        viewPager.setAdapter(adapterF);

        tabs.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        // ...
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        // ...
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        // ...
                    }
                }
        );
        return  view;
    }

    public static class Pager2 extends FragmentPagerAdapter {

        //integer to count number of tabs
        int tabCount;

        //Constructor to the class
        public Pager2(FragmentManager fm, int tabCount) {
            super(fm);
            //Initializing tab count
            this.tabCount= tabCount;
        }

        //Overriding method getItem
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    MainActivity.Tab1 tab = new MainActivity.Tab1();
                    return tab;
                case 1:
                    MainActivity.Tab2 tab2 = new MainActivity.Tab2();
                    return tab2;
                case 2:
                    MainActivity.Tab3 tab3 = new MainActivity.Tab3();
                    return tab3;
                default:
                    return null;
            }
        }

        //Overriden method getCount to get the number of tabs
        @Override
        public int getCount() {
            return tabCount;
        }
    }
}
