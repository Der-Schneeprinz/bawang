package com.merah.bawang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

public class TopBarMethods extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_top_bar);
    }

    ImageButton ibSearch = findViewById(R.id.ibSearch);
    ImageButton ibHome = findViewById(R.id.ibHome);
    ImageButton ibProfile = findViewById(R.id.ibProfile);


    private void toDiscoverActivity(View view) {
        // SEARCH is active
        ibSearch.setBackgroundResource(R.drawable.ic_baseline_search_24_active);
        // HOME and PROFILE is inactive
        ibHome.setBackgroundResource(R.drawable.ic_baseline_home_24_inactive);
        ibProfile.setBackgroundResource(R.drawable.ic_baseline_account_circle_24_inactive);

        Intent intent = new Intent(TopBarMethods.this, DiscoverActivity.class);
        startActivity(intent);
    }
    private void toHomeActivity(View view) {
        // HOME is active
        ibHome.setBackgroundResource(R.drawable.ic_baseline_home_24_active);
        // SEARCH and PROFILE is inactive
        ibSearch.setBackgroundResource(R.drawable.ic_baseline_search_24_inactive);
        ibProfile.setBackgroundResource(R.drawable.ic_baseline_account_circle_24_inactive);

        Intent intent = new Intent(TopBarMethods.this, HomeActivity.class);
        startActivity(intent);
    }
    private void toProfileActivity(View view) {
        // PROFILE is active
        ibProfile.setBackgroundResource(R.drawable.ic_baseline_account_circle_24_active);
        // SEARCH and HOME is inactive
        ibSearch.setBackgroundResource(R.drawable.ic_baseline_search_24_inactive);
        ibHome.setBackgroundResource(R.drawable.ic_baseline_home_24_inactive);

        Intent intent = new Intent(TopBarMethods.this, ProfileActivity.class);
        startActivity(intent);
    }

}
