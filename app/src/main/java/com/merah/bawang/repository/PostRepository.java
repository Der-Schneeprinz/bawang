package com.merah.bawang.repository;

import android.content.res.Resources;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.R;
import com.merah.bawang.model.Post;
import com.merah.bawang.model.PostRVItem;

import java.util.ArrayList;

public class PostRepository {

    private static final String TAG = "PostRepository";
    private static PostRepository instance;
    private ArrayList<PostRVItem> postRVItems = new ArrayList<>();

    public static PostRepository getInstance() {
        if(instance == null)
            instance = new PostRepository();
        return instance;
    }

    public MutableLiveData<ArrayList<PostRVItem>> getPosts() {
        setPosts();
        MutableLiveData<ArrayList<PostRVItem>> postRVItems = new MutableLiveData<>();
        postRVItems.setValue(this.postRVItems);
        return postRVItems;
    }

    private void setPosts() {
        /*String[] postUsername = Resources.getSystem().getStringArray(R.array.saUsernames);
        String[] postOrg = Resources.getSystem().getStringArray(R.array.saOrgs);
        for(int i = 0; i < postUsername.length;i++){
            postRVItems.add(new PostRVItem(
                    new Post("", ""),
                    postUsername[i],
                    postOrg[i%2],
                    Resources.getSystem().getString(R.string.postText),
                    Resources.getSystem().getString(R.string.postTitle),
                    0,
                    R.drawable.ic_baseline_account_circle_24
            ));
        }*/
        Log.i(TAG, "setPosts has been called");
        String[] postUsername = {"John Doe", "Joan Doe", "Juan Dela Cruz", "Juana Dela Cruz", "Jean D'Arc", "Jeanne D'Arc"};
        String[] postOrg = {"PUP Sintang Pusa", "PUP Sintang Aso"};
        for(int i = 0; i < postUsername.length; i++) {
            postRVItems.add(new PostRVItem(
                    new Post("", ""),
                    postUsername[i],
                    postOrg[i%2],
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    "Sample Title",
                    0,
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }

}
