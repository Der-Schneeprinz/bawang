package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.widget.SearchView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.recyclervieworganizations.ViewModelOrgs;
import com.merah.bawang.viewmodel.recyclerviewposts.adapters.DiscoverPageAdapter;
import com.merah.bawang.viewmodel.recyclerviewposts.adapters.PostAdapter;
import com.merah.bawang.viewmodel.recyclerviewposts.viewmodelposts.ViewModelPostFragment;
import com.merah.bawang.viewmodel.recyclerviewprofile.ViewModelProfileFragment;

import java.util.ArrayList;
import java.util.Objects;

public class DiscoverFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private SearchView searchView;
    private DiscoverPageAdapter adapter;
    private ViewModelPostFragment vmPosts;
    private ViewModelOrgs vmOrgs;
    private ViewModelProfileFragment vmProfiles;

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
        adapter = new DiscoverPageAdapter(this);
        viewPager2.setAdapter(adapter);
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
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });

        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();

        vmOrgs = new ViewModelProvider(this).get(ViewModelOrgs.class);
        vmProfiles = new ViewModelProvider(this).get(ViewModelProfileFragment.class);
        PostAdapter postAdapter = new PostAdapter(getContext(), new ArrayList<>());
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                PostsFragment.getViewModel().filterList(newText).observe(getViewLifecycleOwner(), postAdapter::updatePosts);
                return true;
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
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PostsFragment());
        fragments.add(new OrgsFragment());
        fragments.add(new ProfileFragment());
        adapter.setData(fragments); //sets the data for the adapter
        viewPager2.setAdapter(adapter);
    }

}