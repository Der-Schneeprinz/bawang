package com.merah.bawang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<ItemPostContent>  itemPostcontents = new ArrayList<ItemPostContent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    private void setUpItemPostContent() {
        //I think this should be changed to a queue system(?)
        String[] postUsernames = getResources().getStringArray(R.array.saUsernames);
        String[] postOrgs = getResources().getStringArray(R.array.saOrgs);
        String[] postTexts = getResources().getStringArray(R.array.saPosts);
        String[] postTitles = getResources().getStringArray(R.array.saTitle);

        //This is supposed to be sql query
        for(int i = 0; i < postUsernames.length; i++ ) {
            itemPostcontents.add(new ItemPostContent(
                    postUsernames[i],
                    postOrgs[i%2],
                    postTexts[0],
                    postTitles[0],
                    "0",
                    "0",
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }
}