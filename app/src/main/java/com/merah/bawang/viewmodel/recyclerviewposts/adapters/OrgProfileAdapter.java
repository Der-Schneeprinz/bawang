package com.merah.bawang.viewmodel.recyclerviewposts.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.merah.bawang.view.profiles.fragments.OrgMembersFragment;
import com.merah.bawang.view.profiles.fragments.OrgPostsFragment;

import java.util.ArrayList;

public class OrgProfileAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments = new ArrayList<>();

    public OrgProfileAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                new OrgMembersFragment();
                break;
            case 1:
                new OrgPostsFragment();
                break;
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
