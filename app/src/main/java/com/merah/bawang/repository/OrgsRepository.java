package com.merah.bawang.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;

import java.util.ArrayList;

public class OrgsRepository {

    private static final String TAG = "OrgsRepository";
    private static OrgsRepository instance;
    private ArrayList<OrganizationRVItem> organizationRVItems = new ArrayList<>();

    public static OrgsRepository getInstance() {
        if(instance == null)
            instance = new OrgsRepository();
        return instance;
    }

    public MutableLiveData<ArrayList<OrganizationRVItem>> getOrgRVItem() {
        setOrgs();
        MutableLiveData<ArrayList<OrganizationRVItem>> organizationRVItems = new MutableLiveData<>();
        organizationRVItems.setValue(this.organizationRVItems);
        return organizationRVItems;
    }

    private void setOrgs() {
        Log.i(TAG, "setOrgs has been called.");
        String[] orgNames = {"PUP Sintang Pusa", "PUP Sintang Aso"};
        for (String orgName : orgNames) {
            organizationRVItems.add(new OrganizationRVItem(
                    "",
                    R.drawable.baseline_groups_2_24,
                    orgName,
                    "Not a Member"
            ));
        }
    }
}
