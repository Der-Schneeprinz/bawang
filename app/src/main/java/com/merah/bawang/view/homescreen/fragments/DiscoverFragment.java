package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.recyclerviewposts.adapters.DiscoverPageAdapter;

import java.util.ArrayList;

public class DiscoverFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private SearchView searchView;
    private DiscoverPageAdapter discoverPageAdapter;
    private ArrayList<Fragment> fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        tabLayout = view.findViewById(R.id.tabsLayout);
        viewPager2 = view.findViewById(R.id.vpTab);
        discoverPageAdapter = new DiscoverPageAdapter(this);
        viewPager2.setAdapter(discoverPageAdapter);
        viewPager2.setSaveEnabled(false);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // Listens for the tab swipes
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Listens for the current tab which updates the cursor for the tabs
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                tabLayout.getTabAt(position).select();
            }
        });
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TabLayout tabLayout = view.findViewById(R.id.tabsLayout);
        String[] titles = {"Posts", "Organizations", "People"};
        setViewPagerAdapter();
        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(titles[position])
        ).attach();
    }
    public void setViewPagerAdapter() {
        DiscoverPageAdapter discoverPageAdapter = new DiscoverPageAdapter(this);
        fragments = new ArrayList<>();
        fragments.add(new PostsFragment());
        fragments.add(new OrgsFragment());
        fragments.add(new ProfileFragment());
        discoverPageAdapter.setData(fragments); //sets the data for the adapter
        viewPager2.setAdapter(discoverPageAdapter);
    }

}