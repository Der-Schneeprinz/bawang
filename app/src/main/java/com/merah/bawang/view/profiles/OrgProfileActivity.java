package com.merah.bawang.view.profiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.recyclerviewposts.adapters.OrgProfileAdapter;

import java.util.Objects;

public class OrgProfileActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_org_profile);

        // TABS
        tabLayout = findViewById(R.id.tabsLayout);
        viewPager2 = findViewById(R.id.vpTab);
        OrgProfileAdapter adapter = new OrgProfileAdapter(this);
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
    }
}