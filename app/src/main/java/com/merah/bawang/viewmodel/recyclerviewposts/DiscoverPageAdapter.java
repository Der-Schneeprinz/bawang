package com.merah.bawang.viewmodel.recyclerviewposts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.merah.bawang.view.homescreen.fragments.DiscoverFragment;
import com.merah.bawang.view.homescreen.fragments.OrgsFragment;
import com.merah.bawang.view.homescreen.fragments.PostsFragment;
import com.merah.bawang.view.homescreen.fragments.ProfileFragment;

import java.util.ArrayList;

public class DiscoverPageAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();

    public DiscoverPageAdapter(@NonNull DiscoverFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PostsFragment();
            case 1:
                return new OrgsFragment();
            case 2:
                return new ProfileFragment();
        }
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public void setData(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

}
