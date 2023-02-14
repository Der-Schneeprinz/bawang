package com.merah.bawang.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.R;
import com.merah.bawang.model.User;
import com.merah.bawang.model.UserRVItem;

import java.util.ArrayList;

public class ProfileRepository {

    private static final String TAG = "ProfileRepository";
    private static ProfileRepository instance;
    private ArrayList<UserRVItem> userRVItems = new ArrayList<>();

    public static ProfileRepository getInstance() {
        if(instance == null)
            instance = new ProfileRepository();
        return instance;
    }

    public MutableLiveData<ArrayList<UserRVItem>> getProfiles() {
        setUsers();
        MutableLiveData<ArrayList<UserRVItem>> userRVItems = new MutableLiveData<>();
        userRVItems.setValue(this.userRVItems);
        return userRVItems;
    }

    private void setUsers() {
        Log.i(TAG, "setUsers has been called");
        String[] fullNames = {"John Doe", "Joan Doe", "Juan Dela Cruz", "Juana Dela Cruz", "Jean D'Arc", "Jeanne D'Arc"};
        for (int i = 0; i < fullNames.length; i++)
            userRVItems.add(new UserRVItem(
                    new User(""),
                    R.drawable.ic_baseline_account_circle_24,
                    fullNames[i]
            ));
    }

}
