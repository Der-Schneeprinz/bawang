package com.merah.bawang.viewmodel.recyclerviewprofile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.model.UserRVItem;
import com.merah.bawang.repository.ProfileRepository;

import java.util.ArrayList;

public class ViewModelProfilesFragment extends AndroidViewModel {

    private static final String TAG = "ViewModelProfileFragment";
    private MutableLiveData<ArrayList<UserRVItem>> liveData;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public ViewModelProfilesFragment(@NonNull Application application) {
        super(application);
        this.liveData = new MutableLiveData<>();

        init();
    }

    private void init() {
        if(liveData == null)
            return;
        ProfileRepository repo = ProfileRepository.getInstance();
        liveData = repo.getProfiles();
    }

    public MutableLiveData<ArrayList<UserRVItem>> getAllProfiles() {
        return liveData;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }

}
