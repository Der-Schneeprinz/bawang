package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;
import com.merah.bawang.viewmodel.recyclervieworganizations.OrgsAdapter;

import java.util.ArrayList;

public class OrgsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<OrganizationRVItem> organizationRVItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orgs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupOrganizationRVItemContent();
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        OrgsAdapter orgsAdapter = new OrgsAdapter(getContext(), organizationRVItems);
        recyclerView.setAdapter(orgsAdapter);
        orgsAdapter.notifyDataSetChanged();

    }

    private void setupOrganizationRVItemContent() {
        String[] orgNames = getResources().getStringArray(R.array.saOrgs);
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