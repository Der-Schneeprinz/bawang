package com.merah.bawang.viewmodel.profilefragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.model.UserSelfProfileItem;
import com.merah.bawang.repository.ProfileRepository;

public class ViewModelProfileSelf extends AndroidViewModel {

    private static final String TAG = "ViewModelProfileSelf";
    private MutableLiveData<UserSelfProfileItem> liveData;

    public ViewModelProfileSelf(@NonNull Application application) {
        super(application);
        this.liveData = new MutableLiveData<>();

        init();
    }

    private void init() {
        if(liveData == null)
            return;
        ProfileRepository repo = ProfileRepository.getInstance();
        liveData = repo.getSelfProfile();
    }

    public MutableLiveData<UserSelfProfileItem> getProfile() {
        return liveData;
    }

}
