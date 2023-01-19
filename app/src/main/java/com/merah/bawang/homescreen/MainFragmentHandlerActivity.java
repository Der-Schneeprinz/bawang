package com.merah.bawang.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.merah.bawang.R;
import com.merah.bawang.homescreen.fragments.DiscoverFragment;
import com.merah.bawang.homescreen.fragments.HomeFragment;
import com.merah.bawang.homescreen.fragments.ProfileFragment;

public class MainFragmentHandlerActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment;
    DiscoverFragment discoverFragment;
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment_handler);

        // Fragments
        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        profileFragment = new ProfileFragment();

        // navigation view
        bottomNavigationView = findViewById(R.id.bot_nav_bar);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.ibHome);

        /*
         * NOTIFICATIONS
         * BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.notifications);
         * badgeDrawable.setVisible(true);
         * badgeDrawable.setNumber(NULL);
         * */

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Toast.makeText(getApplicationContext(), "You are in the MainFragmentHandlerActivity", Toast.LENGTH_SHORT).show();
                switch (item.getItemId()) {
                    case R.id.itSearch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, discoverFragment).commit();
                        return true;

                    case R.id.itHome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                        return true;

                    case R.id.itProfile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                        return true;
                }
                Toast.makeText(getApplicationContext(), "NULL", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ibSearch:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                Toast.makeText(getApplicationContext(), "You pressed search1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ibHome:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, discoverFragment).commit();
                Toast.makeText(getApplicationContext(), "You pressed home1", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ibProfile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                Toast.makeText(getApplicationContext(), "You pressed profile1", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}