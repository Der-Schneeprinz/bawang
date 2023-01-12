package com.merah.bawang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<ItemPostContent> itemPostContent = new ArrayList<ItemPostContent>();
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        setUpItemPostContent();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, itemPostContent);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpItemPostContent() {
        // conUsername
        String[] postUsername = getResources().getStringArray(R.array.saUsernames);
        String[] postOrg = getResources().getStringArray(R.array.saOrgs);
        for(int i = 0; i < postUsername.length;i++){
            itemPostContent.add(new ItemPostContent(
                    postUsername[i],
                    postOrg[i%2],
                    getResources().getString(R.string.postText),
                    getResources().getString(R.string.postTitle),
                    "0",
                    "0",
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }
}