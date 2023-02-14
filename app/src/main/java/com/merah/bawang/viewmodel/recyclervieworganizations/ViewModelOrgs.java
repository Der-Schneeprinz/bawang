package com.merah.bawang.viewmodel.recyclervieworganizations;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.model.OrganizationRVItem;
import com.merah.bawang.repository.OrgsRepository;

import java.util.ArrayList;

public class ViewModelOrgs extends AndroidViewModel {

    private static final String TAG = "ViewModelOrgs";
    private MutableLiveData<ArrayList<OrganizationRVItem>> liveData;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    public ViewModelOrgs(@NonNull Application application) {
        super(application);
        liveData = new MutableLiveData<>();

        init();
    }

    public void init() {
        Log.i(TAG, "init has been called");
        if(liveData == null)
            return;
        OrgsRepository repo = OrgsRepository.getInstance();
        liveData = repo.getOrgRVItem();
    }

    public MutableLiveData<ArrayList<OrganizationRVItem>> getAllOrgs() {
        return liveData;
    }

    public MutableLiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }

}
