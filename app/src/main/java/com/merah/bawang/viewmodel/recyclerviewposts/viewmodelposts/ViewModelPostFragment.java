package com.merah.bawang.viewmodel.recyclerviewposts.viewmodelposts;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.model.PostRVItem;
import com.merah.bawang.repository.PostRepository;

import java.util.ArrayList;

public class ViewModelPostFragment extends AndroidViewModel {

    private static final String TAG = "ViewModelPostFragment";
    private MutableLiveData<ArrayList<PostRVItem>> liveDataPosts;
    private final MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public ViewModelPostFragment(@NonNull Application application) {
        super(application);
        this.liveDataPosts = new MutableLiveData<>();

        init();
    }

    public void init() {
        Log.i(TAG, "init has been called");
        if(liveDataPosts == null)
            return;
        PostRepository repo = PostRepository.getInstance();
        liveDataPosts = repo.getPosts();
    }

    public MutableLiveData<ArrayList<PostRVItem>> getAllPosts() {
        return liveDataPosts;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }


    public MutableLiveData<ArrayList<PostRVItem>> filterList(String text) {
        ArrayList<PostRVItem> postFiltered = new ArrayList<>();
        // TODO: postRVItems is empty figure out when in the lifecycle is it going to call the onBindViewHolder
        Log.i(TAG, "filteredList has been called");
        for(PostRVItem post : liveDataPosts.getValue()) {
            if(post.getFullName().toLowerCase().contains(text.toLowerCase())){
                postFiltered.add(post);
            } else if(post.getPostTitle().toLowerCase().contains(text.toLowerCase())) {
                postFiltered.add(post);
            }
        }
        return new MutableLiveData<>(postFiltered);
    }
    private void updateFilteredList(MutableLiveData<ArrayList<PostRVItem>> postFiltered) {
        this.liveDataPosts = postFiltered;
    }

}
