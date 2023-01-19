package com.merah.bawang;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.merah.bawang.homescreen.fragments.OrgsFragment;
import com.merah.bawang.homescreen.fragments.PostsFragment;
import com.merah.bawang.homescreen.fragments.ProfileFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
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
        return new PostsFragment();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
