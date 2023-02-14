package com.merah.bawang.viewmodel.homescreen.fragments;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.model.PostRVItem;
import com.merah.bawang.repository.PostRepository;

import java.util.ArrayList;

public class ViewModelHomeFragment extends AndroidViewModel {

    private static final String TAG = "ViewModelHomeFragment";
    private MutableLiveData<ArrayList<PostRVItem>> liveDataPosts;
    private final MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public ViewModelHomeFragment(@NonNull Application application) {
        super(application);
        liveDataPosts = new MutableLiveData<>();

        init();
    }

    public void init() {
        if(liveDataPosts == null)
            return;
        PostRepository repo = PostRepository.getInstance();
        Log.i(TAG, "init has been called");
        liveDataPosts = repo.getPosts();
    }

    public MutableLiveData<ArrayList<PostRVItem>> getAllPosts() {
        return liveDataPosts;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
