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

import com.merah.bawang.model.PostRVItem;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.homescreen.fragments.ViewModelHomeFragment;
import com.merah.bawang.viewmodel.recyclerviewposts.PostAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ViewModelHomeFragment viewModel;
    private final ArrayList<PostRVItem> postRVItems = new ArrayList<>();
    private PostAdapter adapter;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_circular);

        adapter = new PostAdapter(getContext(), postRVItems);
        viewModel = new ViewModelProvider(this).get(ViewModelHomeFragment.class);
        viewModel.init();
        /*viewModel.getAllPosts().observe(getViewLifecycleOwner(), new Observer<ArrayList<PostRVItem>>() {
            @Override
            public void onChanged(ArrayList<PostRVItem> postRVItems) {
                adapter.updatePosts(postRVItems);
            }
        });*/
        viewModel.getAllPosts().observe(getViewLifecycleOwner(), adapter::updatePosts);
        /*viewModel.getIsUpdating().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                    recyclerView.smoothScrollToPosition(viewModel.getAllPosts().getValue().size()-1);
                }
            }
        });*/
        viewModel.getIsUpdating().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.smoothScrollToPosition(Objects.requireNonNull(viewModel.getAllPosts().getValue()).size()-1);
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

}