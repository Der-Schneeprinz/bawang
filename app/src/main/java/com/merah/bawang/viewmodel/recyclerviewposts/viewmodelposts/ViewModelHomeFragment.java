package com.merah.bawang.viewmodel.recyclerviewposts.viewmodelposts;

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
    private MutableLiveData<ArrayList<PostRVItem>> liveData;
    private final MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public ViewModelHomeFragment(@NonNull Application application) {
        super(application);
        liveData = new MutableLiveData<>();

        init();
    }

    public void init() {
        Log.i(TAG, "init has been called");
        if(liveData == null)
            return;
        PostRepository repo = PostRepository.getInstance();
        liveData = repo.getPosts();
    }

    public MutableLiveData<ArrayList<PostRVItem>> getAllPosts() {
        return liveData;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
