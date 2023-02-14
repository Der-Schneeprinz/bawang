package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;
import com.merah.bawang.viewmodel.recyclervieworganizations.OrgsAdapter;
import com.merah.bawang.viewmodel.recyclervieworganizations.ViewModelOrgs;

import java.util.ArrayList;
import java.util.Objects;

public class OrgsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<OrganizationRVItem> organizationRVItems = new ArrayList<>();
    private ViewModelOrgs viewModel;
    private ProgressBar progressBar;

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

        progressBar = view.findViewById(R.id.progressBar);

        recyclerView = view.findViewById(R.id.recyclerView);
        OrgsAdapter adapter = new OrgsAdapter(getContext(), organizationRVItems);

        viewModel = new ViewModelProvider(this).get(ViewModelOrgs.class);
        viewModel.getAllOrgs().observe(getViewLifecycleOwner(), adapter::updateOrgs);
        viewModel.getIsUpdating().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.smoothScrollToPosition(Objects.requireNonNull(viewModel.getAllOrgs().getValue()).size()-1);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}