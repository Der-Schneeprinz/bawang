package com.merah.bawang.viewmodel.recyclerviewposts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.merah.bawang.R;
import com.merah.bawang.model.Post;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Post>  itemPostcontents = new ArrayList<Post>();

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
            itemPostcontents.add(new Post(
                    postUsernames[i],
                    postOrgs[i%2],
                    postTexts[0],
                    postTitles[0],
                    0,
                    0,
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }
}