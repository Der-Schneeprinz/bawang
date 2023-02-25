package com.merah.bawang.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.R;
import com.merah.bawang.model.user.User;
import com.merah.bawang.model.UserRVItem;
import com.merah.bawang.model.UserSelfProfileItem;

import java.util.ArrayList;

public class ProfileRepository {

    private static final String TAG = "ProfileRepository";
    private static ProfileRepository instance;
    private final ArrayList<UserRVItem> userRVItems = new ArrayList<>();
    private final UserSelfProfileItem userSelfProfileItem = new UserSelfProfileItem(new User(""));

    public static ProfileRepository getInstance() {
        if(instance == null)
            instance = new ProfileRepository();
        return instance;
    }

    // GETTERS

    public MutableLiveData<ArrayList<UserRVItem>> getProfiles() {
        setUsers();
        MutableLiveData<ArrayList<UserRVItem>> userRVItems = new MutableLiveData<>();
        userRVItems.setValue(this.userRVItems);
        return userRVItems;
    }

    public MutableLiveData<UserSelfProfileItem> getSelfProfile() {
        setSelfUser();
        MutableLiveData<UserSelfProfileItem> userSelfProfileItem = new MutableLiveData<>();
        userSelfProfileItem.setValue(this.userSelfProfileItem);
        return userSelfProfileItem;
    }

    // SETTERS

    private void setUsers() {
        Log.i(TAG, "setUsers has been called");
        String[] fullNames = {"John Doe", "Joan Doe", "Juan Dela Cruz", "Juana Dela Cruz", "Jean D'Arc", "Jeanne D'Arc"};
        for (String fullName : fullNames)
            userRVItems.add(new UserRVItem(
                    new User(""),
                    R.drawable.ic_baseline_account_circle_24,
                    fullName
            ));
    }

    private void setSelfUser() {
        Log.i(TAG, "setSelfUser has been called.");
        userSelfProfileItem.setProfile(R.drawable.ic_baseline_account_circle_24);
        userSelfProfileItem.setFullName("Johanna Dupont");
        userSelfProfileItem.setEmail("jdupont@iskolarngbayan.pup.edu.ph");
        userSelfProfileItem.setSex("Female");
        userSelfProfileItem.setBirthdate("01/01/1999");
        userSelfProfileItem.setStudentNo("1999-99999-MN-9");
    }

}
